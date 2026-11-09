package com.arturo.paqueteria.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EnvioRequestDTO {
    @NotBlank(message = "El destinatario es obligatorio")
    private String destinatario;

    @NotNull(message = "El peso es obligatorio")
    @DecimalMin(value = "0.01", message = "El peso debe ser mayor a cero")
    private BigDecimal peso;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fechaEnvio;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "recibido|en_transito|entregado|cancelado", message = "Estado no válido. Use: recibido, en_transito, entregado o cancelado")
    private String estado;

    @NotNull(message = "El ID del tipo de envío es obligatorio")
    private Long tipoEnvioId;
    private String tipoPaquete;
    private String medidas;

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    public BigDecimal getPeso() { return peso; }
    public void setPeso(BigDecimal peso) { this.peso = peso; }
    public LocalDate getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDate fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getTipoEnvioId() { return tipoEnvioId; }
    public void setTipoEnvioId(Long tipoEnvioId) { this.tipoEnvioId = tipoEnvioId; }
    public String getTipoPaquete() { return tipoPaquete; }
    public void setTipoPaquete(String tipoPaquete) { this.tipoPaquete = tipoPaquete; }
    public String getMedidas() { return medidas; }
    public void setMedidas(String medidas) { this.medidas = medidas; }
}