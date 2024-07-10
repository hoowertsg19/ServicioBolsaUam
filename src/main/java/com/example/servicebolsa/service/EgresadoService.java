package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Egresado;
import com.example.servicebolsa.repository.EgresadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EgresadoService implements IEgresadoService {

    @Autowired
    private EgresadoRepository egresadoRepository;

    @Override
    public List<Egresado> getAllEgresados() {
        return egresadoRepository.findAll();
    }

    @Override
    public Egresado getEgresadoById(Long id) {
        Optional<Egresado> egresado = egresadoRepository.findById(id);
        return egresado.orElse(null);
    }

    @Override
    public Egresado createEgresado(Egresado egresado) {
        return egresadoRepository.save(egresado);
    }

    @Override
    public Egresado updateEgresado(Long id, Egresado egresado) {
        if (egresadoRepository.existsById(id)) {
            egresado.setIdUsuario(id); // Asegúrate de ajustar el setter correspondiente
            return egresadoRepository.save(egresado);
        }
        return null;
    }

    @Override
    public void deleteEgresado(Long id) {
        egresadoRepository.deleteById(id);
    }
}
