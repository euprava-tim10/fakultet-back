package com.borisavz.fakultetback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
public class SkolaDiplomaDTO {

    private String firstName;
    private String lastName;
    private String jmbg;
    private String schoolName;
    private String schoolType;
    private String course;
    private Map<Integer, Double> gpa;
    private LocalDate date;
}
