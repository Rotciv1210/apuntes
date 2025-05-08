package com.example.json.controller;

import com.example.json.model.Cliente;
import com.example.json.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public String obtenerCliente(Model model){

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "Juan","juan@es.es"));
        clientes.add(new Cliente(2, "Marta","marta@es.es"));
        clientes.add(new Cliente(3, "Diego","diego@es.es"));

        model.addAttribute("clientes", clientes);
        return "clientes";
    }
//otra forma
    @GetMapping("/lista-json")
    @ResponseBody
    public List<Cliente> obtenerClienteJSON(Model model){

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "Juan","juan@es.es"));
        clientes.add(new Cliente(2, "Marta","marta@es.es"));
        clientes.add(new Cliente(3, "Diego","diego@es.es"));

        model.addAttribute("clientes", clientes);
        return clientes;
    }

    //guadar
    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("cliente", new Cliente());
        return "form";
    }

    @PostMapping("/form")
    public String alta(Cliente cliente, RedirectAttributes flash){

        clientesService.guardarCliente(cliente);
        flash.addFlashAttribute("success", "Cliente registrado");
        return "redirect:/form";
    }



}
