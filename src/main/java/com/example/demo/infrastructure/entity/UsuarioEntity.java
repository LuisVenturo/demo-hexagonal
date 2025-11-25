package com.example.demo.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String username;
    private String nombres;
    private String apellidos;
    private String email;
    private Date fechaCreacion =  new Date();
    private Date fechaActualizacion;
    private boolean estado;
}
