package com.dam.croaciaRoles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErroresController {

    @GetMapping("/errores/accesoDenegado")
    public String noAutorizado(){

        return "errores/401";
    }
}
