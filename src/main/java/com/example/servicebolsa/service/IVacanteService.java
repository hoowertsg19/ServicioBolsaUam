package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Vacante;
import java.util.List;

public interface IVacanteService {
    List<Vacante> getAllVacantes();
    Vacante getVacanteById(Long id);
    Vacante createVacante(Vacante vacante);
    Vacante updateVacante(Long id, Vacante vacante);
    void deleteVacante(Long id);
}
