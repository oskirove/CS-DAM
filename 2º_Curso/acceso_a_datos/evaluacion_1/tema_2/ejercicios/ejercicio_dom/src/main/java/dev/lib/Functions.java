package dev.lib;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Functions {

    private String COLOR_ERROR = "\033[31m";
    private String COLOR_CIERRE = "\033[0m";
    private String ruta = "/home/oscar/CS-DAM/2º_Curso/acceso_a_datos/evaluacion_1/tema_2/ejercicios/dom.xml";

    public Document crearDOM() {
        Document doc = null;

        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            factoria.setIgnoringComments(true);
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.parse(ruta);
        } catch (Exception e) {
            System.out.println(COLOR_ERROR + "Error al generar el arbol DOM" + COLOR_CIERRE);
            e.printStackTrace();
        }

        return doc;
    }

    public void mostrarTitulosPeliculas() {

        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(COLOR_ERROR + "No se puede mostrar los títulos porque el DOM no existe." + COLOR_CIERRE);
            return;
        }

        NodeList listaTitulos = doc.getElementsByTagName("titulo");

        for (int i = 0; i < listaTitulos.getLength(); i++) {
            Node nodoTitulo = listaTitulos.item(i);

            String titulo = nodoTitulo.getTextContent();

            System.out.println(titulo);
        }
    }

    public void mostrarInfoPeliculas() {

        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(
                    COLOR_ERROR + "No se puede mostrar la información porque el DOM no existe." + COLOR_CIERRE);
            return;
        }

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < listaPeliculas.getLength(); i++) {
            Node nodoPelicula = listaPeliculas.item(i);

            if (nodoPelicula.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoPelicula = (Element) nodoPelicula;

                String titulo = elementoPelicula.getElementsByTagName("titulo").item(0).getTextContent();

                System.out.println("Pelicula: " + titulo);

                NodeList listaDirectores = elementoPelicula.getElementsByTagName("director");

                for (int j = 0; j < listaDirectores.getLength(); j++) {
                    Node nodoDirector = listaDirectores.item(j);

                    String nombreDirector = nodoDirector.getTextContent().trim().replace("\n", " ").replaceAll(" +",
                            " ");

                    System.out.println(" - Director: " + nombreDirector);
                }

                System.out.println();
            }
        }
    }

    public void mostrarNDirectores(int cantidadDirectores) {
        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(
                    COLOR_ERROR + "No se puede mostrar porque el DOM no existe." + COLOR_CIERRE);
            return;
        }

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < listaPeliculas.getLength(); i++) {
            Node nodoPeliculas = listaPeliculas.item(i);

            
        }
    }
}
