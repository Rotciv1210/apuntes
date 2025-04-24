 package com.example.loginyregistroseguro.controller;

import com.example.loginyregistroseguro.model.Usuario;
import com.example.loginyregistroseguro.service.UsuarioService;
import com.example.loginyregistroseguro.utils.PasswordUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

 @Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

     @GetMapping("/")
     public String home(){

         return "home";
     }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("usuario",new Usuario());

        return "form";
    }

    @PostMapping("/guardar")
    public String alta(Usuario usuario){

        String password = PasswordUtil.codificarPassword(usuario.getPassword());

        usuario.setPassword(password);
        usuarioService.guardarUsuario(usuario);

        return "redirect:/";
    }


    @GetMapping("/loginForm")
    public String loginForm(Model model){
        model.addAttribute("usuario",new Usuario());

        return "loginForm";
    }



    @PostMapping("/login")
    public String login(Usuario usuario, HttpSession session){
        //usuario que viene del formulario creamos metodo en el repo de buscar usuario
       boolean success = usuarioService.login(usuario.getUsername(), usuario.getPassword());

        System.out.println("usuario intentado: "+usuario.getUsername());
       if(success){

           System.out.println("Login exitoso para: " +usuario.getUsername());
           Optional<Usuario> usuarioDB = usuarioService.obtenerPorUsername(usuario.getUsername());
           usuarioDB.ifPresent(u -> session.setAttribute("usuarioID", u.getId()));

           return "redirect:/";
       } else {
           System.out.println("Login fallido para: "+usuario.getUsername());
       }

       return "redirect:/login-error";
    }

}
