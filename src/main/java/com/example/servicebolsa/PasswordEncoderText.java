package com.example.servicebolsa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderText {
    public static void main(String[] args) {
        // Inicializar el PasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Contraseña original
        String originalPassword = "SecurePass456";
        System.out.println("Original password: " + originalPassword);

        // Encriptar la contraseña
        String encodedPassword = passwordEncoder.encode(originalPassword);
        System.out.println("Encoded password: " + encodedPassword);

        // Comparar la contraseña original con la encriptada
        boolean isMatch = passwordEncoder.matches(originalPassword, encodedPassword);

        // Imprimir el resultado de la comparación
        System.out.println("Password match: " + isMatch);
    }
}
