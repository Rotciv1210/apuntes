package com.example.bolivia.controller;

import com.example.bolivia.model.Ciclo;
import com.example.bolivia.service.CicloService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ciclo")
public class CicloController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CicloService cicloService;

    @GetMapping
    public String form(Model model, HttpSession session){

        //recuperar login del usuario
        String username = (String) session.getAttribute("username");
        Long id = (Long) session.getAttribute("id");

        model.addAttribute("ciclo", new Ciclo());
        return "ciclo/form";

    }
    //metodo para guardar el ciclo
    @PostMapping("/guardar")
    public String guardar(Ciclo ciclo, RedirectAttributes flash){

        cicloService.guardarCiclo(ciclo);
        flash.addFlashAttribute("success","El ciclo ha sido dado de alta");
        return "redirect:/home";
    }
}
