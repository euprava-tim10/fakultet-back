package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.StatusStudija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusStudijaRepository extends JpaRepository<StatusStudija, Long> {

    @Query("SELECT s FROM StatusStudija s WHERE s.student.jmbg = ?1 AND s.datumZavrsetka IS NOT NULL")
    public List<StatusStudija> getDiplomeByStudentJmbg(String jmbg);

    @Query("SELECT s FROM StatusStudija s WHERE s.student.id = ?1")
    public List<StatusStudija> getStatusStudijaByStudentId(long studentId);
}
