package com.borisavz.fakultetback.repository;

import com.borisavz.fakultetback.entity.Fakultet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FakultetRepository extends JpaRepository<Fakultet, Long> {
}
