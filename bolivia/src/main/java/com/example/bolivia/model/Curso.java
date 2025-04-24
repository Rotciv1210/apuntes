package com.example.bolivia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    private String nombre;

    private Integer duracion;

    public Curso(){}
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cursos")
    private List<Usuario> usuarios;

    public Curso(Integer id, String nombre, Integer duracion, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.usuarios = usuarios;
    }

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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
