package com.tcs.reto.tecnico.repository;

import com.tcs.reto.tecnico.model.TipoCambio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long>{

    TipoCambio save(TipoCambio tipoCambio);

    @Query(value = "SELECT * FROM tipo_cambio", nativeQuery = true)
    List<TipoCambio> listarTiposCambio();

    @Query(value = "SELECT * FROM tipo_cambio WHERE moneda_origen = ?1 AND moneda_destino = ?2", nativeQuery = true)
    TipoCambio obtenerTipoCambio(String monedaOrigen, String monedaDestino);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tipo_cambio SET tipo_cambio = ?1 WHERE moneda_origen = ?2 AND moneda_destino = ?3", nativeQuery = true)
    void actualizarTipoCambio(double tipoCambioActualizado, String monedaOrigen, String monedaDestino);
}
