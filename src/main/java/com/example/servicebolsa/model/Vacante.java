package com.example.servicebolsa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String posicion;
    private String tipoVacante;
    private String ubicacion;
    private String tipoEmpleado;
    private String descripcion;
    private Boolean autorizado = false; // Por defecto, no autorizado
    private Boolean activa = true; // Por defecto, activa
    private Date fechaPublicacion;
    private Double salario; // Añadido el campo de salario
<<<<<<< HEAD
=======
    private String moneda; // Añadir campo para la moneda
>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    @JsonBackReference(value = "empresa-vacantes") // Nombre único para la referencia
    private Empresa empresa;

    @OneToMany(mappedBy = "vacante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "vacante-postulaciones") // Nombre único para la referencia
    private List<Postulacion> postulaciones;

    // Getters y Setters
}
