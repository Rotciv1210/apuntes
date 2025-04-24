package com.example.controladorVistas.service;


import com.example.controladorVistas.model.Cliente;
import com.example.controladorVistas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){

        return clienteRepository.findAll();

    }
    //buscar por id
    public Cliente buscarCliente(Long id){

        return clienteRepository.findById(id).orElse(null);
    }

    //metodo para insertar en la bd
    public Cliente guardarCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    //eliminar
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    //actualizar
    public Cliente modificarCliente(Long id, Cliente cliente){

        Cliente clienteBuscado = clienteRepository.findById(id).orElse(null);

        clienteBuscado.setNombre(cliente.getNombre());
        clienteBuscado.setApellidoUno(cliente.getApellidoDos());
        clienteBuscado.setApellidoDos(cliente.getApellidoDos());
        clienteBuscado.setEmail(cliente.getEmail());

        return clienteRepository.save(clienteBuscado);
    }

    public List<Cliente> buscarPorNombre(String nombre){

        return clienteRepository.findByNombre(nombre);
        //ahora se hace en el controlador
    }

    //busqueda por apellido1
    public List<Cliente> buscarPorApellidoUno(String apellidoUno){
        return clienteRepository.findByApellidoUno(apellidoUno);
    }

    public List<Cliente> buscarPorNombreOrApellidoUno(String dato){
        return clienteRepository.findByNombreOrApellidoUno(dato, dato);

    }

    public List<Cliente> buscarPorNombreYApellidoUno(String nombre, String apellidoUno){
        return clienteRepository.findByNombreAndApellidoUno(nombre, apellidoUno);
    }
}
