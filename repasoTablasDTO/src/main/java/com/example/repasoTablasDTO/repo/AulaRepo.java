package com.example.repasoTablasDTO.repo;

import com.example.repasoTablasDTO.model.Aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepo extends JpaRepository<Aulas, Integer> {
}
