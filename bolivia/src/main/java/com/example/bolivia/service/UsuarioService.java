package com.example.bolivia.service;

import com.example.bolivia.model.Usuario;
import com.example.bolivia.model.dtos.UsuarioDTO;
import com.example.bolivia.model.utils.UsuarioToUsuarioDtoConversor;
import com.example.bolivia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO guardarUsuario(Usuario usuario){

        return UsuarioToUsuarioDtoConversor.convertirUsuario(usuarioRepository.save(usuario));
    }

    //lista de usuarios para el formulario
    public List<UsuarioDTO> listaUsuarios(){
        return UsuarioToUsuarioDtoConversor.convertirUsuarios(usuarioRepository.findAll());
    }//ahora creamos otro controlador con los perfiles

    //metodo de login
    public Usuario login(String username, String password){
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }

    public Usuario buscarporID(Long id){

        return usuarioRepository.findById(id).orElse(null);
    }
}
