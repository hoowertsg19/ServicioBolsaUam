package com.example.servicebolsa.service;

import com.example.servicebolsa.model.Postulacion;
import java.util.List;

public interface IPostulacionService {
    List<Postulacion> getAllPostulaciones();
    Postulacion getPostulacionById(Long id);
    Postulacion createPostulacion(Postulacion postulacion);
    Postulacion updatePostulacion(Long id, Postulacion postulacion);
    void deletePostulacion(Long id);
}
