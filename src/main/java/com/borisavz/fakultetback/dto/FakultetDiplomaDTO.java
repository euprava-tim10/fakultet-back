package com.borisavz.fakultetback.dto;

import com.borisavz.fakultetback.entity.StatusStudija;
import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakultetDiplomaDTO {

    private String firstName;
    private String lastName;
    private String jmbg;
    private String facultyName;
    private String courseName;
    private String profession;
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
                .profession(statusStudija.getSmer().getOblast().toString())
                .level(statusStudija.getSmer().getNivoStudija().toString())
                .gpa((double) statusStudija.getProsek())
                .date(statusStudija.getDatumZavrsetka())
                .build();
    }
}
