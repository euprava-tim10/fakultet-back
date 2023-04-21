package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.PrijavaKonkurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrijavaKonkursRepository extends JpaRepository<PrijavaKonkurs, Long> {

    @Query("SELECT p FROM PrijavaKonkurs p " +
            "WHERE p.konkurs.statusKonkursa = com.borisavz.fakultetback.enums.StatusKonkursa.ZATVORENE_PRIJAVE " +
            "AND p.statusPrijave =  com.borisavz.fakultetback.enums.StatusPrijave.PRIMLJEN_UPIS " +
            "AND p.student.id = ?1")
    List<PrijavaKonkurs> getAktivnePrijaveStudenta(long studentId);

    @Query("SELECT p FROM PrijavaKonkurs p " +
            "WHERE p.konkurs.id = ?1 " +
            "AND p.prvaZelja.id = ?2 " +
            "ORDER BY p.prosek")
    List<PrijavaKonkurs> getPrijavePoSmeru(long konkursId, long smerId);
}
