package com.example.saintMary.controller;


import com.example.saintMary.model.Usuario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin({"*"})
public class UsuarioRestController {

    @GetMapping("/usuarios")
    public List<Usuario>listaUsuarios(Model model){

        List<Usuario> lista = new ArrayList<>();

        lista.add(new Usuario(1,"Juan","juan@es.es"));
        lista.add(new Usuario(2,"Marta","marta@es.es"));


        return lista;
    }
}
