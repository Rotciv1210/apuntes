package com.example.bolivia.service;

import com.example.bolivia.model.Curso;
import com.example.bolivia.repository.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepo cursoRepo;

    public Curso guardarCurso(Curso curso){

        return cursoRepo.save(curso);
    }

    public List<Curso> listarCurso(){

        return cursoRepo.findAll();
    }

    public Curso buscarporID(Integer id){

        return cursoRepo.findById(id).orElse(null);
    }

}
