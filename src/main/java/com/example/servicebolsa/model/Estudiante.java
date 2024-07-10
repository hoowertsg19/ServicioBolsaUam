package com.example.servicebolsa.model;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Estudiante extends Usuario {
    private String carrera;
    private Integer anioGraduacion;
    private String sexo;

    // Getters y setters
}
