package dev.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

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

    private String COLOR_ERROR = "\033[1;31m";
    private String CIERRE = "\033[0m";
    private String ruta = "/home/oscar/CS-DAM/2º_Curso/acceso_a_datos/evaluacion_1/tema_2/ejercicios/dom.xml";

    // Ejercicio 1
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

    // Ejercicio 2
    public void mostrarTitulosPeliculas() {

        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(COLOR_ERROR + "No se puede mostrar los títulos porque el DOM no existe." + CIERRE);
            return;
        }

        NodeList listaTitulos = doc.getElementsByTagName("titulo");

        for (int i = 0; i < listaTitulos.getLength(); i++) {
            Node nodoTitulo = listaTitulos.item(i);

            String titulo = nodoTitulo.getTextContent();

            System.out.println(titulo);
        }
    }

    // Ejercicio 3
    public void mostrarInfoPeliculas() {

        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(
                    COLOR_ERROR + "No se puede mostrar la información porque el DOM no existe." + CIERRE);
            return;
        }

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < listaPeliculas.getLength(); i++) {
            Node nodoPelicula = listaPeliculas.item(i);

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

    // Ejercicio 5
    public void mostrarNDirectores(int cantidadDirectores) {
        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(
                    COLOR_ERROR + "No se puede mostrar porque el DOM no existe." + CIERRE);
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

    // Ejercicio 6
    public void mostrarGéneros() {
        Document doc = crearDOM();

        if (doc == null) {
            System.out.println(
                    COLOR_ERROR + "No se pueden mostrar porque el DOM no existe." + CIERRE);
            return;
        }

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");
        ArrayList<String> generos = new ArrayList<>();

        for (int i = 0; i < listaPeliculas.getLength(); i++) {

            Element elementoPelicula = (Element) listaPeliculas.item(i);

            String genero = elementoPelicula.getAttribute("genero");

            if (!generos.contains(genero)) {
                generos.add(genero);
            }
        }

        System.out.println("Géneros: " + generos.size());

        for (String g : generos) {
            System.out.println(" - " + g);
        }
    }

    // Ejercicio 7

    public void añadirAtributo(String pelicula, String atributo, String valor) {
        Document doc = crearDOM();

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < listaPeliculas.getLength(); i++) {

            Node nodoPelicula = listaPeliculas.item(i);
            Element elementoPelicula = (Element) nodoPelicula;

            String titulo = elementoPelicula.getElementsByTagName("titulo").item(0).getTextContent();

            if (titulo.equals(pelicula)) {

                try {
                    if (!elementoPelicula.hasAttribute(atributo)) {
                        elementoPelicula.setAttribute(atributo, valor);
                        grabarDOM(doc, ruta);
                    } else {
                        System.out.println(
                                COLOR_ERROR + "La pelicula " + pelicula.toUpperCase() + " ya contiene el atributo "
                                        + atributo.toUpperCase() + CIERRE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void eliminarAtributo(String pelicula, String atributo) {
        Document doc = crearDOM();

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

        for (int i = 0; i < listaPeliculas.getLength(); i++) {
            Node nodoPelicula = listaPeliculas.item(i);
            Element elementoPelicula = (Element) nodoPelicula;

            String titulo = elementoPelicula.getElementsByTagName("titulo").item(0).getTextContent();

            if (titulo.equals(pelicula)) {
                try {
                    if (elementoPelicula.hasAttribute(atributo)) {
                        elementoPelicula.removeAttribute(atributo);
                        grabarDOM(doc, ruta);
                    } else {
                        System.out.println(COLOR_ERROR + "La pelicula " + pelicula.toUpperCase()
                                + " no contiene el atributo " + atributo.toUpperCase() + "." + CIERRE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Ejercicio 8
    public void añadirPeliDOM(String title, String nameDir, String apellDir, String gen, String año) {
        Document doc = crearDOM();

        try {
            Element nodoPelicula = doc.createElement("pelicula");
            nodoPelicula.setAttribute("genero", gen);
            nodoPelicula.setAttribute("año", año);

            Element nodoTitulo = doc.createElement("titulo");
            Text textTitulo = doc.createTextNode(title);
            nodoTitulo.appendChild(textTitulo);
            nodoPelicula.appendChild(nodoTitulo);

            Element nodoDirector = doc.createElement("director");
            Element nodoNombre = doc.createElement("nombre");
            Element nodoApellido = doc.createElement("apellido");

            Text textNameDirector = doc.createTextNode(nameDir);
            Text textApellDirector = doc.createTextNode(apellDir);

            nodoPelicula.appendChild(nodoDirector);

            nodoDirector.appendChild(nodoNombre);
            nodoDirector.appendChild(nodoApellido);

            nodoNombre.appendChild(textNameDirector);
            nodoApellido.appendChild(textApellDirector);

            Node nodoPeliculas = doc.getFirstChild();
            nodoPeliculas.appendChild(nodoPelicula);

            grabarDOM(doc, ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ejercicio 9
    public void modificarNombreDirector(String nombreDirector, String nombreModificado) {
        Document doc = crearDOM();

        NodeList listaNombres = doc.getElementsByTagName("nombre");

        for (int i = 0; i < listaNombres.getLength(); i++) {
            Node nodoNombre = listaNombres.item(i);
            Element elementoNombre = (Element) nodoNombre;

            String nombre = elementoNombre.getTextContent();

            if (nombre.equals(nombreDirector)) {
                try {
                    elementoNombre.setTextContent(nombreModificado);
                    grabarDOM(doc, ruta);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Ejercicio 10
    public void añadirDirector(String pelicula, String nombre, String apellido) {
        Document doc = crearDOM();

        NodeList listaPeliculas = doc.getElementsByTagName("pelicula");

        for (int j = 0; j < listaPeliculas.getLength(); j++) {
            Node nodoPelicula = listaPeliculas.item(j);
            Element elementoPelicula = (Element) nodoPelicula;
            String titulo = elementoPelicula.getElementsByTagName("titulo").item(0).getTextContent();

            if (titulo.equals(pelicula)) {
                try {

                    Element nuevoNodoDirector = doc.createElement("director");
                    Element nodoNombre = doc.createElement("nombre");
                    Element nodoApellido = doc.createElement("apellido");

                    Text textNameDirector = doc.createTextNode(nombre);
                    Text textApellDirector = doc.createTextNode(apellido);

                    nuevoNodoDirector.appendChild(nodoNombre);
                    nuevoNodoDirector.appendChild(nodoApellido);

                    nodoNombre.appendChild(textNameDirector);
                    nodoApellido.appendChild(textApellDirector);

                    nodoPelicula.appendChild(nuevoNodoDirector);
                    grabarDOM(doc, ruta);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //Ejercicio 11
    public void eliminarPeliculas(String titulo) {

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
