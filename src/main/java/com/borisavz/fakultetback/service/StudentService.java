package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(long id) {
        return studentRepository.getById(id);
    }
}
