package com.example.bolivia.model.utils;

import com.example.bolivia.model.Usuario;
import com.example.bolivia.model.dtos.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioToUsuarioDtoConversor {

    public static UsuarioDTO convertirUsuario(Usuario usuario){
        if(usuario == null) return null;
        return new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail(), usuario.getTelefono(), CicloToCicloDtoConversor.convertirCiclo(usuario.getCiclo()));
    }

    public static List<UsuarioDTO> convertirUsuarios(List<Usuario> usuarios){
        List<UsuarioDTO> usuariosDto = new ArrayList<>();
        for(Usuario usuario: usuarios){
            usuariosDto.add(convertirUsuario(usuario));
        }
        return usuariosDto;
    }

}
