package com.arturo.paqueteria.repository;

import com.arturo.paqueteria.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface EnvioRepository extends JpaRepository<Envio, Long> {

    List<Envio> findByEstado(String estado);

    List<Envio> findByDestinatarioContainingIgnoreCase(String destinatario);

    @Query("SELECT SUM(e.costoTotal) FROM Envio e WHERE e.fechaEnvio = :fecha")
    BigDecimal sumarCostoTotalPorFecha(@Param("fecha") LocalDate fecha);
}