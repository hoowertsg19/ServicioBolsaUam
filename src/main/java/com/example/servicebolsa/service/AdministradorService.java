package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Administrador;
import com.example.servicebolsa.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService implements IAdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador getAdministradorById(Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        return administrador.orElse(null);
    }

    @Override
    public Administrador createAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador updateAdministrador(Long id, Administrador administrador) {
        if (administradorRepository.existsById(id)) {
            administrador.setIdUsuario(id); // Asegúrate de ajustar el setter correspondiente
            return administradorRepository.save(administrador);
        }
        return null;
    }

    @Override
    public void deleteAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}
