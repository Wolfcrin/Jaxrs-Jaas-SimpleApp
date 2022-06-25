package ar.com.wolfscrin.cliente.jaxrs;

import ar.com.wolfscrin.cliente.jaxrs.models.Curso;
import ar.com.wolfscrin.cliente.jaxrs.models.Instructor;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client.target("http://127.0.0.1:8080/webapp-jaxrs-jaas/api").path("/cursos");

       // rootUri.register(new BasicAuthentication("admin","Adm1n4817++"));
        rootUri.register(new BasicAuthentication("pepe","P3p34817++"));
        //
        System.out.println("===================== POR ID ====================");
        Response response = rootUri.path("/2").request(MediaType.APPLICATION_JSON).get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println(curso);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());
        System.out.println(response.getHeaders());

        System.out.println("===================== Listar ====================");
        listar(rootUri);

        System.out.println("===================== Creando ====================");
        Curso cursoNuevo = new Curso();
        cursoNuevo.setNombre("Curso Godot X");
        cursoNuevo.setDescripcion("Curso de creacion de videogame con godot X");
        cursoNuevo.setDuracion(40.0);

        Instructor instructor = new Instructor();
        // podemos buscar al back
        instructor.setId(1);
        cursoNuevo.setInstructor(instructor);

        Entity<Curso> entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        curso = rootUri.request(MediaType.APPLICATION_JSON).post(entityHeader,Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("===================== PUT ====================");

        Curso cursoEditado = curso;
        cursoEditado.setNombre("Curso Godot 2 ");
        cursoEditado.setDuracion(35.0);

        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/" + curso.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader,Curso.class);
        listar(rootUri);

        System.out.println("===================== DELETE ====================");
        rootUri.path("/" + curso.getId() ).request().delete();

        listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        System.out.println("===================== Lista Actualizada ====================");
        List<Curso> cursos = rootUri.request(MediaType.APPLICATION_JSON)
                            .get(Response.class).readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);
    }


}
