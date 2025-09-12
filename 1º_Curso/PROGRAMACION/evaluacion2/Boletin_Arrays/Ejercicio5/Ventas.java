package PROGRAMACION.evaluacion2.Boletin_Arrays.Ejercicio5;

import java.time.LocalDate;

public class Ventas {
    public int[] month = new int[12];
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        LocalDate fechaActual = LocalDate.now();
        int añoActual = fechaActual.getYear();

        if (year < añoActual) {
            this.year = year;
        } else {
            this.year = añoActual;
        }
    }

    public Ventas(int year) {
        this.setYear(year);
        for (int i = 0; i < this.month.length; i++) {
            this.month[i] = (int) (Math.random() * 999) + 1;
        }
    }

    public Ventas(int year, int[] month) {
        this.setYear(year);
        if (month.length == 12) {
            this.month = month;
        } else {
            for (int i = 0; i < this.month.length; i++) {
                this.month[i] = (int) (Math.random() * 999) + 1;
            }
        }
    }

    public int media(int[] month) {
        this.month = month;
        int sum = 0;
        for (int i = 0; i < month.length; i++) {
            sum += month[i];
        }
        return sum / month.length;
    }

    public void grafico(int[] month) {
        this.month = month;

        int index = 0;
        System.out.println("Año " + getYear() + ": ");
        for (int i = 0; i < month.length; i++) {
            index++;
            System.out.printf("Mes %2s (%3s): ", index, month[i]);

            for (int j = 100; j <= month[i]; j += 100) {
                System.out.print("#");
            }

            System.out.println();
        }
    }
}
