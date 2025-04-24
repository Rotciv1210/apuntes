package com.example.bolivia.controller;

import com.example.bolivia.model.Ciclo;
import com.example.bolivia.model.Usuario;
import com.example.bolivia.model.dtos.UsuarioDTO;
import com.example.bolivia.service.CicloService;
import com.example.bolivia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ciclos")
public class RestCiclosController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public List<UsuarioDTO> lista(){

        return usuarioService.listaUsuarios();
    }
}
