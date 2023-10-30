package com.tcs.reto.tecnico.service;

import com.tcs.reto.tecnico.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario);
}
