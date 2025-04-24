package com.example.bolivia.controller;

import com.example.bolivia.model.Usuario;
import com.example.bolivia.service.CicloService;
import com.example.bolivia.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CicloService cicloService;
    @GetMapping
    public String form(Model model){

        model.addAttribute("usuarios", new Usuario());
        model.addAttribute("ciclos", cicloService.listaCiclos());
        return "form";
    }

    @PostMapping("/guardar")
    public String alta(@Valid Usuario usuario, BindingResult result){
        //para las validaciones
        if(result.hasErrors()){
            return "form";
        }
        usuarioService.guardarUsuario(usuario);
        return "home";
    }
}
