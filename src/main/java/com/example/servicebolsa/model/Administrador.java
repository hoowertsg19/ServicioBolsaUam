package com.example.servicebolsa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Administrador extends Usuario {
    private String telefono;
}
