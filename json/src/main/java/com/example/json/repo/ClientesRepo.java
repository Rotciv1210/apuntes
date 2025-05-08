package com.example.json.repo;

import com.example.json.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepo extends JpaRepository<Cliente,Integer> {
}
