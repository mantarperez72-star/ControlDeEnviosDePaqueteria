package com.arturo.paqueteria.repository;

import com.arturo.paqueteria.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}