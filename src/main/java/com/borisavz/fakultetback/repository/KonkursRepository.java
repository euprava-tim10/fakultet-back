package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.Konkurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KonkursRepository extends JpaRepository<Konkurs, Long> {

    @Query("SELECT k FROM Konkurs k WHERE k.fakultet.id = ?1")
    List<Konkurs> getKonkursiByFakultetId(long fakultetId);

    @Query("SELECT k FROM Konkurs k WHERE k.statusKonkursa = com.borisavz.fakultetback.enums.StatusKonkursa.AKTIVAN")
    List<Konkurs> getAktivniKonkursi();
}
