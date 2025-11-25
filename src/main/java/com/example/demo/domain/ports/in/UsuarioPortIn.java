package com.example.demo.domain.ports.in;

import com.example.demo.domain.model.UsuarioModel;

import java.util.Optional;

public interface UsuarioPortIn {
    UsuarioModel crearUsuarioIn(UsuarioModel usuario);
    UsuarioModel buscarPorEmailEmailIn(String email);
    UsuarioModel buscarPorIdIn(int id);
    Optional<UsuarioModel> actualizaUsuario(int id, UsuarioModel usuarioModel);
}
