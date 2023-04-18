package com.borisavz.fakultetback.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;
    private String ime;
    private String prezime;

    @OneToMany(fetch = FetchType.LAZY)
    private List<StatusStudija> statusStudija;
}
