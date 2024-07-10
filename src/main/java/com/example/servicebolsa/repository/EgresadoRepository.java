package com.example.servicebolsa.repository;

import com.example.servicebolsa.model.Egresado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EgresadoRepository extends JpaRepository<Egresado, Long> {

}
