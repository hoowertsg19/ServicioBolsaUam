package com.example.servicebolsa.controller;

import com.example.servicebolsa.model.Empresa;
import com.example.servicebolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin("*")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping(value = "/registrar", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Empresa> registrarEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.registrarEmpresa(empresa);
        return ResponseEntity.ok(nuevaEmpresa);
    }

    @PostMapping(value = "/aprobar/{id}", produces = "application/json")
    public ResponseEntity<Empresa> aprobarEmpresa(@PathVariable Long id, @RequestParam String password) {
        Empresa empresaAprobada = empresaService.aprobarEmpresa(id, password);
        return ResponseEntity.ok(empresaAprobada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = empresaService.obtenerEmpresaPorId(id);
        return ResponseEntity.ok(empresa);
    }
}
