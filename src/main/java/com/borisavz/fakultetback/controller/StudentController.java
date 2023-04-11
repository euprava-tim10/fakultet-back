package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.entity.PrijavaKonkurs;
import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/studenti")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        return null;
    }

    @GetMapping("/{id}/prijave")
    public PrijavaKonkurs getStudentovePrijaveKonkurs(@PathVariable long id) {
        return null;
    }

    @GetMapping("/{studentId}/prijave/{prijavaId}/prihvati")
    public void prihvatiPrijavu(@PathVariable long studentId, @PathVariable long prijavaId) {

    }

    @GetMapping("/{studentId}/prijave/{prijavaId}/odbij")
    public void odbijPrijavu(@PathVariable long studentId, @PathVariable long prijavaId) {

    }
}
