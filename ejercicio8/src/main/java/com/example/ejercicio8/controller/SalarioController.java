package com.example.ejercicio8.controller;
/*Crea una aplicación con Spring Boot que devuelva el salario neto de un empleado en un JSON pasando el salario bruto

y el % de  IRPF que se le descuenta por la URL.

Ejemplo : http://localohst:8080/19000/10

descuento = salario bruto *  irpf / 100
salario neto = salario bruto  - descuento

el JSON a devolver para el ejemplo :
{
       salario : 1710
}*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SalarioController {

    @GetMapping("/{bruto}/{irpf}")
    public Map<String, Integer> calcularSalarioNeto(@PathVariable int bruto, @PathVariable int irpf){


        int descuento = bruto * irpf /100;
        int neto = bruto - descuento;

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("salario", neto);

        return mapa;
    }

}
