package com.borisavz.fakultetback.dto;

import com.borisavz.fakultetback.entity.StatusStudija;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
public class FakultetDiplomaDTO {

    private String firstName;
    private String lastName;
    private String jmbg;
    private String facultyName;
    private String courseName;
    private String level;
    private Double gpa;
    private LocalDate date;

    public static FakultetDiplomaDTO fromStatusStudija(StatusStudija statusStudija) {
        return FakultetDiplomaDTO.builder()
                .firstName(statusStudija.getStudent().getIme())
                .lastName(statusStudija.getStudent().getPrezime())
                .jmbg(statusStudija.getStudent().getJmbg())
                .facultyName(statusStudija.getSmer().getFakultet().getNaziv())
                .courseName(statusStudija.getSmer().getNaziv())
                .level(statusStudija.getSmer().getNivoStudija().toString())
                .gpa((double) statusStudija.getProsek())
                .date(statusStudija.getDatumZavrsetka())
                .build();
    }
}