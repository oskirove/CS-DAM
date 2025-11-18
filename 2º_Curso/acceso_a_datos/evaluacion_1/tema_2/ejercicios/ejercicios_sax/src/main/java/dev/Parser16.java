package dev;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser16 extends DefaultHandler {

    private int minDirectores;
    private int contadorDirectores = 0;
    private String tituloActual = "";
    private boolean leyendoTitulo = false;

    public Parser16(int n) {
        this.minDirectores = n;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("pelicula")) {
            contadorDirectores = 0;
            tituloActual = "";
        } else if (qName.equals("director")) {
            contadorDirectores++;
        } else if (qName.equals("titulo")) {
            leyendoTitulo = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (leyendoTitulo) {
            tituloActual += new String(ch, start, length).trim();
        }
    }

    @Override
    public void endElement(String uri, String local, String qName) {
        if (qName.equals("titulo")) {
            leyendoTitulo = false;
        } else if (qName.equals("pelicula")) {

            if (contadorDirectores >= minDirectores) {
                System.out.println("Pelicula: " + tituloActual + 
                                   " (Directores: " + contadorDirectores + ")");
            }
        }
    }
}