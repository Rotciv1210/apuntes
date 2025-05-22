package com.example.repasoTablasDTO.repo;

import com.example.repasoTablasDTO.model.Incidencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciaRepo extends JpaRepository<Incidencias, Integer> {
}
