package dev;

public class Application {
  public static void main(String[] args) {
    Conexion db = new Conexion();

    db.consultaJugadores("celta");
  }
}
