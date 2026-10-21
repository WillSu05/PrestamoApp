package com.example.prestamo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "prestamos")
public class Prestamo {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    @Column(nullable = false)
    private String solicitante;

    @NotNull(message = "La fecha del préstamo es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate fechaPrestamo;

    @NotNull(message = "La cantidad prestada es obligatoria")
    @Min(value = 1, message = "La cantidad prestada debe ser al menos 1")
    @Column(nullable = false)
    private Integer cantidadPrestada;

    @NotNull(message = "La herramienta asociada es obligatoria")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "herramienta_id", nullable = false)
    private HerramientasModel herramienta;



}
