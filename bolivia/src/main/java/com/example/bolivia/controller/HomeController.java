package com.example.bolivia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
                //para que entre por dos direcciones
    @GetMapping({"/home","/"})
    public String home(){
        return "home";
    }


}
