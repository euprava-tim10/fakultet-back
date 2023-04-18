package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.dto.ZavrsiStudijeDTO;
import com.borisavz.fakultetback.entity.StatusStudija;
import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.repository.StatusStudijaRepository;
import com.borisavz.fakultetback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StatusStudijaRepository statusStudijaRepository;

    public Student getStudent(long id) {
        return studentRepository.getById(id);
    }

    //TODO: security checks
    public void zavrsiStudije(long studentId, long statusStudijaId, ZavrsiStudijeDTO zavrsiStudijeDTO) {
        StatusStudija oldStatusStudija = statusStudijaRepository.getById(statusStudijaId);

        oldStatusStudija.setProsek(zavrsiStudijeDTO.getProsek());
        oldStatusStudija.setDatumZavrsetka(LocalDate.now());

        statusStudijaRepository.save(oldStatusStudija);
    }
}
