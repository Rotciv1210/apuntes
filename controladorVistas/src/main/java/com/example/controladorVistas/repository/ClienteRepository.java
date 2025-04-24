package com.example.controladorVistas.repository;

import com.example.controladorVistas.model.Cliente;
import org.hibernate.jpa.event.internal.CallbackDefinitionResolverLegacyImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    //busquedas personalizadas
    List<Cliente> findByNombre(String nombre);
    //ahora se implementa en el servicio
    //por apellido
    List<Cliente> findByApellidoUno(String apellidoUno);
    //
    List<Cliente> findByNombreOrApellidoUno(String nombre, String apellidoUno);
    List<Cliente> findByNombreAndApellidoUno(String nombre, String apellidoUno);
}


