package com.tcs.reto.tecnico.service.impl;

import com.tcs.reto.tecnico.model.TipoCambio;
import com.tcs.reto.tecnico.repository.TipoCambioRepository;
import com.tcs.reto.tecnico.response.TipoCambioResponse;
import com.tcs.reto.tecnico.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @Override
    public List<TipoCambio> listarTiposCambio() {
        return tipoCambioRepository.listarTiposCambio();
    }

    @Override
    public TipoCambioResponse aplicarCambioMoneda(double monto, String monedaOrigen, String monedaDestino) {
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
        TipoCambio tipoCambio = tipoCambioRepository.obtenerTipoCambio(monedaOrigen, monedaDestino);
        double valorTipoCambio = tipoCambio.getTipoCambio();
        double montoConTipCambio = monto * valorTipoCambio;
        tipoCambioResponse.setTipoCambio(valorTipoCambio);
        tipoCambioResponse.setMontoConTipoCambio(montoConTipCambio);
        tipoCambioResponse.setMonto(monto);
        tipoCambioResponse.setMonedaDestino(monedaDestino);
        tipoCambioResponse.setMonedaOrigen(monedaOrigen);
        return tipoCambioResponse;
    }

    @Override
    public String actualizarTipoCambio(double tipoCambioActualizado, String monedaOrigen, String monedaDestino) {
        String respuesta = "";
        try{
            tipoCambioRepository.actualizarTipoCambio(tipoCambioActualizado, monedaOrigen, monedaDestino);
            respuesta = "Se actualizó el valor con éxito.";
        }catch (Exception e){
            respuesta = "Ocurrió un error al ejecutar.";
        }
        return respuesta;
    }
}
