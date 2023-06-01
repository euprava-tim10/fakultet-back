package com.borisavz.fakultetback.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
