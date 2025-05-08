package com.example.json.controller;


import com.example.json.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Para devolver JSON con poner RestController
@RestController
public class HomeController {

    @GetMapping("/home")
    public Map<Integer, String> inicio(){


        //devoler un objeto con claves y valores
        Map<Integer, String> mapa = new HashMap<>();

        mapa.put(1,"Victor");
        mapa.put(2,"Carmen");

        //para que devuelva uno en especifico
        /*
        * String usuario = mapa.get(2);
        *
        * return usuario;
        * */

        return mapa;
    }

    //devolver la lista de clientes
    @GetMapping("/lista")
    public List<Cliente> obtenerClientes(){

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "Juan","juan@es.es"));
        clientes.add(new Cliente(2, "Marta","marta@es.es"));
        clientes.add(new Cliente(3, "Diego","diego@es.es"));

        return clientes;
    }
}
