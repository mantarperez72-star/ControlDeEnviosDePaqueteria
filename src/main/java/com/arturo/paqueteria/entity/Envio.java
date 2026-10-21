package com.arturo.paqueteria.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false)
    private BigDecimal peso;

    @Column(nullable = false)
    private LocalDate fechaEnvio;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "tipo_envio_id", nullable = false)
    private TipoEnvio tipoEnvio;


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
    public TipoEnvio getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(TipoEnvio tipoEnvio) { this.tipoEnvio = tipoEnvio; }
}