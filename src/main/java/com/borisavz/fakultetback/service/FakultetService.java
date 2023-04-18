package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.entity.Fakultet;
import com.borisavz.fakultetback.entity.Konkurs;
import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.repository.FakultetRepository;
import com.borisavz.fakultetback.repository.KonkursRepository;
import com.borisavz.fakultetback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Fakultet getFakultet(long id) {
        return fakultetRepository.getById(id);
    }

    public List<Konkurs> getFakultetKonkursi(long id) {
        return konkursRepository.getKonkursiByFakultetId(id);
    }

    public List<Student> getFakultetStudenti(long id) {
        return studentRepository.getStudentiByFakultet(id);
    }
}
