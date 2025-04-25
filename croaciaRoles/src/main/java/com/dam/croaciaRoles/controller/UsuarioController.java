package com.dam.croaciaRoles.controller;

import com.dam.croaciaRoles.model.Usuario;
import com.dam.croaciaRoles.service.UsuarioService;
import com.dam.croaciaRoles.utils.PasswordUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public String home(){
        return "usuario/home";
    }

    //metodo de formulario
    @GetMapping("/alta")
    public String form(Model model){

        model.addAttribute("usuario", new Usuario());
        return "formularioRegistro";
    }

    //registro de usuario
    @PostMapping("/registro")
    public String alta(Usuario usuario, HttpSession session){

        //necesitamos la contraseña
       PasswordUtil.codificarPassword(usuario.getPassword());

       Usuario usuarioAlta = usuarioService.guardarUsuario(usuario,session);

       session.setAttribute("usuario", usuario.getUsername());

       return "redirect:/usuario";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String loginForm(Usuario usuario, HttpSession session, RedirectAttributes flash){

        boolean exito = usuarioService.login(usuario.getUsername(), usuario.getPassword(), session);

        if(exito){
            flash.addFlashAttribute("exitoMensaje", "Usuario logeado con Exito");

            session.setAttribute("usuario", usuario.getUsername());

            return "redirect:/usuario";
        }
        flash.addFlashAttribute("errorMensaje", "Usuario No VALIDO");

        return "redirect:/errores/accesoDenegado";
    }
}
