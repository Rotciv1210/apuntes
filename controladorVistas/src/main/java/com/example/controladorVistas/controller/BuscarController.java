package com.example.controladorVistas.controller;

import com.example.controladorVistas.model.Cliente;
import com.example.controladorVistas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/buscar")
public class BuscarController {

    //se instancia el service
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String buscarForm(){

        return "buscarForm";
    }

    //se crea el metodo para capturar el campo del formulario
    @GetMapping("/por-nombre")                                    //al poner aqui nombreForm el formulario del html tiene que tener el mismo nombre
    public String buscarPorNombre(@RequestParam(required = false) String nombreForm, Model model) {
        //se almacena en una lista de clientes
        List<Cliente> clientes = clienteService.buscarPorNombre(nombreForm);

        //pasamos al html con model
        model.addAttribute("clientes",clientes);
        return "buscarForm";
    }

    @GetMapping("/por-apellidoUno")
    public String buscarPorApellidoUno(@RequestParam(required = false) String apellidoUno, Model model){

        List<Cliente> clientes = clienteService.buscarPorApellidoUno(apellidoUno);
        model.addAttribute("clientes", clientes);
        return "buscarForm";
    }

    @GetMapping("/por-nombre-o-apellido")
    public String buscarPorNombreOPrimerApellido(@RequestParam(required = false) String dato, Model model){
        List<Cliente> clientes = clienteService.buscarPorNombreOrApellidoUno(dato);
        model.addAttribute("clientes" , clientes);
        return "buscarForm";
    }

    @GetMapping("/por-nombre-y-apellido")
    public String buscarPorNombreYApellido(@RequestParam(required = false) String nombre,
                                           String apellidoUno,Model model){
        List<Cliente> clientes = clienteService.buscarPorNombreYApellidoUno(nombre, apellidoUno);
        model.addAttribute("clientes", clientes);
        return "buscarForm";
    }


}
