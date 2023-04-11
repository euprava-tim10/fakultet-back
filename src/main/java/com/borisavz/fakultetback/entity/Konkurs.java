package com.borisavz.fakultetback.entity;

import com.borisavz.fakultetback.enums.StatusKonkursa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Konkurs {

    @Id
    @GeneratedValue
    private long id;
    private StatusKonkursa statusKonkursa;
}
