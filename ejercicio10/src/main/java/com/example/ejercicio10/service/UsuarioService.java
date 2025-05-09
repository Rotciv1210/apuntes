package com.example.ejercicio10.service;

import com.example.ejercicio10.model.Usuario;
import com.example.ejercicio10.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;


    public List<Usuario> buscarporNombreoApellido(String query){

        return usuarioRepo.findByNombreContainingIgnoreCaseOrPrimerApellidoContainingIgnoreCase(query, query);
    }
}
