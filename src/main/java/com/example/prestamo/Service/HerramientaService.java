package com.example.prestamo.Service;

import com.example.prestamo.Model.HerramientasModel;

import java.util.List;
import java.util.Optional;

public interface HerramientaService {
    List<HerramientasModel> listarHerramientas();
    Optional<HerramientasModel> obtenerHerramientaPorId(Long id);
    HerramientasModel guardarHerramienta(HerramientasModel herramientasModel);
    void eliminarHerramienta(Long id);

}
