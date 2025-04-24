package com.example.bolivia.service;

import com.example.bolivia.model.Perfil;
import com.example.bolivia.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

  public void guardarPerfil(Perfil perfil){

      perfilRepository.save(perfil);
  }
}
