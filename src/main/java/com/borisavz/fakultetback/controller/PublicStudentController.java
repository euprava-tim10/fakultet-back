package com.borisavz.fakultetback.controller;

import com.borisavz.fakultetback.dto.FakultetDiplomaDTO;
import com.borisavz.fakultetback.service.PublicStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/studenti")
public class PublicStudentController {

    @Autowired
    private PublicStudentService publicStudentService;

    @GetMapping("/{jmbg}/diplome")
    public List<FakultetDiplomaDTO> getDiplomeStudenta(@PathVariable String jmbg) {
        return publicStudentService.getDiplomeStudenta(jmbg);
    }
}
