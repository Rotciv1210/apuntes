package com.example.loginyregistroseguro.service;

import com.example.loginyregistroseguro.model.Usuario;
import com.example.loginyregistroseguro.repository.UsuarioRepository;
import com.example.loginyregistroseguro.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    //aquí guarda el usuario con la contraseña codificada
    public Usuario guardarUsuario(Usuario usuario){

        //obtenemos la contraseña del formulario de registro y la encriptamos
        String password = PasswordUtil.codificarPassword(usuario.getPassword());
        usuario.setPassword(password);

        return usuarioRepository.save(usuario);
    }


    //implementamos el metodo de finBYUsername del Repo
    public boolean login(String username, String rawPassword){

        Optional<Usuario> usuarioOptional =  usuarioRepository.findByUsername(username);
        //si el usuario existe se convierte en un tipo Usuario y luego se verifica la contraseña
        if(usuarioOptional.isPresent()){

            Usuario usuario = usuarioOptional.get();
            boolean passwordMatch = PasswordUtil.verifiedPassword(rawPassword, usuario.getPassword());
            System.out.println("Contraseña ingresada: " + rawPassword);
            System.out.println("Contraseña almacenada: " + usuario.getPassword());
            System.out.println("¿Contraseñas coinciden?: " + passwordMatch);

            return passwordMatch;

        }
        return false;
    }

    public Optional<Usuario> obtenerPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

}
