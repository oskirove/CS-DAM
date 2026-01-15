package dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            String url = String.format("jdbc:mariadb://%s:3306/%s?useServerPrepStmts=true", servidor, bd);

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

    public void actualizarAlumnos(String DDBB, int codAlumno, String nombre, String apellidos, int altura, int aula) {
        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {

            String query = String.format(
                    "UPDATE alumnos SET nombre='%s', apellidos='%s', altura=%s, aula=%s WHERE codigo=%s;", nombre,
                    apellidos, altura, aula, codAlumno);

            int filasAfectadas = stmt.executeUpdate(query);

            System.out.printf("Han afectado a %d filas", filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    // Apartado 5

    public void consultaAulaConAlumnos(String DDBB) {
        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {
            String query = "SELECT DISTINCT A.nombreAula FROM aulas A JOIN alumnos AL ON A.numero = AL.aula WHERE A.nombreAula IS NOT NULL";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String nombre = result.getString("nombreAula");
                System.out.println(nombre);
            }
        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void datosAprobado(String DDBB) {
        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {

            String query = "SELECT AL.nombre AS alumno, N.nota AS notaAlumno, T.nombre AS asignatura FROM notas N JOIN asignaturas T ON N.asignatura = T.COD JOIN alumnos AL ON N.alumno = AL.codigo WHERE N.nota >= 5";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String nombre = result.getString("alumno");
                int nota = result.getInt("notaAlumno");
                String asignatura = result.getString("asignatura");
                System.out.printf("%-10s | %-30s | %-2s %n", nombre, asignatura, nota);
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void asignaturas(String DDBB) {
        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {

            String query = "SELECT NOMBRE FROM asignaturas";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String nombre = result.getString("NOMBRE");

                System.out.printf("%-30s%n", nombre);
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    // Apartado 6
    public void analizarPatron(String DDBB, int patronNombre, int patronAltura) {
        abrirConexion(DDBB, server, user, passwd);

        try (Statement stmt = this.conexion.createStatement()) {

            String query = String.format("SELECT nombre FROM alumnos WHERE LENGTH(nombre) < %s AND altura < %s",
                    patronNombre, patronAltura);

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String nombre = result.getString("nombre");

                System.out.printf("%-10s%n", nombre);
            }

        } catch (SQLException e) {
            System.out.println("Se ha producido un error: " + e.getLocalizedMessage());
        } finally {
            cerrarConexion();
        }
    }

    private PreparedStatement ps = null;

    public void analizarPatronPS(String DDBB, int patronNombre, int patronAltura) throws SQLException {
        abrirConexion(DDBB, server, user, passwd);

        String query = String.format("SELECT nombre FROM alumnos WHERE LENGTH(nombre) < %s AND altura < %s",
                patronNombre, patronAltura);

        if (this.ps == null)
            this.ps = this.conexion.prepareStatement(query);
        ps.setInt(1, patronNombre);
        ps.setInt(2, patronAltura);
        ResultSet resu = ps.executeQuery();
        while (resu.next()) {
            System.out.println(resu.getInt(1) + "\t" + resu.getString("nombreAula"));
        }

    }
}
