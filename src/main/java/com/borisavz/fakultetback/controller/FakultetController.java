package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.entity.Fakultet;
import com.borisavz.fakultetback.entity.Konkurs;
import com.borisavz.fakultetback.entity.Smer;
import com.borisavz.fakultetback.entity.Student;
import com.borisavz.fakultetback.security.permission.IsAdmin;
import com.borisavz.fakultetback.service.FakultetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fakulteti")
public class FakultetController {

    @Autowired
    private FakultetService fakultetService;

    @GetMapping("/{id}")
    public Fakultet getFakultet(@PathVariable long id) {
        return fakultetService.getFakultet(id);
    }

    @GetMapping("/{id}/konkursi")
    @IsAdmin
    public List<Konkurs> getFakultetKonkursi(@PathVariable long id) {
        return fakultetService.getFakultetKonkursi(id);
    }

    @PostMapping("/{id}/konkursi")
    public long postFakultetKonkursi(@PathVariable long id, @RequestBody Konkurs konkurs) {
        return fakultetService.raspisiKonkurs(id, konkurs);
    }

    @GetMapping("/{id}/studenti")
    @IsAdmin
    public List<Student> getFakultetStudenti(@PathVariable long id) {
        return fakultetService.getFakultetStudenti(id);
    }

    @GetMapping("/{id}/smerovi")
    public List<Smer> getFakultetSmerovi(@PathVariable long id) {
        return fakultetService.getFakultetSmerovi(id);
    }
}
