package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.dto.ZavrsiStudijeDTO;
import com.borisavz.fakultetback.entity.Obavestenje;
import com.borisavz.fakultetback.entity.PrijavaKonkurs;
import com.borisavz.fakultetback.entity.StatusStudija;
import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.enums.StatusPrijave;
import com.borisavz.fakultetback.exception.core.NotAllowedException;
import com.borisavz.fakultetback.repository.ObavestenjeRepository;
import com.borisavz.fakultetback.repository.PrijavaKonkursRepository;
import com.borisavz.fakultetback.repository.StatusStudijaRepository;
import com.borisavz.fakultetback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.borisavz.fakultetback.security.AuthHelper.authUser;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StatusStudijaRepository statusStudijaRepository;

    @Autowired
    private PrijavaKonkursRepository prijavaKonkursRepository;

    @Autowired
    private ObavestenjeRepository obavestenjeRepository;

    public Student getStudent(long id) {
        return studentRepository.getById(id);
    }

    public List<StatusStudija> getStudentStatusiStudija(long id) {
        return statusStudijaRepository.getStatusStudijaByStudentId(id);
    }

    public void zavrsiStudije(long studentId, long statusStudijaId, ZavrsiStudijeDTO zavrsiStudijeDTO) {
        StatusStudija oldStatusStudija = statusStudijaRepository.getById(statusStudijaId);

        oldStatusStudija.setProsek(zavrsiStudijeDTO.getProsek());
        oldStatusStudija.setDatumZavrsetka(LocalDate.now());

        statusStudijaRepository.save(oldStatusStudija);
    }

    public List<PrijavaKonkurs> getStudentovePrijaveKonkurs(long studentId) {
        if(studentId != authUser().getId())
            throw new NotAllowedException();

        return prijavaKonkursRepository.getAktivnePrijaveStudenta(studentId);
    }

    public void prihvatiPrijavu(@PathVariable long studentId, @PathVariable long prijavaId) {
        Student student = studentRepository.getById(studentId);
        PrijavaKonkurs prijavaKonkurs = prijavaKonkursRepository.getById(prijavaId);

        if(!StatusPrijave.PRIMLJEN_UPIS.equals(prijavaKonkurs.getStatusPrijave()))
            throw new NotAllowedException();

        prijavaKonkurs.setStatusPrijave(StatusPrijave.PRIHVACENA);

        StatusStudija statusStudija = new StatusStudija();

        statusStudija.setDatumUpisa(LocalDate.now());
        statusStudija.setSmer(prijavaKonkurs.getPrvaZelja());
        statusStudija.setStudent(student);

        Obavestenje obavestenje = Obavestenje.builder()
                .student(prijavaKonkurs.getStudent())
                .datumKreiranja(new Date())
                .tekst("Cestitamo na upisu! Jos uvek nije kasno da odustanete i sacuvate svoje mentalno zdravlje.")
                .link("")
                .build();

        obavestenjeRepository.save(obavestenje);

        prijavaKonkursRepository.save(prijavaKonkurs);
        statusStudijaRepository.save(statusStudija);
    }

    public void odbijPrijavu(@PathVariable long studentId, @PathVariable long prijavaId) {
        PrijavaKonkurs prijavaKonkurs = prijavaKonkursRepository.getById(prijavaId);

        if(!StatusPrijave.PRIMLJEN_UPIS.equals(prijavaKonkurs.getStatusPrijave()))
            throw new NotAllowedException();

        prijavaKonkurs.setStatusPrijave(StatusPrijave.ODBIJENA);

        prijavaKonkursRepository.save(prijavaKonkurs);
    }
}
