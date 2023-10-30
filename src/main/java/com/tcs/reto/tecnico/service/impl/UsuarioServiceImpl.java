package com.tcs.reto.tecnico.service.impl;

import com.tcs.reto.tecnico.model.Usuario;
import com.tcs.reto.tecnico.repository.UsuarioRepository;
import com.tcs.reto.tecnico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        String contraseñaCodificada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(contraseñaCodificada);
        System.out.println("Usuario registrado: " + usuario.toString());
       return usuarioRepository.save(usuario);
    }
}
