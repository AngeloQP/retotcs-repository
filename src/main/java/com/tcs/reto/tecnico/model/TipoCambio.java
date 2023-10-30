package com.tcs.reto.tecnico.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
@Table(name = "tipo_cambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "monedaOrigen")
    private String monedaOrigen;

    @Column(name = "monedaDestino")
    private String monedaDestino;

    @Column(name = "tipoCambio")
    private double tipoCambio;



}
