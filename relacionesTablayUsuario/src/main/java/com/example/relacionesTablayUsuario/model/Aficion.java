package com.example.relacionesTablayUsuario.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aficiones")
public class Aficion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreAficion;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "aficiones")
    private List<Usuario> usuarios;

    public Aficion(){}

    public Aficion(Integer id, String nombreAficion, List<Usuario> usuarios) {
        this.id = id;
        this.nombreAficion = nombreAficion;
        this.usuarios = usuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAficion() {
        return nombreAficion;
    }

    public void setNombreAficion(String nombreAficion) {
        this.nombreAficion = nombreAficion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
