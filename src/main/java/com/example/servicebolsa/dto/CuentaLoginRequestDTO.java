package com.example.servicebolsa.dto;

import lombok.Data;

@Data
public class CuentaLoginRequestDTO {
    private String correoElectronico;
    private String password;

    // Getters y setters
}
