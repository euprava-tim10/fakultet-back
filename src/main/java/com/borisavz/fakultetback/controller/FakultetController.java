package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.entity.Fakultet;
import com.borisavz.fakultetback.entity.Konkurs;
import com.borisavz.fakultetback.entity.Student;
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
        return null;
    }

    @GetMapping("/{id}/konkursi")
    public List<Konkurs> getFakultetKonkursi(@PathVariable long id) {
        return null;
    }

    @PostMapping("/{id}/konkursi")
    public long postFakultetKonkursi(@PathVariable long id, @RequestBody Konkurs konkurs) {
        return 0;
    }

    @PostMapping("/{fakultetId}/konkursi/{konkursId}/okoncaj")
    public long okoncajKonkurs(@PathVariable long fakultetId, @PathVariable long konkursId, @RequestBody Konkurs konkurs) {
        return 0;
    }

    @GetMapping("/{id}/studenti")
    public List<Student> getFakultetStudenti(@PathVariable long id) {
        return null;
    }
}
