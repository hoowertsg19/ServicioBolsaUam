package com.example.servicebolsa.repository;

import com.example.servicebolsa.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByCorreoElectronico(String correoElectronico);
<<<<<<< HEAD
=======
    Optional<Cuenta> findByEmpresaId(Long empresaId);
>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)
}
