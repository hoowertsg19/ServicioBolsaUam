package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Postulacion;
import com.example.servicebolsa.repository.PostulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

@Service
public class PostulacionService {

    @Autowired
    private PostulacionRepository postulacionRepository;

    @Transactional
    public Postulacion crearPostulacion(Postulacion postulacion) {
        postulacion.setFechaPostulacion(new Date());
        return postulacionRepository.save(postulacion);
    }

    public List<Postulacion> obtenerPostulaciones() {
        return postulacionRepository.findAll();
    }

    public Postulacion obtenerPostulacionPorId(Long id) {
        return postulacionRepository.findById(id).orElse(null);
    }

    public void eliminarPostulacion(Long id) {
        postulacionRepository.deleteById(id);
    }
}
