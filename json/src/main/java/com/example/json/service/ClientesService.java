package com.example.json.service;

import com.example.json.model.Cliente;
import com.example.json.repo.ClientesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepo clientesRepo;

    public void guardarCliente(Cliente cliente){

        clientesRepo.save(cliente);
    }
}
