package ejem1.deportista;

import java.util.ArrayList;

import ejem1.deportista.entity.Deportista;
import ejem1.exceptions.ResourceNotFoundException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("deportista")
public class Controller {

    private Service service = new Service();

    // ejercicio 1
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response findAll() {
        ArrayList<Deportista> lista = service.findAll();
        return Response.ok(lista).build();
    }

    // ejercicio 2
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findOne(@PathParam("id") int id) {
        try {
            Deportista d = service.findOne(id);
            return Response.ok(d).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    // ejercicio 3
    @GET
    @Path("/deporte/{nombreDeporte}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findBySport(@PathParam("nombreDeporte") String nombreDeporte) {
        try {
            ArrayList<Deportista> deportistas = service.findBySport(nombreDeporte);
            return Response.ok(deportistas).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}