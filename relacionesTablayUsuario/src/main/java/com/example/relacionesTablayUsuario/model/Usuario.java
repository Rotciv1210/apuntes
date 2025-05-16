package com.example.relacionesTablayUsuario.model;

import com.example.relacionesTablayUsuario.model.enums.Genero;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(name = "fecha_registro" , length = 100)
    private LocalDateTime fechaRegistro;
    //para guardar la fecha automaticamente
    @PrePersist
    public void prePersist(){
        this.fechaRegistro = LocalDateTime.now();
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            //nombre tabla pivote
            name = "usuarios_aficiones",
            //nombre columna de la tabla pivote que apunta a usuarios
            joinColumns = @JoinColumn(name = "usuario_id"),
            //nombre columna de la tabla pivote que apunta a aficiones
            inverseJoinColumns = @JoinColumn(name = "aficion_id")
    )
    private List<Aficion> aficiones;

    public Usuario(){}

    public Usuario(Long id, String username, String email, Genero genero, LocalDateTime fechaRegistro, List<Aficion> aficiones) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.genero = genero;
        this.fechaRegistro = fechaRegistro;
        this.aficiones = aficiones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Aficion> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<Aficion> aficiones) {
        this.aficiones = aficiones;
    }
}
