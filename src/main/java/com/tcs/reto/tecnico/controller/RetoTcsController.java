package com.tcs.reto.tecnico.controller;

import com.tcs.reto.tecnico.model.TipoCambio;
import com.tcs.reto.tecnico.model.Usuario;
import com.tcs.reto.tecnico.response.TipoCambioResponse;
import com.tcs.reto.tecnico.service.TipoCambioService;
import com.tcs.reto.tecnico.service.UsuarioService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tcs/reto/tecnico")
@Controller
@AllArgsConstructor
public class RetoTcsController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoCambioService tipoCambioService;

    @PostMapping("/registrarUsuario")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/tipoCambioMonto")
    public TipoCambioResponse tipoCambioMonto(@PathParam("monto") double monto,
                                              @PathParam("monedaOrigen") String monedaOrigen,
                                              @PathParam("monedaDestino") String monedaDestino) {
        TipoCambioResponse response = tipoCambioService.aplicarCambioMoneda(monto, monedaOrigen, monedaDestino);
        return response;
    }

    @GetMapping("/listarTiposCambio")
    public List<TipoCambio> listarTiposCambio() {
        return tipoCambioService.listarTiposCambio();
    }

    @PutMapping("/actualizarTipoCambio")
    public String actualizarTipoCambio(@PathParam("tipoCambioActualizado") double tipoCambioActualizado,
                                       @PathParam("monedaOrigen") String monedaOrigen,
                                       @PathParam("monedaDestino") String monedaDestino) {
        String respuesta = tipoCambioService.actualizarTipoCambio(tipoCambioActualizado, monedaOrigen, monedaDestino);
        return respuesta;
    }
}
