package com.dam.croaciaRoles.service;

import com.dam.croaciaRoles.model.Usuario;
import com.dam.croaciaRoles.model.enums.Rol;
import com.dam.croaciaRoles.repo.UsuarioRepo;
import com.dam.croaciaRoles.utils.PasswordUtil;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {


    //login
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepo usuarioRepo;


    //metodo para guardar usuario con la contraseña encriptada

    public Usuario guardarUsuario(Usuario usuario, HttpSession session){

        //obtenemos la contraseña del formulario de registro de usuario
        String password = PasswordUtil.codificarPassword(usuario.getPassword());

        //establecemos la contraseña encriptada para el usuario
        usuario.setPassword(password);

        //le damos un rol al usuario
        usuario.setRol(Rol.USER);

        //guardamos al usuario en la bbdd y lo devolvemos por si queremos almacenarlo en una sesion
        Usuario usuarioAlta = usuarioRepo.save(usuario);

        //Creamos dos variables de sesion , una para el nombre de usuario y otra para el Rol
        session.setAttribute("username", usuarioAlta.getUsername());
        session.setAttribute("rol",usuarioAlta.getRol());

        return usuarioAlta;
    }

    //metodo para el login
    public boolean login(String username, String passwordTextoPlano, HttpSession session){

        //tenemos que crear en el repo el metodo de buscar por username y luego implementarlo
        Optional<Usuario> usuarioOptional = usuarioRepo.findByUsername(username);

        if(usuarioOptional.isPresent()){

            Usuario usuario = usuarioOptional.get();
            session.setAttribute("username",usuario.getUsername());
            session.setAttribute("rol",usuario.getRol().name());

            LOG.info("Usuario dentro de la sesion", usuario.getUsername());
            return PasswordUtil.verificarPassword(passwordTextoPlano, usuario.getPassword());

        }

        return false;
    }

}
