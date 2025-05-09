package com.example.ejercicio10.controller;

import com.example.ejercicio10.model.Usuario;
import com.example.ejercicio10.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/buscar")
    public String form(){

        return "form";
    }

    @PostMapping("/buscar")
    public String procesarFormulario(@RequestParam(required = false) String query,
                                     Model model) {

        List<Usuario> resultados;

        if (query != null && !query.trim().isEmpty()) {
            resultados = usuarioService.buscarporNombreoApellido(query.trim());
        } else {
            resultados = List.of();
        }

        model.addAttribute("usuarios", resultados);
        return "resultados";
    }

}
