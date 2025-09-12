package app;

import java.util.ArrayList;

public class Cadena {
    private ArrayList<Character> cadena = new ArrayList<>();

    public void setCadena(String cadena) {

        cadena.trim();

        for (int i = 0; i < cadena.length(); i++) {
            this.cadena.add(cadena.charAt(i));
        }
    }

    public void eliminar(char caracter) {
        for(int i = cadena.size() - 1; i >= 0; i--) {
            if(caracter == cadena.get(i)) {
                cadena.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String concatenacion = "";

        for (Character caracter : this.cadena) {
            concatenacion += caracter;
        }

        return concatenacion;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            throw new IllegalArgumentException("El objeto no puede ser null");
        }

        String comparar;

        if (obj instanceof Cadena) {
            comparar = obj.toString();
        } else if (obj instanceof String) {
            comparar = (String) obj;
        } else if (obj instanceof char[]) {

            char[] vector = (char[]) obj;
            comparar = "";

            for (int i = 0; i < vector.length; i++) {
                comparar += vector[i];
            }
        } else {
            throw new IllegalArgumentException("Este objeto no es compatible");
        }

        if (comparar.length() != cadena.size()) {
            return false;
        }

        for (int i = 0; i < comparar.length(); i++) {
            if (comparar.charAt(i) != cadena.get(i)) {
                return false;
            }
        }

        return true;
    }
}