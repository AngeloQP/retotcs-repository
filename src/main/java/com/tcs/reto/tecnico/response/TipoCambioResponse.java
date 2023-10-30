package com.tcs.reto.tecnico.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCambioResponse {

    private double monto;
    private double montoConTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
}
