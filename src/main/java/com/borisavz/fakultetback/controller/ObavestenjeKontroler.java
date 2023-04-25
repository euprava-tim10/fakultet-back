package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.entity.Obavestenje;
import com.borisavz.fakultetback.security.permission.IsStudent;
import com.borisavz.fakultetback.service.ObavestenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/obavestenja")
public class ObavestenjeKontroler {

    @Autowired
    private ObavestenjeService obavestenjeService;

    @GetMapping
    @IsStudent
    public List<Obavestenje> getObavestenja() {
        return obavestenjeService.getObavestenja();
    }

    @GetMapping("/brojNeprocitanih")
    @IsStudent
    public int getBrojNeprocitanihObavestenja() {
        return obavestenjeService.getBrojNeprocitanihObavestenja();
    }
}
