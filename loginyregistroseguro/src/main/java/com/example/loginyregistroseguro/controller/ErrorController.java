package com.example.loginyregistroseguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login-error")
public class ErrorController {


    @GetMapping
    public String noAutorizado(){

        return "login-error/401";
    }
}
