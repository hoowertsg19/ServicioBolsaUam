package com.example.servicebolsa.controller;

import com.example.servicebolsa.dto.CuentaLoginRequestDTO;
import com.example.servicebolsa.dto.CuentaLoginResponseDTO;
import org.springframework.web.bind.annotation.RestController;
import com.example.servicebolsa.dto.LoginRequestDTO;
import com.example.servicebolsa.dto.LoginResponseDTO;
import com.example.servicebolsa.service.UsuarioService;
import com.example.servicebolsa.service.CuentaService; // Importar el nuevo servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginApiController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CuentaService cuentaService; // Autowire del nuevo servicio

    @PostMapping("/usuario/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = usuarioService.loginUser(loginRequestDTO);
        if (response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }



    @PostMapping("/cuenta/login")
    public ResponseEntity<CuentaLoginResponseDTO> loginCuenta(@RequestBody CuentaLoginRequestDTO requestDTO) {
        boolean isAuthenticated = cuentaService.loginCuenta(requestDTO.getCorreoElectronico(), requestDTO.getPassword());
        CuentaLoginResponseDTO response = new CuentaLoginResponseDTO();
        response.setSuccess(isAuthenticated);
        if (isAuthenticated) {
            response.setRole("EMPRESA");
            response.setMessage("Inicio de sesión exitoso");
            response.setEmpresaId(cuentaService.getEmpresaId(requestDTO.getCorreoElectronico()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage("Credenciales inválidas");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}
