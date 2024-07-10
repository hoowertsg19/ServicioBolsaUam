package com.example.servicebolsa.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private boolean success;
    private String message;
    private Long userId;

    public LoginResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public LoginResponseDTO(boolean success, String message, Long userId) {
        this.success = success;
        this.message = message;
        this.userId = userId;
    }
}
