package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Empresa;
import com.example.servicebolsa.model.Cuenta;
import com.example.servicebolsa.repository.CuentaRepository;
import com.example.servicebolsa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class EmpresaService {

    private static final Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private EmailService emailService;

    public Empresa registrarEmpresa(Empresa empresa) {
        if (empresaRepository.existsByCorreoElectronico(empresa.getCorreoElectronico())) {
            logger.error("El correo electrónico ya está registrado: {}", empresa.getCorreoElectronico());
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }
        empresa.setAprobada(false);
        Empresa nuevaEmpresa = empresaRepository.save(empresa);

        try {
            // Enviar correo al administrador
            String adminEmail = "hjgross@uamv.edu.ni"; // Reemplazar con el correo del administrador
            String subject = "Nueva Solicitud de Registro de Empresa";
            String text = "Una nueva empresa ha solicitado el registro.\n\n" +
                    "Nombre: " + empresa.getNombre() + "\n" +
                    "Correo: " + empresa.getCorreoElectronico() + "\n" +
                    "Por favor, revise y apruebe la solicitud en el sistema.";
            emailService.sendEmail(adminEmail, subject, text);
            logger.info("Correo de notificación enviado al administrador: {}", adminEmail);
        } catch (MailException e) {
            logger.error("Error al enviar el correo de notificación al administrador: {}", e.getMessage());
        }

        logger.info("Empresa registrada exitosamente: {}", empresa.getCorreoElectronico());
        return nuevaEmpresa;
    }

    public Empresa aprobarEmpresa(Long id, String password) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Empresa no encontrada: {}", id);
                    return new RuntimeException("Empresa no encontrada");
                });
        empresa.setAprobada(true);
        Empresa empresaAprobada = empresaRepository.save(empresa);

        // Crear cuenta para la empresa
        Cuenta cuenta = new Cuenta();
        cuenta.setCorreoElectronico(empresa.getCorreoElectronico());
        cuenta.setPassword(password); // No se encripta la contraseña
        cuenta.setRole("EMPRESA");
        cuenta.setEmpresa(empresa);
        cuentaRepository.save(cuenta);

        logger.info("Contraseña guardada sin encriptar para la empresa {}: {}", empresa.getCorreoElectronico(), cuenta.getPassword());

        try {
            // Enviar correo a la empresa
            String subject = "Registro Aprobado";
            String text = "Su registro ha sido aprobado. Su contraseña es: " + password;
            emailService.sendEmail(empresa.getCorreoElectronico(), subject, text);
            logger.info("Correo de notificación enviado a la empresa: {}", empresa.getCorreoElectronico());
        } catch (MailException e) {
            logger.error("Error al enviar el correo de notificación a la empresa: {}", e.getMessage());
        }

        logger.info("Empresa aprobada: {}", empresa.getCorreoElectronico());
        return empresaAprobada;
    }

    public Empresa obtenerEmpresaPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public List<Empresa> getEmpresasPendientes() {
        List<Empresa> empresasPendientes = empresaRepository.findByAprobadaFalse();
        logger.info("Empresas pendientes de aprobación: {}", empresasPendientes.size());
        return empresasPendientes;
    }

    public List<Empresa> getEmpresasAprobadas() {
        List<Empresa> empresasAprobadas = empresaRepository.findByAprobadaTrue();
        logger.info("Empresas aprobadas: {}", empresasAprobadas.size());
        return empresasAprobadas;
    }
}
