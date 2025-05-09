package com.example.Ejercicio3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/operacion")
public class UsuarioController {

    @GetMapping
    public String form() {
        return "operacion";
    }

    @GetMapping("/sumar")
    public String operacion(@RequestParam(required = false) Integer num1,
                            @RequestParam(required = false) Integer num2,
                            Model model) {
        Integer resultado = num1 + num2;
        model.addAttribute("resultado", resultado);

        return "operacion";
    }
}
