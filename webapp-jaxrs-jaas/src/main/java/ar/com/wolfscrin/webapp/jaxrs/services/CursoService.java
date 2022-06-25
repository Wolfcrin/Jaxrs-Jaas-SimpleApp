package ar.com.wolfscrin.webapp.jaxrs.services;

import jakarta.ejb.Local;
import jakarta.jws.WebService;
import ar.com.wolfscrin.webapp.jaxrs.models.Curso;

import java.util.List;
import java.util.Optional;

@Local
@WebService
public interface CursoService {
    List<Curso> listar();
    Curso guardar(Curso curso);

    Optional<Curso> porId(Long id);
    void eliminar(Long id);
}
