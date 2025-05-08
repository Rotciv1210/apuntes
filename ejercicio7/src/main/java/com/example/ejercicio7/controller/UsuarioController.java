package com.example.ejercicio7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/*Crea una aplicación con Spring Boot que sirva para hacer Log In de un usuario. P
asa el email a través de un query string.
Si el email es "pepe@es.es" devolver un JSON con clave "success"  y valor "usuario válido" ,
 caso contrario, clave  "error" valor  "Usuario no válido"*/
@RestController
public class UsuarioController {



    @GetMapping("/ejercicio7")
    public Map<String, String> login(@RequestParam String email){

        Map<String, String> mapa = new HashMap<>();

        System.out.println(email);

        if(email.equals("pepe@es.es")){

            mapa.put("success", "usuario valido");
        } else {

            mapa.put("error", "usuario no valido");
        }

        return mapa;
    }
}
