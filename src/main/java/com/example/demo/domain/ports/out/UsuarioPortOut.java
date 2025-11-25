package com.example.demo.domain.ports.out;

import com.example.demo.domain.model.UsuarioModel;

public interface UsuarioPortOut {
    UsuarioModel crearUsuarioOut(UsuarioModel usuario);
    UsuarioModel buscarPorEmailEmailOut(String email);
    UsuarioModel buscarPorIdOut(int id);
}
