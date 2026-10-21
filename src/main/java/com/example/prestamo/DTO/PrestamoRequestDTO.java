package com.example.prestamo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
public class PrestamoRequestDTO {
    @NotBlank(message = "El solicitante no puede estar vacío")
    private String solicitante;

    @NotNull(message = "La fecha del préstamo es obligatoria")
    private LocalDate fechaPrestamo;

    @NotNull(message = "La cantidad prestada es obligatoria")
    @Min(value = 1, message = "La cantidad prestada debe ser mayor a 0")
    private Integer cantidadPrestada;

    @NotNull(message = "El ID de la herramienta es obligatorio")
    private Long herramientaId;

}
