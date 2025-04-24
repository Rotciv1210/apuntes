package com.example.bolivia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El campo usuario es obligatorio")
    private String username;
    @NotBlank(message = "El campo contraseña es obligatorio")
    private String password;
    @Email(message = "El formato no es correcto")
    @NotBlank(message = "El campo no es correcto")
    private String email;
    @NotNull(message = "El campo esa obligatorio")
    private Integer telefono;

    //ciclo
    @ManyToOne(fetch = FetchType.LAZY)
    private Ciclo ciclo;

    //cursos
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuarios_cursos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;


    public Usuario(){}

    public Usuario(Long id, String username, String password, String email, Integer telefono, Ciclo ciclo, List<Curso> cursos) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.ciclo = ciclo;
        this.cursos = cursos;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}


