package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Cuenta;
import com.example.servicebolsa.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class CuentaService {

    private static final Logger logger = LoggerFactory.getLogger(CuentaService.class);

    @Autowired
    private CuentaRepository cuentaRepository;

    public boolean loginCuenta(String correoElectronico, String password) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findByCorreoElectronico(correoElectronico);
        if (cuentaOpt.isPresent()) {
            Cuenta cuenta = cuentaOpt.get();
            if (cuenta.getPassword() != null) {
                // Verificar la contraseña sin encriptar
                boolean matches = password.equals(cuenta.getPassword());
                logger.info("Contraseña almacenada: {}", cuenta.getPassword());
                logger.info("Comparando contraseñas para {}: {}, Resultado: {}", correoElectronico, password, matches);
                return matches;
            }
        } else {
            logger.info("No se encontró ninguna cuenta para el correo electrónico: {}", correoElectronico);
        }
        return false;
    }

    public Long getEmpresaId(String correoElectronico) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findByCorreoElectronico(correoElectronico);
        return cuentaOpt.map(cuenta -> cuenta.getEmpresa().getId()).orElse(null);
    }
}
