package dev;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser15 extends DefaultHandler {

    boolean triggerTitulo = false;
    boolean triggerNombreCompleto = false;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("INICIO DOCUMENTO");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("FIN DOCUMENTO");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("pelicula")) {
            System.out.printf("%s: %s\n", attributes.getQName(1), attributes.getValue(1));
        } else if (qName.equals("titulo")) {
            triggerTitulo = true;
            System.out.print(qName + ": ");
        } else if (qName.equals("nombre") || qName.equals("apellido")) {
            triggerNombreCompleto = true;
            System.out.print(qName + ": ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("titulo")) {
            triggerTitulo = false;
            System.out.println();
        } else if (qName.equals("nombre") || qName.equals("apellido")) {
            triggerNombreCompleto = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String data = new String(ch, start, length);

        if (triggerTitulo || triggerNombreCompleto) {
            System.out.println(data);
        }
    }
}
