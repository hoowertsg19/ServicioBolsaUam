package com.example.servicebolsa.dto;

import lombok.Data;

@Data
public class CuentaLoginResponseDTO {
    private boolean success;
    private String role;
    private String message;
    private Long empresaId; // Añadir este campo

    // Getters y setters
}
