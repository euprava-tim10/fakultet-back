package com.borisavz.fakultetback.entity;

import com.borisavz.fakultetback.enums.NivoStudija;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Smer {

    @Id
    @GeneratedValue
    private long id;

    private String naziv;

    private NivoStudija nivoStudija;

    @ManyToOne(fetch = FetchType.LAZY)
    private Fakultet fakultet;
}
