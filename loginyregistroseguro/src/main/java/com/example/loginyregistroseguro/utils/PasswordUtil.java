package com.example.loginyregistroseguro.utils;

import com.example.loginyregistroseguro.model.Usuario;
import com.example.loginyregistroseguro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private  static  final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    //metodo para encriptar la contraseña
    public static String codificarPassword(String rawPassword){

        return encoder.encode(rawPassword);
    }

    //metodo para verificar la contraseña -- Compara la codificada con la raw
    public static boolean verifiedPassword(String rawPassword, String hashedPassword){

        return encoder.matches(rawPassword, hashedPassword);
    }
    //después de hacer esto se hace el método en el service para setear esta contraseña codificada al usuario
    
}