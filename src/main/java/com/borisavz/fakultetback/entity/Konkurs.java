package com.borisavz.fakultetback.entity;

import com.borisavz.fakultetback.enums.StatusKonkursa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Konkurs {

    @Id
    @GeneratedValue
    private long id;
    private StatusKonkursa statusKonkursa;

    @ManyToOne
    private Fakultet fakultet;

    @OneToMany
    private List<KvotaSmer> kvote;
}
