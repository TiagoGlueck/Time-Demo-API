package com.time.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.time.demo.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}
