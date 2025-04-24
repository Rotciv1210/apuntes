package com.example.bolivia.controller;


import com.example.bolivia.model.Curso;
import com.example.bolivia.model.Usuario;
import com.example.bolivia.service.CursoService;
import com.example.bolivia.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/curso")
public class CursoController {

    private static final Logger LOG = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;


    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("curso", new Curso());
        return "curso/form";
    }

    @PostMapping("/guardar")
    public String guardar(Curso curso, RedirectAttributes flash){
        cursoService.guardarCurso(curso);
        flash.addFlashAttribute("success","Curso agregado!");
        return "redirect:/curso";
    }


    @GetMapping
    public String listar(Model model){

        model.addAttribute("cursos", cursoService.listarCurso());

        return "curso/home";
    }

    @GetMapping("/detalles/{id}")
    public String detalles(@PathVariable Integer id, Model model){

        model.addAttribute("curso",cursoService.buscarporID(id));
        return "curso/detalles";
    }

    @GetMapping("/comprar")
    public String comprar(@RequestParam(name="cursoId") Integer CursoID, HttpSession session){

        Long usuarioID = (Long) session.getAttribute("id");

        //obtener el curso seleccionado por el id
        Curso curso = cursoService.buscarporID(CursoID);
        //obtener los cursos del usuario
        Usuario usuario = usuarioService.buscarporID(usuarioID);
        //Lista de cursos del usuario
        List<Curso> cursos = usuario.getCursos();

        if(cursos == null){

            cursos = new ArrayList<>();
        }
        //agregar el nuevo curso a la lista
        cursos.add(curso);

        //asignar al usuario el curso
        usuario.setCursos(cursos);

        //Persistir al usuario con los curso en la base de datos
        usuarioService.guardarUsuario(usuario);




        return "redirect:/curso";
    }



}
