package com.example.ejercicio10.repo;

import com.example.ejercicio10.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {

    List<Usuario> findByNombreContainingIgnoreCaseOrPrimerApellidoContainingIgnoreCase(String nombre, String primerApellido);

}
