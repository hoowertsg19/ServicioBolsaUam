package com.example.servicebolsa.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.*;

@Entity
@Data
public class Egresado extends Usuario {
    private String carrera;
    private Integer anioGraduacion;
    private String sexo;

    // Getters y setters
}

