package com.example.repasoTablasDTO.controller;

import com.example.repasoTablasDTO.model.Aulas;
import com.example.repasoTablasDTO.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public String form(Model model){
        model.addAttribute("aula", new Aulas());
        return "formAulas";
    }

    @PostMapping("/alta")
    public String alta(Aulas aulas, RedirectAttributes flash){
        aulaService.guardarAula(aulas);
        flash.addFlashAttribute("success", "Aula registrada");
        return "redirect:/aula";
    }
}
