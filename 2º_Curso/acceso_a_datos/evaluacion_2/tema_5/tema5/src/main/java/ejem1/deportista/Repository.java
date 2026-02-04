package ejem1.deportista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ejem1.deportista.entity.Deportista;

public class Repository {
    private final String URL = "jdbc:mariadb://localhost:3306/ad_tema6";
    private final String USER = "root";
    private final String PASSWD = "";

    // Ejercicio 1
    public ArrayList<Deportista> getAll() throws ClassNotFoundException, SQLException {

        ArrayList<Deportista> deportistas = new ArrayList<>();

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
        }

        return deportistas;
    }

    // Ejercicio 2
    public Deportista getOne(int id) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String sql = "SELECT * FROM deportistas WHERE id = ?";

        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWD);
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet result = ps.executeQuery()) {
                if (result.next()) {
                    return new Deportista(
                            result.getInt("id"),
                            result.getString("nombre"),
                            result.getBoolean("activo"),
                            result.getString("deporte"),
                            result.getString("genero"));
                }
            }
        }
        return null;
    }
}