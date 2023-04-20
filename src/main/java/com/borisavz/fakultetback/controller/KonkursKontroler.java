package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.entity.Konkurs;
import com.borisavz.fakultetback.entity.PrijavaKonkurs;
import com.borisavz.fakultetback.entity.Smer;
import com.borisavz.fakultetback.security.permission.IsStudent;
import com.borisavz.fakultetback.service.KonkursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/konkursi")
public class KonkursKontroler {

    @Autowired
    private KonkursService konkursService;

    @GetMapping
    @IsStudent
    public List<Konkurs> getKonkursi() {
        return konkursService.getKonkursi();
    }

    @GetMapping("/{id}/dozvoljeniSmerovi")
    @IsStudent
    public List<Smer> getDozvoljeniSmerovi(
            @PathVariable long id
    ) {
        return konkursService.getDozvoljeniSmerovi(id);
    }

    @PostMapping("/{id}/prijave")
    @IsStudent
    public long postPrijava(
            @PathVariable long id,
            @RequestBody PrijavaKonkurs prijavaKonkurs
    ) {
        return konkursService.kreirajPrijavu(id, prijavaKonkurs);
    }
}
