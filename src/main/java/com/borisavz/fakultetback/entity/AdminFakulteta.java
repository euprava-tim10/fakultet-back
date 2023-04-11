package com.borisavz.fakultetback.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class AdminFakulteta {

    @Id
    @GeneratedValue
    private long id;
    private String ime;
    private String prezime;
}
