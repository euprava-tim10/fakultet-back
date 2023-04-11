package com.borisavz.fakultetback.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class KvotaSmer {

    @Id
    @GeneratedValue
    private long id;

    private int kvota;

    @ManyToOne
    private Smer smer;
}
