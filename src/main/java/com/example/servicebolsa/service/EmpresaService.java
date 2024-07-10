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
<<<<<<< HEAD

import java.util.List;
=======
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)

@Service
public class EmpresaService {

    private static final Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private EmailService emailService;

<<<<<<< HEAD
=======
    private final String uploadDir = "path/to/upload/directory/";

>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)
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
<<<<<<< HEAD
}
=======

    public boolean actualizarPassword(Long empresaId, String currentPassword, String newPassword) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findByEmpresaId(empresaId);

        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();

            if (cuenta.getPassword().equals(currentPassword)) {
                cuenta.setPassword(newPassword);
                cuentaRepository.save(cuenta);
                logger.info("Contraseña actualizada exitosamente para la empresa con ID: {}", empresaId);
                return true;
            } else {
                logger.error("La contraseña actual no coincide para la empresa con ID: {}", empresaId);
                return false;
            }
        } else {
            logger.error("Cuenta no encontrada para la empresa con ID: {}", empresaId);
            return false;
        }
    }

    public void actualizarFotoPerfil(Long id, String urlFotoPerfil) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            empresa.setFotoPerfil(urlFotoPerfil);
            empresaRepository.save(empresa);
        } else {
            throw new RuntimeException("Empresa no encontrada");
        }
    }

    public String guardarArchivoYObtenerURL(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File destinationFile = new File(uploadDir + fileName);
        file.transferTo(destinationFile);
        return "/uploads/" + fileName;
    }
    public Empresa updateEmpresa(Long id, Empresa empresaDetails) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa no encontrada para el ID: " + id));

        empresa.setNombre(empresaDetails.getNombre());
        empresa.setCorreoElectronico(empresaDetails.getCorreoElectronico());
        empresa.setUbicacion(empresaDetails.getUbicacion());
        empresa.setTelefonoContacto(empresaDetails.getTelefonoContacto());
        // Actualiza otros campos según sea necesario

        return empresaRepository.save(empresa);
    }
}

>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)
