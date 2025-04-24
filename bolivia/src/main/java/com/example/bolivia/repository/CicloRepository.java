package com.example.bolivia.repository;

import com.example.bolivia.model.Ciclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, Integer> {
}
