package com.example.controladorVistas.controller;


import com.example.controladorVistas.model.Cliente;
import com.example.controladorVistas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todos")
    public String home(Model model){

        List <Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1l, "Juan", "juan@es.es", "Torres","Orons"));
        clientes.add(new Cliente(2l, "Carmen", "carmen@es.es", "Garcia","Vale"));
        model.addAttribute("customers", clientes);

        return "home";
    }

    @GetMapping("/lista")
    public String lista(Model model){

        List<Cliente> clientes= clienteService.listarClientes();
        model.addAttribute("lista", clientes);

        return "listaClientes";
    }

    @GetMapping("/{id}")
    public String mostrar(@PathVariable Long id, Model model){

        Cliente cliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", cliente);

        return "detallesCliente";
    }

    //metodo que despliegue un formaulario
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("textoBoton", "Guardar Cliente");
        return "form";
    }

    @PostMapping("/guardar")
    public String alta(Cliente cliente, RedirectAttributes flash){

        if(cliente.getId()==null){
            clienteService.guardarCliente(cliente);
            flash.addFlashAttribute("success","Cliente Registrado");

            return "redirect:/cliente/lista";
        }
        clienteService.guardarCliente(cliente);
        flash.addFlashAttribute("success","Cliente Modificado");

        return "redirect:/cliente/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash){
        clienteService.eliminarCliente(id);
        flash.addFlashAttribute("success","Cliente eliminado");
        return "redirect:/cliente/lista";
    }

    @GetMapping("/modificar/{id}")
    public String formularioModificar(@PathVariable Long id, Model model){

        Cliente cliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("textoBoton", "Modificar Cliente");

        return "form";
    }





}
