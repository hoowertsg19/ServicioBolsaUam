package com.example.servicebolsa.repository;

import com.example.servicebolsa.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into usuario(nombre, apellido, correo_electronico,contrasena,tipo_usuario,cif)VALUES(:nombre, :apellido, :correo_electronico,:contrasena, :tipo_usuario, :cif)", nativeQuery = true)
    int registerNewUser(@Param("nombre") String nombre,
                        @Param("apellido") String apellido,
                        @Param("correo_electronico") String correoElectronico,
                        @Param("contrasena") String contrasena,
                        @Param("tipo_usuario") String tipoUsuario,
                        @Param("cif") String cif);
    Usuario findByCif(String cif);

}
