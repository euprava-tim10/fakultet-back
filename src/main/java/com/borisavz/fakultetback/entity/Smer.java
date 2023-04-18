package com.borisavz.fakultetback.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Fakultet fakultet;
}
