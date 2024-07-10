package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Estudiante;
import com.example.servicebolsa.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante getEstudianteById(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElse(null);
    }

    @Override
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante updateEstudiante(Long id, Estudiante estudiante) {
        if (estudianteRepository.existsById(id)) {
            estudiante.setIdUsuario(id); // Asegúrate de ajustar el setter correspondiente
            return estudianteRepository.save(estudiante);
        }
        return null;
    }

    @Override
    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
