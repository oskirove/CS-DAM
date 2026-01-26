package ejem1;

import java.util.ArrayList;
import java.util.Collections;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/add")
public class Add {
    private static ArrayList<Persona> personas = new ArrayList<>();

    //ejercicio 7
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response añadirVariasPersonasArray(Persona[] arrayPersonas) {
        
        Collections.addAll(personas, arrayPersonas);

        return Response.ok(personas).build();
    }
}
