package dev;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Application {
  public static void main(String[] args) {

    String nombreArchivo = "dom.xml";

    File archivoXML = new File(nombreArchivo);
    if (!archivoXML.exists()) {
      System.err.println("Error: El archivo " + nombreArchivo + " no se encuentra.");
      return;
    }

    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();

      SAXParser saxParser = factory.newSAXParser();

      ParserSAXB handler = new ParserSAXB();

      System.out.println("Iniciando análisis del archivo: " + nombreArchivo);

      saxParser.parse(archivoXML, handler);

    } catch (ParserConfigurationException e) {
      System.err.println("Error de configuración del analizador: " + e.getMessage());
    } catch (SAXException e) {
      System.err.println("Error de SAX durante el análisis: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Error de I/O al leer el archivo: " + e.getMessage());
    }
  }
}
