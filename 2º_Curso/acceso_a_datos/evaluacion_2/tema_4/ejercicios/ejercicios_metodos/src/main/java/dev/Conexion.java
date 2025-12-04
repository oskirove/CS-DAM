package dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection conexion;
    private String server = "localhost";
    private String user = "root";
    private String passwd = "";

    public void abrirConexion(String bd, String servidor, String usuario,
            String password) {
        try {
            String url = String.format("jdbc:mariadb://%s:3306/%s", servidor, bd);

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

    // Apartado 1

    public void consultaAlumnos(String DDBB) {

        abrirConexion(DDBB, server, user, passwd);

        String alumno = null;
        try (Statement stmt = this.conexion.createStatement()) {
            String query = "select nombre from alumnos";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                alumno = result.getString("nombre");
                System.out.println(alumno);
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    // Apartado 2

    public void insertarAlumnos(String DDBB, String nombre, String apellidos, int altura, int aula) {

        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {
            String query = String.format(
                    "INSERT INTO alumnos (nombre, apellidos, altura, aula) VALUES ('%s', '%s', %d, %d);", nombre,
                    apellidos, altura, aula);

            int filasAfectadas = stmt.executeUpdate(query);

            System.out.printf("Han afectado a %d filas", filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void insertarAula(String DDBB, int numero, String nombreAula, int puestos) {

        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {
            String query = String.format("INSERT INTO aulas (numero, nombreAula, puestos) VALUES (%d, '%s', %d);",
                    numero, nombreAula, puestos);

            int filasAfectadas = stmt.executeUpdate(query);

            System.out.printf("Han afectado a %d filas", filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    // Apartado 3

    public void eliminarAlumnos(String DDBB, String nombre) {

        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {
            String query = String.format("DELETE FROM alumnos where nombre='%s';", nombre);

            int filasAfectadas = stmt.executeUpdate(query);

            System.out.printf("Han afectado a %d filas", filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void eliminarAulas(String DDBB, String nombre) {

        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {

            String query = String.format("DELETE FROM aulas where nombreAula='%s';", nombre);

            int filasAfectadas = stmt.executeUpdate(query);

            System.out.printf("Han afectado a %d filas", filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    // Apartado 4

    public void actualizarAlumnos(String DDBB, String nombre, String apellidos, int altura, int aula) {
        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {

            String query = String.format("DELETE FROM aulas where nombreAula='%s';", nombre);

            int filasAfectadas = stmt.executeUpdate(query);

            System.out.printf("Han afectado a %d filas", filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }
}
