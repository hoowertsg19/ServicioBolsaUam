package com.example.servicebolsa.controller;

import com.example.servicebolsa.model.Postulacion;
import com.example.servicebolsa.service.PostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postulaciones")
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;

    @PostMapping("/crear")
    public ResponseEntity<Postulacion> crearPostulacion(@RequestBody Postulacion postulacion) {
        Postulacion nuevaPostulacion = postulacionService.crearPostulacion(postulacion);
        return ResponseEntity.ok(nuevaPostulacion);
    }

    @GetMapping
    public ResponseEntity<List<Postulacion>> obtenerPostulaciones() {
        List<Postulacion> postulaciones = postulacionService.obtenerPostulaciones();
        return ResponseEntity.ok(postulaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> obtenerPostulacionPorId(@PathVariable Long id) {
        Postulacion postulacion = postulacionService.obtenerPostulacionPorId(id);
        return ResponseEntity.ok(postulacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPostulacion(@PathVariable Long id) {
        postulacionService.eliminarPostulacion(id);
        return ResponseEntity.noContent().build();
    }
}
