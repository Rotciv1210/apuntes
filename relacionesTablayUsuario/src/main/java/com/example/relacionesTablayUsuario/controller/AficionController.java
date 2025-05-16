package com.example.relacionesTablayUsuario.controller;

import com.example.relacionesTablayUsuario.model.Aficion;
import com.example.relacionesTablayUsuario.service.AficionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aficion")
public class AficionController {

    @Autowired
    private AficionService aficionService;

    @GetMapping("/")
    public String form(Model model){
        model.addAttribute("aficion", new Aficion());
        return "aficion/registerForm";
    }

    @PostMapping
    public String alta(Aficion aficion, RedirectAttributes flash){

        aficionService.guardarAficion(aficion);
        flash.addFlashAttribute("success", "Aficion Registrada!");
        //la redireccion siempre va a una URL
        return "redirect:/aficion/";
    }
}
