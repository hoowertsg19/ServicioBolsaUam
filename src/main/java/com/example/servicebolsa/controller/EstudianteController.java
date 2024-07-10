package com.example.servicebolsa.controller;

import com.example.servicebolsa.model.Estudiante;
import com.example.servicebolsa.service.IEstudianteService;
import com.example.servicebolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante getEstudianteById(@PathVariable Long id) {
        return estudianteService.getEstudianteById(id);
    }

    @PutMapping("/update/{id}")
    public Estudiante updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return estudianteService.updateEstudiante(id, estudiante);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
    }
}
