package com.example.relacionesTablayUsuario.repo;

import com.example.relacionesTablayUsuario.model.Aficion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AficionRepo extends JpaRepository<Aficion, Integer> {
}
