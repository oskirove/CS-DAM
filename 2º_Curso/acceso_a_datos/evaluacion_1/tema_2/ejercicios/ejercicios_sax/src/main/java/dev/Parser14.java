package dev;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parser14 extends DefaultHandler {

    private int indent = 0;

    private void printIndent() {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("Inicio documento");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Fin documento");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        printIndent();
        System.out.print("<" + qName);

        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getQName(i) + "=\""
                    + attributes.getValue(i) + "\"");
        }

        System.out.println(">");

        indent++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        indent--;
        printIndent();
        System.out.println("</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String texto = new String(ch, start, length).trim();

        if (!texto.isEmpty()) {
            printIndent();
            System.out.println(texto);
        }
    }
}