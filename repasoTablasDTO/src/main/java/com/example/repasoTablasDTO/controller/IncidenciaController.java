package com.example.repasoTablasDTO.controller;

import com.example.repasoTablasDTO.model.Incidencias;
import com.example.repasoTablasDTO.service.AulaService;
import com.example.repasoTablasDTO.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public String form(Model model){
        model.addAttribute("aulas", aulaService.listaAulas());
        model.addAttribute("incidencia", new Incidencias());
        return "formIncidencias";
    }

    @PostMapping("/alta")
    public String alta(Incidencias incidencias, RedirectAttributes flash){
        incidenciaService.guardarIncidencia(incidencias);
        flash.addFlashAttribute("success", "Incidencia Registrada");
        return "redirect:/incidencias";
    }
}
