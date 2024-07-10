package com.example.servicebolsa.controller;

<<<<<<< HEAD
import com.example.servicebolsa.model.Empresa;
import com.example.servicebolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
=======
import com.example.servicebolsa.dto.ApiResponse;
import com.example.servicebolsa.dto.UpdatePasswordRequest;
import com.example.servicebolsa.model.Empresa;
import com.example.servicebolsa.service.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin("*")
public class EmpresaController {

<<<<<<< HEAD
=======
    private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class);

>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)
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
<<<<<<< HEAD
=======

    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest request) {
        boolean success = empresaService.actualizarPassword(request.getEmpresaId(), request.getCurrentPassword(), request.getNewPassword());
        if (success) {
            return ResponseEntity.ok(new ApiResponse(true, "Contraseña actualizada exitosamente"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Error al actualizar la contraseña"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        try {
            Empresa updatedEmpresa = empresaService.updateEmpresa(id, empresa);
            return ResponseEntity.ok(updatedEmpresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/{id}/fotoPerfil")
    public ResponseEntity<?> actualizarFotoPerfil(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            logger.info("Actualizando foto de perfil para la empresa con ID: {}", id);
            String urlFotoPerfil = empresaService.guardarArchivoYObtenerURL(file);
            empresaService.actualizarFotoPerfil(id, urlFotoPerfil);
            logger.info("Foto de perfil actualizada exitosamente para la empresa con ID: {}", id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error al actualizar la foto de perfil para la empresa con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo actualizar la foto de perfil");
        }
    }
>>>>>>> d50a1d4 (Modificacion en las clases correspondientes a Empresa)
}
