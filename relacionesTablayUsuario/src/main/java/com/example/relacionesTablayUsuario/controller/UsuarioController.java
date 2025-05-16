package com.example.relacionesTablayUsuario.controller;

import com.example.relacionesTablayUsuario.model.Aficion;
import com.example.relacionesTablayUsuario.model.Usuario;
import com.example.relacionesTablayUsuario.model.enums.Genero;
import com.example.relacionesTablayUsuario.service.AficionService;
import com.example.relacionesTablayUsuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AficionService aficionService;

    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("aficiones", aficionService.listaAficiones());
        return "usuario/registerForm";
    }


    @PostMapping("/registro")
    public String alta(Usuario usuario, @RequestParam List<Integer> aficionID,
                       @RequestParam String genero){
        //se recojen las aficiones que damos por parametro
        List<Aficion> aficiones = new ArrayList<>();
        for(Integer i : aficionID){

            aficiones.add(aficionService.buscarAficionPorID(i));
        }
        //ahora se setean al usuario
        usuario.setAficiones(aficiones);
        usuario.setGenero(Genero.valueOf(genero));

        usuarioService.altaUsuario(usuario);

        return "redirect:/form";
    }

}
