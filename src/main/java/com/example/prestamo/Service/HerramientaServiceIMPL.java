package com.example.prestamo.Service;

import com.example.prestamo.Exeptions.ResourceNotFoundException;
import com.example.prestamo.Model.HerramientasModel;
import com.example.prestamo.Repository.HerramientaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HerramientaServiceIMPL implements HerramientaService{

    private final HerramientaRepository herramientaRepository;


    @Override
    public List<HerramientasModel> listarHerramientas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Optional<HerramientasModel> obtenerHerramientaPorId(Long id) {
        return herramientaRepository.findById(id);
    }

    @Override
    public HerramientasModel guardarHerramienta(HerramientasModel herramientasModel) {
        return herramientaRepository.save(herramientasModel);
    }

    @Override
    public void eliminarHerramienta(Long id) {
        if (!herramientaRepository.existsById(id)){
            throw new ResourceNotFoundException("Herramienta no encontrada con ID: "+id);
        }
        herramientaRepository.deleteById(id);

    }
}
