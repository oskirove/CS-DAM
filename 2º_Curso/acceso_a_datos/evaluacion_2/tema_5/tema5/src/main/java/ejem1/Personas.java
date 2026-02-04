package ejem1;

import java.util.ArrayList;
import java.util.Collections;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class Personas {
    public static ArrayList<Persona> personas = new ArrayList<>();

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardar(Persona persona) {
        personas.add(persona);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response listar() {

        return Response.ok(personas).build();
    }

    // ejercicio 3
    @GET
    @Path("/{nombre}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response ver(@PathParam("nombre") String nombre) {
        Response respuesta = null;
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                respuesta = Response.ok(persona).build();
            }
        }
        return respuesta;
    }

    // ejercicio 4
    @GET
    @Path("/buscar")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response ver2(@QueryParam("nombre") String nombre) {
        Response respuesta = null;
        for (Persona persona : personas) {
            if (persona.getNombre().toLowerCase().equals(nombre)) {
                respuesta = Response.ok(persona).build();
            }
        }

        return respuesta;
    }

    // ejercicio 6
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public void formSetPersona(@FormParam("id") int id, @FormParam("nombre") String nombre,
            @FormParam("casado") boolean casado, @FormParam("sexo") String sexo) {
        personas.add(new Persona(id, nombre, casado, sexo));
    }

    // ejercicio 7
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response añadirVariasPersonasArray(Persona[] arrayPersonas) {

        Collections.addAll(personas, arrayPersonas);

        return Response.ok(personas).build();
    }

    // Ejercicio 8
    @POST
    @Path("eliminar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePersonaArray(@PathParam("id") int id) {
        personas.removeIf(p -> p.getId() == id);
        return Response.ok(personas).build();
    }

    // Ejercicio 9
    @GET
    @Path("/buscar2")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response verParametrosDefecto(@DefaultValue("juan") @QueryParam("nombre") String nombre) {
        Response respuesta = null;
        for (Persona persona : personas) {
            if (persona.getNombre().toLowerCase().equals(nombre)) {
                respuesta = Response.ok(persona).build();
            }
        }

        return respuesta;
    }

    // Ejercicio 11

    
}
