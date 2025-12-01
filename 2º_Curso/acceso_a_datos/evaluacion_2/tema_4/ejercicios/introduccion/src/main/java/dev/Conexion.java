package dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Ejercicio 1: Mostrar nombre y edad de los jugadores menores de 30 años 
// Ejercicio 2: Insertar a Manuel
// Ejercicio 3: Cambiar el nombre de Guaita por Radu

public class Conexion {
    private Connection conexion;

    public void abrirConexion(String bd, String servidor, String usuario,
            String password) {
        try {
            String url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);
            // Establecemos la conexión con la BD
            this.conexion = DriverManager.getConnection(url, usuario, password);
            if (this.conexion != null) {
                System.out.println("Conectado a " + bd + " en " + servidor);
            } else {
                System.out.println("No conectado a " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Código error: " + e.getErrorCode());
        }
    }

    public void cerrarConexion() {
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

    public void consultaJugadores(String bd) {
        abrirConexion("celta", "localhost", "root", "");
        // El Statement se cierra solo al salir de catch
        try (Statement stmt = this.conexion.createStatement()) {
            // Consulta a ejecutar
            String query = "select * from jugadores_celta";
            // Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery(query);
            // Mientras queden filas en rs (el método next devuelve true) recorremos las
            // filas
            while (rs.next()) {
                // Se obtiene datos en función del número de columna o de su nombre
                System.out.println(rs.getString("nombre") + "\t" + rs.getInt("dorsal")); //
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }
}
