package com.borisavz.fakultetback.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Obavestenje {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Student student;

    private String tekst;
    private String link;
    private Date datumKreiranja;
}
