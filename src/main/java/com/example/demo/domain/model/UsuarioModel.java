package com.example.demo.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioModel {
    private int idUsuario;
    private String username;
    private String nombres;
    private String apellidos;
    private String email;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private boolean estado;
}
