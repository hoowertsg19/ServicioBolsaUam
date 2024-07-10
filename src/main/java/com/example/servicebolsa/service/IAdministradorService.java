package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Administrador;
import java.util.List;

public interface IAdministradorService {
    List<Administrador> getAllAdministradores();
    Administrador getAdministradorById(Long id);
    Administrador createAdministrador(Administrador administrador);
    Administrador updateAdministrador(Long id, Administrador administrador);
    void deleteAdministrador(Long id);
}
