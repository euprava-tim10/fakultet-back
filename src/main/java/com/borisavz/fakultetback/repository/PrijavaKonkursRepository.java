package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.PrijavaKonkurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrijavaKonkursRepository extends JpaRepository<PrijavaKonkurs, Long> {

    @Query("SELECT p FROM PrijavaKonkurs p " +
            "WHERE p.student.id = ?1")
    List<PrijavaKonkurs> getAktivnePrijaveStudenta(long studentId);

    @Query("SELECT p FROM PrijavaKonkurs p " +
            "WHERE p.konkurs.id = ?1 " +
            "AND p.prvaZelja.id = ?2 " +
            "ORDER BY p.prosek")
    List<PrijavaKonkurs> getPrijavePoSmeru(long konkursId, long smerId);

    @Query(value = "SELECT p.* FROM prijava_konkurs p " +
            "WHERE p.konkurs_id = ?1 " +
            "AND p.prva_zelja_id = ?2 " +
            "ORDER BY p.prosek " +
            "LIMIT ?3", nativeQuery = true)
    List<PrijavaKonkurs> getTopNPrijavePoSmeru(long konkursId, long smerId, long n);
}
