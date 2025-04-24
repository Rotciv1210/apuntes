package com.example.bolivia.model;


import jakarta.persistence.*;

@Entity
@Table(name ="perfiles")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String descripcion;


    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    public Perfil(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil(Long id, String url, String descripcion, Usuario usuario) {
        this.id = id;
        this.url = url;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }
}
