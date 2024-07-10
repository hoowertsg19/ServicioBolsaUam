package com.example.servicebolsa.service;

import com.example.servicebolsa.dto.LoginRequestDTO;
import com.example.servicebolsa.dto.LoginResponseDTO;
import com.example.servicebolsa.model.Egresado;
import com.example.servicebolsa.model.Estudiante;
import com.example.servicebolsa.model.Usuario;
import com.example.servicebolsa.repository.EgresadoRepository;
import com.example.servicebolsa.repository.EstudianteRepository;
import com.example.servicebolsa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private EgresadoRepository egresadoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Egresado registerNewEgresado(String nombre, String apellido, String correoElectronico, String contrasena, String tipoUsuario, String cif, String carrera, Integer anioGraduacion, String sexo) {
        Egresado egresado = new Egresado();
        egresado.setNombre(nombre);
        egresado.setApellido(apellido);
        egresado.setCorreoElectronico(correoElectronico);
        egresado.setContrasena(contrasena);
        egresado.setTipoUsuario(tipoUsuario);
        egresado.setCif(cif);
        egresado.setCarrera(carrera);
        egresado.setAnioGraduacion(anioGraduacion);
        egresado.setSexo(sexo);
        return egresadoRepository.save(egresado);
    }

    public Estudiante registerNewEstudiante(String nombre, String apellido, String correoElectronico, String contrasena, String tipoUsuario, String cif, String carrera, Integer anioGraduacion, String sexo) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCorreoElectronico(correoElectronico);
        estudiante.setContrasena(contrasena);
        estudiante.setTipoUsuario(tipoUsuario);
        estudiante.setCif(cif);
        estudiante.setCarrera(carrera);
        estudiante.setAnioGraduacion(anioGraduacion);
        estudiante.setSexo(sexo);
        return estudianteRepository.save(estudiante);
    }

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {
        Usuario usuario = usuarioRepository.findByCif(loginRequestDTO.getCif());
        if (usuario != null && BCrypt.checkpw(loginRequestDTO.getContrasena(), usuario.getContrasena())) {
            return new LoginResponseDTO(true, "Login successful", usuario.getIdUsuario());
        } else {
            return new LoginResponseDTO(false, "Invalid CIF or password");
        }
    }
}
