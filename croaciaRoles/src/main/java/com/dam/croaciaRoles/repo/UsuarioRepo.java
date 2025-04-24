package com.dam.croaciaRoles.repo;

import com.dam.croaciaRoles.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByUsername(String username);
}
