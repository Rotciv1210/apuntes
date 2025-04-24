package com.example.saintMary.controller;

import com.example.saintMary.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {
    //formulario
    //se le da una URL
    @GetMapping("/form")
    public String form(){
        return "formView";
    }

    @GetMapping("/login")
    //(@RequestParam String user, @RequestParam String pass) Para capturar los datos
    public String obtenerDatos(@RequestParam(name ="username", required = false) String user,
                               @RequestParam(name="password", required = false) String pass,
                               Model model){ //model sirve para enviar los datos a un html

        model.addAttribute("nombreUsuario", user);
        model.addAttribute("contraseñaUsuario", pass);


        return "obtenerDatos";
    }

    @GetMapping
    public String enlaces(){

        return "enlacesView";
    }

    //metoodo que obtenga los id
    @GetMapping("/get")
    public String obtenerIds(@RequestParam Integer id,@RequestParam String email, Model model){

        model.addAttribute("idUsuario", id);
        model.addAttribute("emailUsuario", email);
        return "obtenerID";
    }

    @GetMapping("/path-variable/{id}/{email}")
    public String obtenerDatosPorPathVariable(@PathVariable Integer id,
                                              @PathVariable String email,
                                              Model model){
        model.addAttribute("idUsuario",id);
        model.addAttribute("emailUsuario", email);

        return "obtenerID";
    }

    @GetMapping("/lista-usuarios")
    public String listaUsuarios(Model model){

        List<Usuario> lista = new ArrayList<>();

        lista.add(new Usuario(1,"Juan","juan@es.es"));
        lista.add(new Usuario(2,"Marta","marta@es.es"));

        //devolvemos esta lista a una vista
        model.addAttribute("listaUsuarios", lista);

        return "listaUsuariosView";
    }
}
