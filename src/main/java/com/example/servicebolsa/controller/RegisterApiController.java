package com.example.servicebolsa.controller;

import com.example.servicebolsa.dto.RegisterUserDTO;
import com.example.servicebolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegisterApiController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario/registro")
    public ResponseEntity<Map<String, String>> registerNewUser(@RequestBody RegisterUserDTO registerUserDTO) {
        if (registerUserDTO.getNombre() == null || registerUserDTO.getNombre().isEmpty() ||
                registerUserDTO.getApellido() == null || registerUserDTO.getApellido().isEmpty() ||
                registerUserDTO.getCorreoElectronico() == null || registerUserDTO.getCorreoElectronico().isEmpty() ||
                registerUserDTO.getContrasena() == null || registerUserDTO.getContrasena().isEmpty() ||
                registerUserDTO.getTipoUsuario() == null || registerUserDTO.getTipoUsuario().isEmpty() ||
                registerUserDTO.getCif() == null || registerUserDTO.getCif().isEmpty() ||
                registerUserDTO.getCarrera() == null || registerUserDTO.getCarrera().isEmpty() ||
                registerUserDTO.getSexo() == null || registerUserDTO.getSexo().isEmpty() ||
                registerUserDTO.getAnioGraduacion() == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Por favor completar todos los campos");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // Encriptar / Hashear la contraseña:
        String hashedPassword = BCrypt.hashpw(registerUserDTO.getContrasena(), BCrypt.gensalt());

        try {
            if ("egresado".equalsIgnoreCase(registerUserDTO.getTipoUsuario())) {
                usuarioService.registerNewEgresado(
                        registerUserDTO.getNombre(), registerUserDTO.getApellido(), registerUserDTO.getCorreoElectronico(),
                        hashedPassword, registerUserDTO.getTipoUsuario(), registerUserDTO.getCif(),
                        registerUserDTO.getCarrera(), registerUserDTO.getAnioGraduacion(), registerUserDTO.getSexo());
                Map<String, String> response = new HashMap<>();
                response.put("message", "Registro de egresado completado");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else if ("estudiante".equalsIgnoreCase(registerUserDTO.getTipoUsuario())) {
                usuarioService.registerNewEstudiante(
                        registerUserDTO.getNombre(), registerUserDTO.getApellido(), registerUserDTO.getCorreoElectronico(),
                        hashedPassword, registerUserDTO.getTipoUsuario(), registerUserDTO.getCif(),
                        registerUserDTO.getCarrera(), registerUserDTO.getAnioGraduacion(), registerUserDTO.getSexo());
                Map<String, String> response = new HashMap<>();
                response.put("message", "Registro de estudiante completado");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Tipo de usuario no válido");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Error al registrar usuario: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
