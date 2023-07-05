package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.dto.ZavrsiStudijeDTO;
import com.borisavz.fakultetback.entity.PrijavaKonkurs;
import com.borisavz.fakultetback.entity.StatusStudija;
import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.security.permission.IsAdmin;
import com.borisavz.fakultetback.security.permission.IsStudent;
import com.borisavz.fakultetback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studenti")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/{id}/statusiStudija")
    public List<StatusStudija> getStudentStatusiStudija(@PathVariable long id) {
        return studentService.getStudentStatusiStudija(id);
    }

    @PutMapping("/{studentId}/statusiStudija/{statusStudijaId}/zavrsi")
    @IsAdmin
    public void zavrsiStudije(
            @PathVariable long studentId,
            @PathVariable long statusStudijaId,
            @RequestBody ZavrsiStudijeDTO zavrsiStudijeDTO
    ) {
        studentService.zavrsiStudije(studentId, statusStudijaId, zavrsiStudijeDTO);
    }

    @GetMapping("/{id}/prijave")
    @IsStudent
    public List<PrijavaKonkurs> getStudentovePrijaveKonkurs(@PathVariable long id) {
        return studentService.getStudentovePrijaveKonkurs(id);
    }

    @PutMapping("/{studentId}/prijave/{prijavaId}/prihvati")
    @IsStudent
    public void prihvatiPrijavu(@PathVariable long studentId, @PathVariable long prijavaId) {
        studentService.prihvatiPrijavu(studentId, prijavaId);
    }

    @PutMapping("/{studentId}/prijave/{prijavaId}/odbij")
    @IsStudent
    public void odbijPrijavu(@PathVariable long studentId, @PathVariable long prijavaId) {
        studentService.odbijPrijavu(studentId, prijavaId);
    }
}
