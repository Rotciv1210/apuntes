package com.example.bolivia.model.dtos;

import com.example.bolivia.model.Usuario;

import java.util.List;

public class CicloDTO {
    //se pueden cambiar los nombres
    private Integer id;
    private String nombre;

    public CicloDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
