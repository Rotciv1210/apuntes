package com.example.repasoTablasDTO.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aulas")
public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aula")
    private List<Incidencias> incidencias;

    public Aulas(){}

    public Aulas(Integer id, String nombre, List<Incidencias> incidencias) {
        this.id = id;
        this.nombre = nombre;
        this.incidencias = incidencias;
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

    public List<Incidencias> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<Incidencias> incidencias) {
        this.incidencias = incidencias;
    }
}
