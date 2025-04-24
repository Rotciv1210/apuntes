package com.example.bolivia.controller;

import com.example.bolivia.model.Perfil;
import com.example.bolivia.service.PerfilService;
import com.example.bolivia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired //implementamos usuarioService para poder utilizar la lista
    private UsuarioService usuarioService;

    @Autowired
    private PerfilService perfilService;


    @GetMapping()
    public String form(Model model){

        model.addAttribute("perfil", new Perfil());
        //le pasamos la lista para poder usarla en el formulario
        model.addAttribute("usuarios", usuarioService.listaUsuarios());
        return "perfil/form";
    }

    //metodo para guardarPerfiles
    @PostMapping("/guardar")
    public String altaPerfil(Perfil perfil){
        perfilService.guardarPerfil(perfil);
        return "redirect:/home";
    }


}
