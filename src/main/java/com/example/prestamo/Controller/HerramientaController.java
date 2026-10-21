package com.example.prestamo.Controller;

import com.example.prestamo.Model.HerramientasModel;
import com.example.prestamo.Service.HerramientaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@RequiredArgsConstructor
public class HerramientaController {
    private final HerramientaService herramientaService;

    @GetMapping("/listarHerramientas")
    public ResponseEntity<List<HerramientasModel>> obtenerHerramientas() {
        List<HerramientasModel> herramientas = herramientaService.listarHerramientas();
        return ResponseEntity.ok(herramientas);
    }
    @GetMapping("/obtenerHerramientasPorId/{id}")
    public ResponseEntity<HerramientasModel> obtenerHerramientaPorId(@PathVariable Long id) {
        return herramientaService.obtenerHerramientaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/registrarHerramienta")
    public ResponseEntity<HerramientasModel> registrarHerramienta(@Valid @RequestBody HerramientasModel herramienta) {
        HerramientasModel nuevaHerramienta = herramientaService.guardarHerramienta(herramienta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaHerramienta);
    }
    @DeleteMapping("/eliminarHerramientas/{id}")
    public ResponseEntity<Void> eliminarHerramienta(@PathVariable Long id) {
        if (herramientaService.obtenerHerramientaPorId(id).isPresent()) {
            herramientaService.eliminarHerramienta(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
