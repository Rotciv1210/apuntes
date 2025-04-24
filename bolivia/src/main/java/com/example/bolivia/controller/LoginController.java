package com.example.bolivia.controller;

import com.example.bolivia.model.Usuario;
import com.example.bolivia.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);


    @GetMapping
    public String form(){

        return "formLogin";
    }

    @PostMapping()
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session){

        Usuario usuario = usuarioService.login(username,password);

        if(usuario!=null){

            LOG.info("Usuario Valido");
            session.setAttribute("username", username);
            session.setAttribute("id",usuario.getId());

            return "redirect:/home";
        }

        return "error/401";
    }

}
