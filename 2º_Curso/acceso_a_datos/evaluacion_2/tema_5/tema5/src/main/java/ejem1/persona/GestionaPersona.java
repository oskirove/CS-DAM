package ejem1.persona;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/persona")
public class GestionaPersona {

    private ArrayList<Persona> personas = new ArrayList<>();
    private Persona persona;
    
    @DefaultValue("valor por defecto")
    @QueryParam("valor")

    String text;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response leer() {
        persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan");
        persona.setCasado(false);
        persona.setSexo("Masculino");
        personas.add(persona);
        return Response.ok(personas).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(Persona persona) {
        this.personas.add(persona);
        return Response.ok(persona).build();
    }

}