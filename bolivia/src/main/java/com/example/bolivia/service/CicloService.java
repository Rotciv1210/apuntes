package com.example.bolivia.service;

import com.example.bolivia.model.Ciclo;
import com.example.bolivia.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CicloService {

    @Autowired
    private CicloRepository cicloRepository;

    //metodo para guardar el ciclo
    public void guardarCiclo(Ciclo ciclo){
        cicloRepository.save(ciclo);
    }

    //metodo que liste los ciclos
    public List<Ciclo> listaCiclos(){

        return cicloRepository.findAll();
    }
}
