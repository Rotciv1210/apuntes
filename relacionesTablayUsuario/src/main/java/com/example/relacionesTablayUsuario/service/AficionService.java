package com.example.relacionesTablayUsuario.service;

import com.example.relacionesTablayUsuario.model.Aficion;
import com.example.relacionesTablayUsuario.repo.AficionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AficionService {

    @Autowired
    private AficionRepo aficionRepo;

    public Aficion guardarAficion(Aficion aficion){

        return aficionRepo.save(aficion);
    }

    public List<Aficion> listaAficiones(){

        return aficionRepo.findAll();
    }

    public Aficion buscarAficionPorID(Integer id){

        return aficionRepo.findById(id).orElse(null);
    }
}
