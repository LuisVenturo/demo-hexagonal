package com.example.demo.infrastructure.adapter;

import com.example.demo.domain.model.UsuarioModel;
import com.example.demo.domain.ports.out.UsuarioPortOut;
import com.example.demo.infrastructure.entity.UsuarioEntity;
import com.example.demo.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAdapter implements UsuarioPortOut {
    private final UsuarioRepository usuarioRepository;

    public UsuarioAdapter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioModel crearUsuarioOut(UsuarioModel usuarioModel) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(usuarioModel.getUsername());
        usuario.setNombres(usuarioModel.getNombres());
        usuario.setApellidos(usuarioModel.getApellidos());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setFechaActualizacion(usuarioModel.getFechaActualizacion());
        usuarioRepository.save(usuario);
        usuarioModel.setIdUsuario(usuario.getIdUsuario());
        usuarioModel.setFechaCreacion(usuario.getFechaCreacion());
        return usuarioModel;
    }

    @Override
    public UsuarioModel buscarPorEmailEmailOut(String email) {
        return null;
    }

    @Override
    public UsuarioModel buscarPorIdOut(int id) {
        return null;
    }
}
