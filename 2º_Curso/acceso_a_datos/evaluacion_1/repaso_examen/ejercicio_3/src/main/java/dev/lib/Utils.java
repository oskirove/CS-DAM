package dev.lib;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Utils {
    private String COLOR_ERROR = "\033[1;31m";
    private String CIERRE = "\033[0m";
    private String ruta = "liga.xml";

    public Document crearDOM() {
        Document doc = null;

        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            factoria.setIgnoringComments(true);
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.parse(ruta);
        } catch (Exception e) {
            System.out.println(COLOR_ERROR + "Error al generar el arbol DOM" + CIERRE);
            e.printStackTrace();
        }

        return doc;
    }

    public String getTemporada() {
        Document doc = crearDOM();

        String temporada = doc.getElementsByTagName("temporada").item(0).getTextContent();
        return temporada;
    }

    public int getNumPartidos() {
        int contador = 0;
        Document doc = crearDOM();

        NodeList listaPartidos = doc.getElementsByTagName("evento");

        for (int i = 0; i < listaPartidos.getLength(); i++) {
            contador++;
        }

        return contador;
    }

    public void getNombreEquiposFechas() {
        Document doc = crearDOM();

        NodeList listaPartidos = doc.getElementsByTagName("evento");

        for (int i = 0; i < listaPartidos.getLength(); i++) {
            Node nodoPartido = listaPartidos.item(i);

            Element elementoPartido = (Element) nodoPartido;

            String fecha = elementoPartido.getElementsByTagName("fecha").item(0).getTextContent();
            String local = elementoPartido.getElementsByTagName("equipolocal").item(0).getTextContent();
            String visitante = elementoPartido.getElementsByTagName("equipovisitante").item(0).getTextContent();

            System.out.println("Fecha: " + fecha);
            System.out.println();
            System.out.println("Visitantes: " + visitante);
            System.out.println("Local: " + local);
            System.out.println("===========================");
        }
    }

    public void mostrarEquipoMaxGoles(int maxGoles) {
        Document doc = crearDOM();

        NodeList listaPartidos = doc.getElementsByTagName("evento");

        for (int i = 0; i < listaPartidos.getLength(); i++) {
            Node nodoPartido = listaPartidos.item(i);

            Element elementoPartido = (Element) nodoPartido;

            String cadenaGolesLocal = elementoPartido.getElementsByTagName("resultadolocal").item(0)
                    .getTextContent();

            String cadenaGolesVisitante = elementoPartido.getElementsByTagName("resultadovisitante").item(0)
                    .getTextContent();

            String equipoLocal = elementoPartido.getElementsByTagName("equipolocal").item(0).getTextContent();
            String equipoVisitante = elementoPartido.getElementsByTagName("equipovisitante").item(0).getTextContent();

            int golesLocal = Integer.parseInt(cadenaGolesLocal);
            int golesVisitante = Integer.parseInt(cadenaGolesVisitante);

            if (golesLocal == maxGoles) {
                System.out.println(" - " + equipoLocal + ": " + maxGoles);
            } else if (golesVisitante == maxGoles) {
                System.out.println(" - " + equipoVisitante + ": " + maxGoles);
            }
        }
    }

    public int getMaxGoles() {

        int maxGoles = 0;
        ArrayList<Integer> goles = new ArrayList<>();

        Document doc = crearDOM();

        NodeList listaPartidos = doc.getElementsByTagName("evento");

        for (int i = 0; i < listaPartidos.getLength(); i++) {
            Node nodoPartido = listaPartidos.item(i);

            Element elementoPartido = (Element) nodoPartido;

            String cadenaGolesLocal = elementoPartido.getElementsByTagName("resultadolocal").item(0)
                    .getTextContent();

            String cadenaGolesVisitante = elementoPartido.getElementsByTagName("resultadovisitante").item(0)
                    .getTextContent();

            int golesLocal = Integer.parseInt(cadenaGolesLocal);
            int golesVisitante = Integer.parseInt(cadenaGolesVisitante);

            goles.add(golesLocal);
            goles.add(golesVisitante);
        }

        for (int gol : goles) {
            if (gol > maxGoles) {
                maxGoles = gol;
            }
        }

        return maxGoles;
    }


}
