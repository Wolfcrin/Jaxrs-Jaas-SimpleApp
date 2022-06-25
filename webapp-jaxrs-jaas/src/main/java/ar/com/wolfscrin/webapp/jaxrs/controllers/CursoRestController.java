package ar.com.wolfscrin.webapp.jaxrs.controllers;


import ar.com.wolfscrin.webapp.jaxrs.services.CursoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ar.com.wolfscrin.webapp.jaxrs.models.Curso;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
public class CursoRestController {

    @Inject
    private CursoService service;

    @GET

    public List<Curso> listar(){
        return service.listar();
    }
//    public Response listar(){
//        return Response.ok(service.listar()).build();
//    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") long id){
        Optional<Curso> cursoOpt = service.porId(id);

        if( cursoOpt.isPresent()){
            return  Response.ok(cursoOpt.get()).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso){

        try{
            Curso nuevoCurso = service.guardar(curso);
            return Response.ok(nuevoCurso).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") long id, Curso curso){
        Optional<Curso>  cursoOpt= service.porId(id);

        if(cursoOpt.isPresent()){
            Curso nuevoCurso = cursoOpt.get();
            nuevoCurso.setDescripcion(curso.getDescripcion());
            nuevoCurso.setNombre(curso.getNombre());
            nuevoCurso.setDuracion(curso.getDuracion());
            nuevoCurso.setInstructor(curso.getInstructor());

            try{
                service.guardar(nuevoCurso);
                return Response.ok(nuevoCurso).build();
            }catch(Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }

        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") long id){
        Optional<Curso> cursoOpt = service.porId(id);
        if(cursoOpt.isPresent()){

            try{
                service.eliminar(cursoOpt.get().getId());
                return Response.noContent().build();
            }catch(Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return  Response.status(Response.Status.NOT_FOUND).build();
    }

}
