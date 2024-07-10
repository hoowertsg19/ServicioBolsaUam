package com.example.servicebolsa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String correoElectronico;
    private String password;
    private String role;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // Getters y setters
}
