package com.arturo.paqueteria.service;

import com.arturo.paqueteria.dto.EnvioRequestDTO;
import com.arturo.paqueteria.dto.EnvioResponseDTO;
import com.arturo.paqueteria.entity.Envio;
import com.arturo.paqueteria.entity.TipoEnvio;
import com.arturo.paqueteria.exception.RecursoNoEncontradoException;
import com.arturo.paqueteria.repository.EnvioRepository;
import com.arturo.paqueteria.repository.TipoEnvioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;
    private final TipoEnvioRepository tipoEnvioRepository;

    public EnvioService(EnvioRepository envioRepository, TipoEnvioRepository tipoEnvioRepository) {
        this.envioRepository = envioRepository;
        this.tipoEnvioRepository = tipoEnvioRepository;
    }

    public List<EnvioResponseDTO> listarTodos() {
        return envioRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public EnvioResponseDTO buscarPorId(Long id) {
        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Envío no encontrado con ID: " + id));
        return convertirADTO(envio);
    }

    public EnvioResponseDTO guardar(EnvioRequestDTO dto) {
        TipoEnvio tipo = tipoEnvioRepository.findById(dto.getTipoEnvioId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Tipo de envío no encontrado"));

        Envio envio = new Envio();
        envio.setDestinatario(dto.getDestinatario());
        envio.setPeso(dto.getPeso());
        envio.setFechaEnvio(dto.getFechaEnvio());
        envio.setEstado(dto.getEstado());
        envio.setTipoEnvio(tipo);


        BigDecimal costo = dto.getPeso().multiply(tipo.getTarifaBase());
        envio.setCostoTotal(costo);

        return convertirADTO(envioRepository.save(envio));
    }

    public EnvioResponseDTO actualizar(Long id, EnvioRequestDTO dto) {
        Envio envio = envioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Envío no encontrado con ID: " + id));

        TipoEnvio tipo = tipoEnvioRepository.findById(dto.getTipoEnvioId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Tipo de envío no encontrado"));

        envio.setDestinatario(dto.getDestinatario());
        envio.setPeso(dto.getPeso());
        envio.setFechaEnvio(dto.getFechaEnvio());
        envio.setEstado(dto.getEstado());
        envio.setTipoEnvio(tipo);


        BigDecimal costo = dto.getPeso().multiply(tipo.getTarifaBase());
        envio.setCostoTotal(costo);

        return convertirADTO(envioRepository.save(envio));
    }

    public void eliminar(Long id) {
        if (!envioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Envío no encontrado con ID: " + id);
        }
        envioRepository.deleteById(id);
    }

    public List<EnvioResponseDTO> buscarPorEstado(String estado) {
        return envioRepository.findByEstado(estado).stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public List<EnvioResponseDTO> buscarPorDestinatario(String destinatario) {
        return envioRepository.findByDestinatarioContainingIgnoreCase(destinatario).stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public BigDecimal obtenerTotalCobrado(LocalDate fecha) {
        BigDecimal total = envioRepository.sumarCostoTotalPorFecha(fecha);
        return total != null ? total : BigDecimal.ZERO;
    }

    private EnvioResponseDTO convertirADTO(Envio envio) {
        EnvioResponseDTO dto = new EnvioResponseDTO();
        dto.setId(envio.getId());
        dto.setDestinatario(envio.getDestinatario());
        dto.setPeso(envio.getPeso());
        dto.setFechaEnvio(envio.getFechaEnvio());
        dto.setEstado(envio.getEstado());
        dto.setNombreTipoEnvio(envio.getTipoEnvio().getNombre());
        dto.setCostoTotal(envio.getCostoTotal());
        return dto;
    }
}