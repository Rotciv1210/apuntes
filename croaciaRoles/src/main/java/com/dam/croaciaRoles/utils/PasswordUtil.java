package com.dam.croaciaRoles.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //Metodo para encriptar la contraseña

    public static String codificarPassword(String passwordTextoPlano){

        return encoder.encode(passwordTextoPlano);
    }

    //Metodo que compara las contraseñas en texto plano con las encriptadas

    public static boolean verificarPassword(String passwordTextoPlano, String passwordEncriptada){

        return encoder.matches(passwordTextoPlano,passwordEncriptada);
    }


}
