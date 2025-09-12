package app;

public class Astro {
    private String nombre;
    private Double radio;

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.nombre = nombre.toUpperCase().trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre(char separador) {
        String cadena = "";
        for (int i = 0; i < nombre.length(); i++) {

            cadena += nombre.charAt(i);

            if (i < nombre.length() - 1) {
                cadena += separador;
            }
        }

        return cadena;
    }

    public void setRadio(Double radio) {

        if (radio < 0) {
            throw new RadioNegativoException("El radio no puede ser negativo");
        }

        this.radio = radio;
    }

    @Override
    public boolean equals(Object nombre) {
        if (nombre instanceof Astro) {
            if (this.nombre == nombre.toString()) {
                return true;
            }
        }
        return false;
    }

}
