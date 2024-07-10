package com.example.servicebolsa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contrasena;
    private String tipoUsuario;
    private String cif; // Asegúrate de que el campo CIF está aquí
}


