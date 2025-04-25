package com.dam.croaciaRoles.controller;

import com.dam.croaciaRoles.filters.RolFilter;
import com.dam.croaciaRoles.model.Usuario;
import com.dam.croaciaRoles.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolFilter rolFilter;

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);


    @GetMapping("/admin")
    public String home(HttpSession session, HttpServletResponse response,
                       HttpServletRequest request) throws IOException {

        String rol = session.getAttribute("rol").toString();

        LOG.info("Rol "+rol);

        rolFilter.redirectByRol(rol, request, response);
        return "/admin/home";
    }
}
