package com.example.servicebolsa;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordComparisonTest {
    public static void main(String[] args) {
        // Contraseña cifrada almacenada en la base de datos (actualizada)
        String storedPassword = "$2a$10$lTXW1YQ/YYh4LvBzcTdjVekBjsDKFdbXXnhMQJMzxBslWo1LT54sW";

        // Contraseña que deseas probar
        String inputPassword = "jorge12";
        // yComparar la contraseña ingresada con la contraseña cifrada
        boolean passwordMatch = BCrypt.checkpw(inputPassword, storedPassword);

        // Imprimir el resultado de la comparación
        if (passwordMatch) {
            System.out.println("Password match: true");
        } else {
            System.out.println("Password match: false");
        }
    }
}
