package com.example.repasoTablasDTO.controller;

import com.example.repasoTablasDTO.dto.IncidenciaDTO;
import com.example.repasoTablasDTO.model.Incidencias;
import com.example.repasoTablasDTO.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/incidencia")
public class IncidenciaRestController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public List<IncidenciaDTO> lista(){

        return incidenciaService.listaIncidenciasDTO();
    }

}
