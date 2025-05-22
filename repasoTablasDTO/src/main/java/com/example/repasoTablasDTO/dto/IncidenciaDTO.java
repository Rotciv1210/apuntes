package com.example.repasoTablasDTO.dto;


import java.time.LocalDateTime;

public class IncidenciaDTO {

    private String descripcion;

    private LocalDateTime fecha;

    private String aula;

    public IncidenciaDTO(){}

    public IncidenciaDTO(String descripcion, LocalDateTime fecha, String aula) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.aula = aula;
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

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
