package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Estudiante;
import java.util.List;

public interface IEstudianteService {
    List<Estudiante> getAllEstudiantes();
    Estudiante getEstudianteById(Long id);
    Estudiante createEstudiante(Estudiante estudiante);
    Estudiante updateEstudiante(Long id, Estudiante estudiante);
    void deleteEstudiante(Long id);
}
