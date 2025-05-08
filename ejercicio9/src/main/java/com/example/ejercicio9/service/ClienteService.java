package com.example.ejercicio9.service;

import com.example.ejercicio9.model.Cliente;
import com.example.ejercicio9.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public void guardarCliente(Cliente cliente){

        clienteRepo.save(cliente);
    }

    public List<Cliente> listaClientes(){

        return clienteRepo.findAll();
    }

    public Cliente obtenerClienteporID(Integer id){

        return clienteRepo.findById(id).orElse(null);
    }
}
