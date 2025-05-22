package com.example.repasoTablasDTO.service;

import com.example.repasoTablasDTO.converters.IncidenciaConverter;
import com.example.repasoTablasDTO.dto.IncidenciaDTO;
import com.example.repasoTablasDTO.model.Incidencias;
import com.example.repasoTablasDTO.repo.IncidenciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepo incidenciaRepo;
    @Autowired
    private IncidenciaConverter incidenciaConverter;

    public void guardarIncidencia(Incidencias incidencias){

        incidenciaRepo.save(incidencias);
    }


    public List<Incidencias> listaIncidencias(){

        return incidenciaRepo.findAll();
    }

    public List<IncidenciaDTO> listaIncidenciasDTO(){

        List<Incidencias> incidencia = incidenciaRepo.findAll();

        List<IncidenciaDTO> incidenciaDTO = new ArrayList<>();

        for(Incidencias incidencias : incidencia){

            incidenciaDTO.add(incidenciaConverter.convertIncidenciaToIncidenciaDTO(incidencias));
        }

        return incidenciaDTO;
    }
}
