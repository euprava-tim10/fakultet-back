package com.borisavz.fakultetback.entity;

import com.borisavz.fakultetback.enums.StatusKonkursa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Konkurs {

    @Id
    @GeneratedValue
    private long id;
    private StatusKonkursa statusKonkursa;

    @OneToMany
    private List<KvotaSmer> kvote;
}
