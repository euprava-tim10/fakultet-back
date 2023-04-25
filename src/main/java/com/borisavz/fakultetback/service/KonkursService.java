package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.entity.*;
import com.borisavz.fakultetback.enums.NivoStudija;
import com.borisavz.fakultetback.enums.StatusKonkursa;
import com.borisavz.fakultetback.enums.StatusPrijave;
import com.borisavz.fakultetback.exception.core.NotAllowedException;
import com.borisavz.fakultetback.repository.KonkursRepository;
import com.borisavz.fakultetback.repository.PrijavaKonkursRepository;
import com.borisavz.fakultetback.repository.SmerRepository;
import com.borisavz.fakultetback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.borisavz.fakultetback.security.AuthHelper.authUser;

@Service
@Transactional
public class KonkursService {

    @Autowired
    private KonkursRepository konkursRepository;

    @Autowired
    private PrijavaKonkursRepository prijavaKonkursRepository;

    @Autowired
    private SmerRepository smerRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Konkurs> getKonkursi() {
        return konkursRepository.getAktivniKonkursi();
    }

    public Konkurs getKonkurs(long konkursId) {
        return konkursRepository.getById(konkursId);
    }

    public List<PrijavaKonkurs> getKonkursPrijavePoSmeru(long konkursId, long smerId) {
        return prijavaKonkursRepository.getPrijavePoSmeru(konkursId, smerId);
    }

    public List<Smer> getDozvoljeniSmerovi(long konkursId) {
        Konkurs konkurs = konkursRepository.getById(konkursId);
        Student student = studentRepository.getById(authUser().getId());

        NivoStudija maxNivo = student.getMaxNivoStudija();

        List<Smer> dozvoljeniSmerovi = new ArrayList<>();

        //TODO: srednja provera

        if(maxNivo == null) {
            for(KvotaSmer kvotaSmer : konkurs.getKvote()) {
                if(NivoStudija.OSNOVNE.equals(kvotaSmer.getSmer().getNivoStudija()))
                    dozvoljeniSmerovi.add(kvotaSmer.getSmer());
            }
        } else {
            for(KvotaSmer kvotaSmer : konkurs.getKvote()) {
                if(kvotaSmer.getSmer().getNivoStudija().ordinal() <= maxNivo.ordinal())
                    dozvoljeniSmerovi.add(kvotaSmer.getSmer());
            }
        }

        return dozvoljeniSmerovi;
    }

    public long kreirajPrijavu(long konkursId, PrijavaKonkurs prijavaKonkurs) {
        //TODO: ne sme dve prijave na isti konkurs!
        Student student = studentRepository.getById(authUser().getId());
        Konkurs konkurs = konkursRepository.getById(konkursId);

        Smer smer = smerRepository.getById(prijavaKonkurs.getPrvaZelja().getId());

        prijavaKonkurs.setStudent(student);
        prijavaKonkurs.setKonkurs(konkurs);
        prijavaKonkurs.setStatusPrijave(StatusPrijave.NA_CEKANJU);

        switch (smer.getNivoStudija()) {
            case OSNOVNE:
                //TODO: provera srednja skola, prosek
                prijavaKonkurs.setProsek(5);
                break;
            case MASTER:
                StatusStudija zavrseneOsnovne = zavrseniNivoSaNajvecimProsekom(student.getStatusStudija(), NivoStudija.OSNOVNE);

                if(zavrseneOsnovne == null)
                    throw new NotAllowedException();

                prijavaKonkurs.setProsek(zavrseneOsnovne.getProsek());
                break;
            case DOKTORSKE:
                StatusStudija zavrseneMaster = zavrseniNivoSaNajvecimProsekom(student.getStatusStudija(), NivoStudija.MASTER);

                if(zavrseneMaster == null)
                    throw new NotAllowedException();

                prijavaKonkurs.setProsek(zavrseneMaster.getProsek());
                break;
        }

        prijavaKonkursRepository.save(prijavaKonkurs);

        return prijavaKonkurs.getId();
    }

    private StatusStudija zavrseniNivoSaNajvecimProsekom(List<StatusStudija> statusiStudija, NivoStudija nivoStudija) {
        float maxProsek = 0;
        StatusStudija statusStudijaMax = null;

        for(StatusStudija statusStudija : statusiStudija) {
            if(statusStudija.getDatumZavrsetka() != null
                    && nivoStudija.equals(statusStudija.getSmer().getNivoStudija())
                    && statusStudija.getProsek() > maxProsek) {
                maxProsek = statusStudija.getProsek();
                statusStudijaMax = statusStudija;
            }
        }

        return statusStudijaMax;
    }

    public void okoncajPrijave(long konkursId) {
        Konkurs konkurs = konkursRepository.getById(konkursId);

        konkurs.setStatusKonkursa(StatusKonkursa.ZATVORENE_PRIJAVE);

        konkursRepository.save(konkurs);

        for(KvotaSmer kvotaSmer : konkurs.getKvote()) {
            List<PrijavaKonkurs> topPrijave = prijavaKonkursRepository.getTopNPrijavePoSmeru(konkursId, kvotaSmer.getSmer().getId(), kvotaSmer.getKvota());

            for(PrijavaKonkurs prijavaKonkurs : topPrijave) {
                prijavaKonkurs.setStatusPrijave(StatusPrijave.PRIMLJEN_UPIS);

                prijavaKonkursRepository.save(prijavaKonkurs);
            }
        }
    }

    public void okoncajKonkurs(long konkursId) {
        Konkurs konkurs = konkursRepository.getById(konkursId);

        konkurs.setStatusKonkursa(StatusKonkursa.ZATVOREN);

        konkursRepository.save(konkurs);
    }
}