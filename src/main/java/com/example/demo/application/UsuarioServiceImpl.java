package com.example.demo.application;

import com.example.demo.domain.model.UsuarioModel;
import com.example.demo.domain.ports.in.UsuarioPortIn;
import com.example.demo.domain.ports.out.UsuarioPortOut;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImpl implements UsuarioPortIn {
    private final UsuarioPortOut usuarioPortOut;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final int MIN_USERNAME = 4;
    private static final int MAX_USERNAME = 25;


    public UsuarioServiceImpl(UsuarioPortOut usuarioPortOut) {
        this.usuarioPortOut = usuarioPortOut;
    }

    @Override
    public UsuarioModel crearUsuarioIn(UsuarioModel usuarioModel) {
        usuarioModel.setNombres(usuarioModel.getNombres().toUpperCase());
        usuarioModel.setApellidos(usuarioModel.getApellidos().toUpperCase());
        usuarioModel.setEmail(usuarioModel.getEmail().toLowerCase());

        validarUsuario(usuarioModel);
        return usuarioPortOut.crearUsuarioOut(usuarioModel);
    }

    @Override
    public UsuarioModel buscarPorEmailEmailIn(String email) {
        return null;
    }

    @Override
    public UsuarioModel buscarPorIdIn(int id) {
        return null;
    }

    @Override
    public Optional<UsuarioModel> actualizaUsuario(int id, UsuarioModel usuarioModel) {
        return Optional.empty();
    }

    public void validarUsuario(UsuarioModel usuarioModel) {
        if (usuarioModel == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        // validando email
        String email = usuarioModel.getEmail();
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email es obligatorio");
        }
        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException("El formato del email no es valido");
        }
        String username = usuarioModel.getUsername();
        if (username.length() < MIN_USERNAME || username.length() > MAX_USERNAME) {
            throw new IllegalArgumentException("El formato del username no es valido");
        }
    }
}
