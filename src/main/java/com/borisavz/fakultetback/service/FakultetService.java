package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.entity.*;
import com.borisavz.fakultetback.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class FakultetService {

    @Autowired
    private FakultetRepository fakultetRepository;

    @Autowired
    private KonkursRepository konkursRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SmerRepository smerRepository;

    @Autowired
    private KvotaSmerRepository kvotaSmerRepository;

    public Fakultet getFakultet(long id) {
        return fakultetRepository.getById(id);
    }

    public List<Konkurs> getFakultetKonkursi(long id) {
        return konkursRepository.getKonkursiByFakultetId(id);
    }

    public long raspisiKonkurs(long fakultetId, Konkurs konkurs) {
        Fakultet fakultet = fakultetRepository.getById(fakultetId);

        konkurs.setFakultet(fakultet);
        konkurs.setDatumRaspisivanja(LocalDate.now());

        for(KvotaSmer kvotaSmer : konkurs.getKvote()) {
            kvotaSmerRepository.save(kvotaSmer);
        }

        konkursRepository.save(konkurs);

        return konkurs.getId();
    }

    public List<Student> getFakultetStudenti(long id) {
        return studentRepository.getStudentiByFakultet(id);
    }

    public List<Smer> getFakultetSmerovi(long id) {
        return smerRepository.getSmeroviByFakultet(id);
    }
}
