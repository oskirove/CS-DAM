package dev;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser17 extends DefaultHandler {

    ArrayList<String> generos = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("Inicio documento");
    }

    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("pelicula")) {

            String genero = attributes.getValue("genero");

            if (!generos.contains(genero)) {
                generos.add(genero);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        
    }
    
    
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        System.out.printf("Hay %s generos diferentes: \n", generos.size());

        for (String genero : generos) {
            System.out.println(genero);
        }
    }
}