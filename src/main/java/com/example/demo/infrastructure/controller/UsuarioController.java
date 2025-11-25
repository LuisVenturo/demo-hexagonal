package com.example.demo.infrastructure.controller;

import com.example.demo.domain.model.UsuarioModel;
import com.example.demo.domain.ports.in.UsuarioPortIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioPortIn usuarioPortIn;

    public UsuarioController(UsuarioPortIn usuarioPortIn) {
        this.usuarioPortIn = usuarioPortIn;
    }

    @PostMapping("/crear")
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioPortIn.crearUsuarioIn(usuarioModel);
    }
}
