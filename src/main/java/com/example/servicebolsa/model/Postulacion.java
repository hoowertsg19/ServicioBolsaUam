package com.example.servicebolsa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacante_id", nullable = false)
    @JsonBackReference(value = "vacante-postulaciones") // Nombre único para la referencia
    private Vacante vacante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "egresado_id", nullable = true)
    @JsonBackReference(value = "egresado-postulaciones") // Nombre único para la referencia
    private Egresado egresado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", nullable = true)
    @JsonBackReference(value = "estudiante-postulaciones") // Nombre único para la referencia
    private Estudiante estudiante;

    private String estado; // Aceptado, Rechazado, Pendiente
    private Date fechaPostulacion;

    // Getters y Setters
}
