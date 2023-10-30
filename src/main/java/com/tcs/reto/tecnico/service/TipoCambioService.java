package com.tcs.reto.tecnico.service;

import com.tcs.reto.tecnico.model.TipoCambio;
import com.tcs.reto.tecnico.response.TipoCambioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoCambioService {
    List<TipoCambio> listarTiposCambio();

    TipoCambioResponse aplicarCambioMoneda(double monto, String monedaOrigen, String monedaDestino);

    String actualizarTipoCambio(double tipoCambioActualizado, String monedaOrigen, String monedaDestino);
}
