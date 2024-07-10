package com.example.servicebolsa.controller;

import com.example.servicebolsa.model.Vacante;
import com.example.servicebolsa.service.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacantes")
public class VacanteController {

    @Autowired
    private VacanteService vacanteService;

    @PostMapping("/crear")
    public ResponseEntity<Vacante> crearVacante(@RequestBody Vacante vacante) {
        Vacante nuevaVacante = vacanteService.crearVacante(vacante);
        return ResponseEntity.ok(nuevaVacante);
    }

    @GetMapping
    public ResponseEntity<List<Vacante>> obtenerVacantes() {
        List<Vacante> vacantes = vacanteService.obtenerVacantes();
        return ResponseEntity.ok(vacantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacante> obtenerVacantePorId(@PathVariable Long id) {
        Vacante vacante = vacanteService.obtenerVacantePorId(id);
        return ResponseEntity.ok(vacante);
    }


    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Vacante>> obtenerVacantesPorEmpresaId(@PathVariable Long empresaId) {
        List<Vacante> vacantes = vacanteService.obtenerVacantesPorEmpresaId(empresaId);
        return ResponseEntity.ok(vacantes);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVacante(@PathVariable Long id) {
        vacanteService.eliminarVacante(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/autorizar/{id}")
    public ResponseEntity<Vacante> autorizarVacante(@PathVariable Long id) {
        Vacante vacante = vacanteService.autorizarVacante(id);
        return ResponseEntity.ok(vacante);
    }
}
