package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Empresa;
import java.util.List;

public interface IEmpresaService {
    List<Empresa> getAllEmpresas();
    Empresa getEmpresaById(Long id);
    Empresa createEmpresa(Empresa empresa);
    Empresa updateEmpresa(Long id, Empresa empresa);
    void deleteEmpresa(Long id);
}
