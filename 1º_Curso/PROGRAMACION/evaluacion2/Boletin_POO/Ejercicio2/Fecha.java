package PROGRAMACION.evaluacion2.Boletin_POO.Ejercicio2;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.año = 2020;
    }

    public Fecha(int dia, int mes, int año) {
        this.dia = (dia >= 1 && dia <= 31) ? dia : 1;
        this.mes = (mes >= 1 && mes <= 12) ? mes : 1;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = (dia >= 1 && dia <= 31) ? dia : 1;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = (mes >= 1 && mes <= 12) ? mes : 1;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String fechaFormateada(boolean trigger) {
        if (trigger == true) {
            return getDia() + "/" + getMes() + "/" + getAño();
        } else {
            switch (mes) {
                case 1:
                    return getDia() + " de Enero de " + getAño();
                case 2:
                    return getDia() + " de Febrero de " + getAño();
                case 3:
                    return getDia() + " de Marzo de " + getAño();
                case 4:
                    return getDia() + " de Abril de " + getAño();
                case 5:
                    return getDia() + " de Mayo de " + getAño();
                case 6:
                    return getDia() + " de Junio de " + getAño();
                case 7:
                    return getDia() + " de Julio de " + getAño();
                case 8:
                    return getDia() + " de Agosto de " + getAño();
                case 9:
                    return getDia() + " de Septiembre de " + getAño();
                case 10:
                    return getDia() + " de Octubre de " + getAño();
                case 11:
                    return getDia() + " de Noviembre de " + getAño();
                case 12:
                    return getDia() + " de Octubre de " + getAño();
                default:
                    break;
            }
            return "";
        }
    }

    public static int diferenciaFechas(Fecha fecha1, Fecha fecha2) {
        int dif = fecha2.getAño() - fecha1.getAño();//abs
        return dif;
    }
}