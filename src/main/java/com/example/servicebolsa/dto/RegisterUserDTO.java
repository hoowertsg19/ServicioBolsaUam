package com.example.servicebolsa.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contrasena;
    private String tipoUsuario;
    private String cif;
    private String carrera;
    private Integer anioGraduacion;  // Cambiado a Integer
    private String sexo;

    // Getters y setters
    // ...
}
