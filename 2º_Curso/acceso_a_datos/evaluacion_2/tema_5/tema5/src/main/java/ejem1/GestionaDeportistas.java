package ejem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("deportistas")
public class GestionaDeportistas {

    private static final String URL = "jdbc:mariadb://localhost:3306/ad_tema6";
    private static final String USER = "root";
    private static final String PASSWD = "";

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response obtenerTodos() {

        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWD);
                    Statement st = conexion.createStatement();
                    ResultSet result = st.executeQuery("SELECT * FROM deportistas")) {

                while (result.next()) {
                    deportistas.add(new Deportista(
                            result.getInt("id"),
                            result.getString("nombre"),
                            result.getBoolean("activo"),
                            result.getString("deporte"),
                            result.getString("genero")));
                }

                return Response.ok(deportistas).build();

            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Rechazada").build();
            }

        } catch (ClassNotFoundException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Driver no encontrado").build();
        }
    }
}
