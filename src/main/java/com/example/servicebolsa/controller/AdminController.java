package com.example.servicebolsa.controller;

import com.example.servicebolsa.model.Empresa;
import com.example.servicebolsa.model.Vacante;
import com.example.servicebolsa.service.EmpresaService;
import com.example.servicebolsa.service.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private VacanteService vacanteService;

    @GetMapping("/solicitudes")
    public ResponseEntity<List<Empresa>> getSolicitudesPendientes() {
        List<Empresa> empresasPendientes = empresaService.getEmpresasPendientes();
        return new ResponseEntity<>(empresasPendientes, HttpStatus.OK);
    }

    @PutMapping("/aprobar/{id}")
    public ResponseEntity<Empresa> aprobarEmpresa(@PathVariable Long id, @RequestBody String password) {
        try {
            Empresa empresa = empresaService.aprobarEmpresa(id, password);
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/aprobadas")
    public ResponseEntity<List<Empresa>> getSolicitudesAprobadas() {
        List<Empresa> empresasAprobadas = empresaService.getEmpresasAprobadas();
        return new ResponseEntity<>(empresasAprobadas, HttpStatus.OK);
    }

    @PutMapping("/aprobar-vacante/{id}")
    public ResponseEntity<Vacante> aprobarVacante(@PathVariable Long id) {
        try {
            Vacante vacante = vacanteService.autorizarVacante(id);
            return new ResponseEntity<>(vacante, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
