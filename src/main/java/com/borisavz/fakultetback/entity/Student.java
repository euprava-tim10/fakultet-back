package com.borisavz.fakultetback.entity;

import com.borisavz.fakultetback.enums.NivoStudija;
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

    public NivoStudija getMaxNivoStudija() {
        NivoStudija maxNivoStudija = null;

        for(StatusStudija s : statusStudija) {
            if(s.getDatumZavrsetka() != null
                && s.getSmer().getNivoStudija().veciOd(maxNivoStudija)) {
                maxNivoStudija = s.getSmer().getNivoStudija();
            }
        }

        return maxNivoStudija;
    }
}
