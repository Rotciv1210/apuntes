package com.example.bolivia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="ciclos")
public class Ciclo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String nombre;
    //enlazar con usuarios
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ciclo")
    private List<Usuario> usuarios;
    public Ciclo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Ciclo(Integer id, String nombre, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = usuarios;
    }
}
