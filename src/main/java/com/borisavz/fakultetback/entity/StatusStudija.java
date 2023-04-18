package com.borisavz.fakultetback.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class StatusStudija {

    @Id
    @GeneratedValue
    private long id;
    private LocalDate datumUpisa;
    private LocalDate datumZavrsetka;
    private float prosek;

    @ManyToOne
    private Smer smer;
}
