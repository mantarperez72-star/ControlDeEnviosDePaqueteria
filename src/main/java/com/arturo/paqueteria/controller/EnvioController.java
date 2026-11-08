package com.arturo.paqueteria.controller;

import com.arturo.paqueteria.dto.EnvioRequestDTO;
import com.arturo.paqueteria.dto.EnvioResponseDTO;
import com.arturo.paqueteria.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {


    private final EnvioService service;

    public EnvioController(EnvioService service) {
        this.service = service;
    }

    @GetMapping
    public List<EnvioResponseDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public EnvioResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<EnvioResponseDTO> guardar(@Valid @RequestBody EnvioRequestDTO dto) {

        return new ResponseEntity<>(service.guardar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public EnvioResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody EnvioRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/filtrar/estado")
    public List<EnvioResponseDTO> filtrarPorEstado(@RequestParam String estado) {
        return service.buscarPorEstado(estado);
    }

    @GetMapping("/filtrar/destinatario")
    public List<EnvioResponseDTO> filtrarPorDestinatario(@RequestParam String destinatario) {
        return service.buscarPorDestinatario(destinatario);
    }


    @GetMapping("/total-cobrado")
    public BigDecimal totalCobrado(@RequestParam String fecha) {
        return service.obtenerTotalCobrado(LocalDate.parse(fecha));
    }
}