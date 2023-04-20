package com.borisavz.fakultetback.entity;

import com.borisavz.fakultetback.enums.StatusPrijave;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class PrijavaKonkurs {

    @Id
    @GeneratedValue
    private long id;

    private float prosek;

    @ManyToOne
    private Konkurs konkurs;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Smer prvaZelja;

    private StatusPrijave statusPrijave;
}
