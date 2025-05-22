package com.example.repasoTablasDTO.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidencias")
public class Incidencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private LocalDateTime fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    private Aulas aula;

    //generar fecha automatica
    @PrePersist
    public void prePersist(){

        this.fecha = LocalDateTime.now();
    }

    public Incidencias(){}

    public Incidencias(Integer id, String descripcion, LocalDateTime fecha, Aulas aula) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.aula = aula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Aulas getAula() {
        return aula;
    }

    public void setAula(Aulas aula) {
        this.aula = aula;
    }
}
