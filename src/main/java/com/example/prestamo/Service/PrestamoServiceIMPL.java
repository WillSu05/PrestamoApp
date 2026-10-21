package com.example.prestamo.Service;

import com.example.prestamo.DTO.PrestamoRequestDTO;
import com.example.prestamo.Model.HerramientasModel;
import com.example.prestamo.Model.Prestamo;
import com.example.prestamo.Repository.HerramientaRepository;
import com.example.prestamo.Repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrestamoServiceIMPL implements PrestamoService{
    private final PrestamoRepository prestamoRepository;
    private final HerramientaRepository herramientaRepository;


    @Override
    public List<Prestamo> obtenerTodos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo registrarPrestamo(PrestamoRequestDTO requestDTO) {

        HerramientasModel herramienta = herramientaRepository.findById(requestDTO.getHerramientaId())
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + requestDTO.getHerramientaId()));
        if (requestDTO.getCantidadPrestada() > herramienta.getCantidad()) {
            throw new IllegalArgumentException("Cantidad solicitada superior a las unidades disponibles.");
        }

        herramienta.setCantidad(herramienta.getCantidad() - requestDTO.getCantidadPrestada());
        herramientaRepository.save(herramienta);

        Prestamo prestamo = new Prestamo();
        prestamo.setSolicitante(requestDTO.getSolicitante());
        prestamo.setFechaPrestamo(requestDTO.getFechaPrestamo());
        prestamo.setCantidadPrestada(requestDTO.getCantidadPrestada());
        prestamo.setHerramienta(herramienta);

        return prestamoRepository.save(prestamo);
    }

    @Override
    public List<Prestamo> obtenerPrestamosPorHerramienta(Long herramientaId) {
        return List.of();
    }
}
