package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.Smer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmerRepository extends JpaRepository<Smer, Long> {

    @Query("SELECT s FROM Smer s WHERE s.fakultet.id = ?1")
    List<Smer> getSmeroviByFakultet(long fakultetId);
}
