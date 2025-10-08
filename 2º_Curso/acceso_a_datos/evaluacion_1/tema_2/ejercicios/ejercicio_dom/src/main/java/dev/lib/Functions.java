package dev.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

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
            Node nodoPelicula = listaPeliculas.item(i);

            if (nodoPelicula.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoPelicula = (Element) nodoPelicula;
                NodeList listaDirectores = elementoPelicula.getElementsByTagName("director");

                if (listaDirectores.getLength() == cantidadDirectores) {
                    String pelicula = elementoPelicula.getElementsByTagName("titulo").item(0).getTextContent();
                    System.out.println(pelicula);
                }
            }
        }
    }

    public void modificarDOM(String tit, String dir, String gen) {
        Document doc = crearDOM();

        try {
            Element nodoPelicula = doc.createElement("pelicula");
            nodoPelicula.setAttribute("genero", gen);

            Element nodoTitulo = doc.createElement("titulo");
            Text textTitulo = doc.createTextNode(tit);
            nodoTitulo.appendChild(textTitulo);
            nodoPelicula.appendChild(nodoTitulo);

            Element nodoDirector = doc.createElement("director");
            Text textDirector = doc.createTextNode(dir);
            nodoDirector.appendChild(textDirector);
            nodoPelicula.appendChild(nodoDirector);

            Node nodoPeliculas = doc.getFirstChild();
            nodoPeliculas.appendChild(nodoPelicula);

            grabarDOM(doc, ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grabarDOM(Document document, String ficheroSalida)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, FileNotFoundException {
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS ls = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
        // Se crea un destino vacio
        LSOutput output = ls.createLSOutput();
        output.setEncoding("UTF-8");
        // Se establece el flujo de salida
        output.setByteStream(new FileOutputStream(ficheroSalida));
        // output.setByteStream(System.out);
        // Permite escribir un documento DOM en XML
        LSSerializer serializer = ls.createLSSerializer();
        // Se establecen las propiedades del serializador
        serializer.setNewLine("\r\n");

        serializer.getDomConfig().setParameter("format-pretty-print", true);
        // Se escribe el documento ya sea en un fichero o en una cadena de texto
        serializer.write(document, output);
        // String xmlCad=serializer.writeToString(document);
    }
}
