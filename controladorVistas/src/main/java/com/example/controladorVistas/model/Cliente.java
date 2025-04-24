package com.example.controladorVistas.model;


import jakarta.persistence.*;

//crear tabla en la bbdd desde aqui
@Entity
@Table(name ="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nombre;
    @Column(length = 50)
    private String email;
    @Column(name ="apellido_uno", length = 50)
    private String apellidoUno;
    @Column(name ="apellido_dos",length = 50)
    private String apellidoDos;

    public Cliente(){}

    public Cliente(Long id, String nombre, String email,
                   String apellidoUno, String apellidoDos) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }
}
