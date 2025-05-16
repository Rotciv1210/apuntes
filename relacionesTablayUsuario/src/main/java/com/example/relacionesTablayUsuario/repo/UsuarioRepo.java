package com.example.relacionesTablayUsuario.repo;

import com.example.relacionesTablayUsuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByUsername(String username);
}
