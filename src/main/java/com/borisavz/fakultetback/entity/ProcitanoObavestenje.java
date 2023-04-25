package com.borisavz.fakultetback.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProcitanoObavestenje {

    @Id
    private long studentId;

    private Date procitano;
}
