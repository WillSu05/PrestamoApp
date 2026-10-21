package com.example.prestamo.Controller;

import com.example.prestamo.DTO.PrestamoRequestDTO;
import com.example.prestamo.Model.Prestamo;
import com.example.prestamo.Service.PrestamoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;


    @GetMapping("/listarPrestamos")
    public ResponseEntity<List<Prestamo>> listarPrestamos() {
        return ResponseEntity.ok(prestamoService.obtenerTodos());
    }

    @PostMapping("/crearPrestamo")
    public ResponseEntity<Prestamo> crearPrestamo(@Valid @RequestBody PrestamoRequestDTO requestDTO) {
        Prestamo nuevoPrestamo = prestamoService.registrarPrestamo(requestDTO);
        return new ResponseEntity<>(nuevoPrestamo, HttpStatus.CREATED);
    }

    @GetMapping("/listarPrestamo/{id}")
    public ResponseEntity<List<Prestamo>> listarPorHerramienta(@PathVariable("id") Long herramientaId) {
        return ResponseEntity.ok(prestamoService.obtenerPrestamosPorHerramienta(herramientaId));
    }
}
