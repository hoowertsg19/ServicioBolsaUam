package com.example.servicebolsa.dto;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private Long empresaId;
    private String currentPassword;
    private String newPassword;

    // Getters y setters
}

