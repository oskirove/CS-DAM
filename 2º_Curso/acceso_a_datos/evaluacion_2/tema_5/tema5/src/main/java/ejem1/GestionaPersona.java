package ejem1;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/persona")
public class GestionaPersona {

    private static Persona persona;
    private 

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response leer() {
        return null;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response guardar() {
        try {
            persona = new Persona(1, "Juan", true, "Masculino");
            return Response.ok(persona).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}