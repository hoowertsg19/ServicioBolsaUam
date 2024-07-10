package com.example.servicebolsa.repository;

import com.example.servicebolsa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    boolean existsByCorreoElectronico(String correoElectronico);
    List<Empresa> findByAprobadaFalse();
    List<Empresa> findByAprobadaTrue();
}
