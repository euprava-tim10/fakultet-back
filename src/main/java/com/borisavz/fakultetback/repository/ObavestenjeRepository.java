package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.Obavestenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ObavestenjeRepository extends JpaRepository<Obavestenje, Long> {

    @Query("SELECT o FROM Obavestenje o " +
            "WHERE o.student.id = ?1")
    List<Obavestenje> getByStudentId(long studentId);

    @Query("SELECT COUNT(o) FROM Obavestenje o " +
            "WHERE o.student.id = ?1 " +
            "AND o.datumKreiranja > ?2")
    int getBrojNeprocitanih(long studentId, Date procitano);
}
