package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Vacante;
import com.example.servicebolsa.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class VacanteService {

    @Autowired
    private VacanteRepository vacanteRepository;

    @Autowired
    private EmailService emailService;

    private static final String ADMIN_EMAIL = "hjgross@uamv.edu.ni"; // Correo del administrador

    @Transactional
    public Vacante crearVacante(Vacante vacante) {
        vacante.setFechaPublicacion(new Date());
        vacante.setActiva(false); // Inicialmente inactiva hasta que sea aprobada
        Vacante nuevaVacante = vacanteRepository.save(vacante);

        // Enviar correo al administrador
        String subject = "Nueva Vacante Publicada: " + nuevaVacante.getPosicion();
        String text = "Se ha creado una nueva vacante. Por favor, revisa y autoriza.\n\n" +
                "ID: " + nuevaVacante.getId() + "\n" +
                "Posición: " + nuevaVacante.getPosicion() + "\n" +
                "Empresa: " + (nuevaVacante.getEmpresa() != null ? nuevaVacante.getEmpresa().getNombre() : "Desconocida");
        emailService.sendEmail(ADMIN_EMAIL, subject, text);

        return nuevaVacante;
    }

    public List<Vacante> obtenerVacantes() {
        return vacanteRepository.findAll();
    }

    public Vacante obtenerVacantePorId(Long id) {
        return vacanteRepository.findById(id).orElse(null);
    }

    public void eliminarVacante(Long id) {
        vacanteRepository.deleteById(id);
    }

    @Transactional
    public Vacante autorizarVacante(Long id) {
        Vacante vacante = obtenerVacantePorId(id);
        if (vacante != null) {
            vacante.setAutorizado(true);
            vacante.setActiva(true); // Activar la vacante al ser aprobada
            vacanteRepository.save(vacante);
        }
        return vacante;
    }

    public List<Vacante> obtenerVacantesPorEmpresaId(Long empresaId) {
        return vacanteRepository.findByEmpresaId(empresaId)
                .stream()
                .filter(Vacante::getAutorizado)
                .collect(Collectors.toList());
    }
}
