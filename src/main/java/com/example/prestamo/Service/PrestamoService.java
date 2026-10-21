package com.example.prestamo.Service;

import com.example.prestamo.DTO.PrestamoRequestDTO;
import com.example.prestamo.Model.Prestamo;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> obtenerTodos();
    Prestamo registrarPrestamo(PrestamoRequestDTO requestDTO);
    List<Prestamo> obtenerPrestamosPorHerramienta(Long herramientaId);
}
