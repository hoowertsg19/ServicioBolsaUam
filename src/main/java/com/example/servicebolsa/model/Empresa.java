package com.example.servicebolsa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @Column(nullable = false)
    private String telefonoContacto;

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private boolean aprobada = false;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "empresa-vacantes")
    private List<Vacante> vacantes;

<<<<<<< HEAD
    // Getters y Setters
=======
    private String fotoPerfil; // Campo para almacenar la URL de la foto de perfil
>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)
}
