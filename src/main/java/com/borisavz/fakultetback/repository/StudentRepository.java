package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT DISTINCT s FROM Student s" +
            " INNER JOIN s.statusStudija st" +
            " WHERE st.smer.fakultet.id = ?1")
    List<Student> getStudentiByFakultet(long fakultetId);
}
