package com.arturo.paqueteria.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EnvioResponseDTO {
    private Long id;
    private String destinatario;
    private BigDecimal peso;
    private LocalDate fechaEnvio;
    private String estado;
    private String nombreTipoEnvio;
    private BigDecimal costoTotal;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    public BigDecimal getPeso() { return peso; }
    public void setPeso(BigDecimal peso) { this.peso = peso; }
    public LocalDate getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDate fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getNombreTipoEnvio() { return nombreTipoEnvio; }
    public void setNombreTipoEnvio(String nombreTipoEnvio) { this.nombreTipoEnvio = nombreTipoEnvio; }
    public BigDecimal getCostoTotal() { return costoTotal; }
    public void setCostoTotal(BigDecimal costoTotal) { this.costoTotal = costoTotal; }
}