package com.arturo.paqueteria.controller;

import com.arturo.paqueteria.entity.Envio;
import com.arturo.paqueteria.repository.EnvioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    private final EnvioRepository repository;

    public EnvioController(EnvioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Envio> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Envio guardar(@RequestBody Envio envio) {
        return repository.save(envio);
    }
}