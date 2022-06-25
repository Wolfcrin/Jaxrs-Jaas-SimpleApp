package ar.com.wolfscrin.webapp.jaxrs.repositories;

import ar.com.wolfscrin.webapp.jaxrs.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Curso porId(Long id);
    void eliminar(Long id);
}
