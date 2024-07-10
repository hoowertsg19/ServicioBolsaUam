package com.example.servicebolsa.controller;

import com.example.servicebolsa.model.Egresado;
import com.example.servicebolsa.service.IEgresadoService;
import com.example.servicebolsa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egresados")
public class EgresadoController {

    @Autowired
    private IEgresadoService egresadoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Egresado> getAllEgresados() {
        return egresadoService.getAllEgresados();
    }

    @GetMapping("/{id}")
    public Egresado getEgresadoById(@PathVariable Long id) {
        return egresadoService.getEgresadoById(id);
    }


    @PutMapping("/update/{id}")
    public Egresado updateEgresado(@PathVariable Long id, @RequestBody Egresado egresado) {
        return egresadoService.updateEgresado(id, egresado);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEgresado(@PathVariable Long id) {
        egresadoService.deleteEgresado(id);
    }
}
