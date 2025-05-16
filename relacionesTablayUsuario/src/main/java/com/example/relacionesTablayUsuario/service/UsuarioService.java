package com.example.relacionesTablayUsuario.service;

import com.example.relacionesTablayUsuario.model.Usuario;
import com.example.relacionesTablayUsuario.repo.UsuarioRepo;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuario altaUsuario(Usuario usuario){

        return usuarioRepo.save(usuario);
    }

    public void loginUsuario(String email, HttpSession session, HttpServletResponse response) throws IOException {

        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);

        if(usuario.isPresent()){
            //asi se almacena el id en la sesion
            session.setAttribute("usuarioID", usuario.get().getId());
            response.sendRedirect("/usuario/home");
        }

        response.sendRedirect("/login");


    }

    public Usuario buscarPorUsuario(String username){

        Optional<Usuario> usuario = usuarioRepo.findByUsername(username);

        if(usuario.isPresent()){

            return usuario.get();
        }
        return null;
    }
}
