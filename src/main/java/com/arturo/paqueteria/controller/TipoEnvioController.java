package com.arturo.paqueteria.controller;

import com.arturo.paqueteria.entity.TipoEnvio;
import com.arturo.paqueteria.repository.TipoEnvioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-envio")
public class TipoEnvioController {

    private final TipoEnvioRepository repository;

    public TipoEnvioController(TipoEnvioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TipoEnvio> listar() {
        return repository.findAll();
    }

    @PostMapping
    public TipoEnvio guardar(@RequestBody TipoEnvio tipoEnvio) {
        return repository.save(tipoEnvio);
    }
}