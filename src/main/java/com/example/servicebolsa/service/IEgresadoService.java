package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Egresado;
import com.example.servicebolsa.model.Estudiante;
import java.util.List;

public interface IEgresadoService {
    List<Egresado> getAllEgresados();
    Egresado getEgresadoById(Long id);
    Egresado createEgresado(Egresado egresado);
    Egresado updateEgresado(Long id, Egresado egresado);
    void deleteEgresado(Long id);
}
