package dev;

import java.sql.SQLException;

public class Application {
  public static void main(String[] args) {
    String dataBase = "add";
    Conexion db = new Conexion();

    // Apartado 1
    // db.consultaAlumnos(dataBase);

    // Apartado 2
    // db.insertarAlumnos(dataBase, "Óscar", "Rodríguez Vega", 170, 11);
    // db.insertarAula(dataBase, 9, "Acceso a datos", 28);

    // Apartado 3
    // db.eliminarAlumnos(dataBase, "Óscar");
    // db.eliminarAulas(dataBase, "Acceso a datos");

    // Apartado 4
    // db.actualizarAlumnos(dataBase, 8, "Juanin", "García", 120, 20);

    // Apartado 5
    // db.consultaAulaConAlumnos(dataBase);
    // db.datosAprobado(dataBase);
    // db.asignaturas(dataBase);

    // Apartado 6
    // db.analizarPatron(dataBase, 6, 170);
    try {
      db.analizarPatronPS(dataBase, 6, 170);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
