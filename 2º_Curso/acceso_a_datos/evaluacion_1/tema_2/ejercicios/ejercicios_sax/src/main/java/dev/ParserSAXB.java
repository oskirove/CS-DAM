package dev;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserSAXB extends DefaultHandler {

    String label = "";
    
    private String nombreDirector = "";
    private String apellidoDirector = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("--- COMIENZO DEL DOCUMENTO XML ---");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("--- FIN DEL DOCUMENTO XML ---");
    }

    @Override
    public void startElement(String uri, String localName, String label,
            Attributes attributes) throws SAXException {

        this.label = label;

        if (label.equals("pelicula")) {
            nombreDirector = "";
            apellidoDirector = "";
            System.out.println("\n====================================");
            
            String año = attributes.getValue("año");
            String genero = attributes.getValue("genero");
            
            if (año != null) System.out.println("Año: " + año);
            if (genero != null) System.out.println("Género: " + genero);
        }
    }

    @Override
    public void endElement(String uri, String localName, String label)
            throws SAXException {

        if (label.equals("director")) {
            System.out.printf("Director: %s %s%n", nombreDirector, apellidoDirector);
            nombreDirector = "";
            apellidoDirector = "";
        }

        if (label.equals("pelicula")) {
            System.out.println("====================================");
        }
        
        this.label = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String cad = new String(ch, start, length).trim();
        
        if (cad.length() == 0) return;

        if (this.label.equals("titulo")) {
            System.out.println("Título: " + cad);

        } else if (this.label.equals("nombre")) {
            this.nombreDirector = cad;

        } else if (this.label.equals("apellido")) {
            this.apellidoDirector = cad;
        }

    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Aviso: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Error fatal: " + e.getMessage());
    }
}