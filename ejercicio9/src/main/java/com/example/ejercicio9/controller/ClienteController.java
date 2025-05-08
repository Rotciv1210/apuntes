package com.example.ejercicio9.controller;

import ch.qos.logback.core.net.server.Client;
import com.example.ejercicio9.model.Cliente;
import com.example.ejercicio9.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("cliente", new Cliente());
        return "form";
    }

    @PostMapping("/form")
    public String alta(Cliente cliente, RedirectAttributes flash){

        clienteService.guardarCliente(cliente);
        flash.addFlashAttribute("success", "Cliente registrado");
        return "redirect:/form";
    }
/*
    @GetMapping("/lista")
    public String verClientes(Model model,Cliente cliente, RedirectAttributes flash){
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", clienteService.listaClientes());

        return "lista";

    }
*/

    @GetMapping("/lista")
    public String verClientes(Model model) {
        model.addAttribute("cliente", new Cliente()); // para binding del select
        model.addAttribute("clientes", clienteService.listaClientes()); // para llenar opciones
        return "lista";
    }


    @PostMapping("/lista")
    public String mostrarLista(@RequestParam("id") Integer id, RedirectAttributes flash){

        Cliente cliente = clienteService.obtenerClienteporID(id);

        if(cliente != null){

            flash.addFlashAttribute("clienteSeleccionado", cliente);
            return "redirect:/detalle";
        } else{
            flash.addFlashAttribute("error", "Cliente no encontrado");
            return "redirect:/lista";
        }
    }

    @GetMapping("/detalle")
    public String detalle(){

        return "detalle";
    }


}
