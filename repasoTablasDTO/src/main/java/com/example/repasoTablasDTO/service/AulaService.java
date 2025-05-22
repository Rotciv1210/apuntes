package com.example.repasoTablasDTO.service;

import com.example.repasoTablasDTO.model.Aulas;
import com.example.repasoTablasDTO.repo.AulaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private AulaRepo aulaRepo;

    public void guardarAula(Aulas aulas){

        aulaRepo.save(aulas);
    }

    public List<Aulas> listaAulas(){

        return aulaRepo.findAll();
    }
}
