package dev;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Application {
  public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

    String rutaArchivo = "/home/oscar/CS-DAM/2º_Curso/acceso_a_datos/evaluacion_1/tema_2/ejercicios/dom.xml";

    // getSax14(rutaArchivo);
    // getSax15(rutaArchivo);
    getSax16(rutaArchivo);
    // getSax17(rutaArchivo);

  }

  public static void getSax(String entradaXML) throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    Parser14 parserSax = new Parser14();
    parser.parse(entradaXML, parserSax);
  }

  public static void getSax15(String entradaXML) throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    Parser15 parserSax = new Parser15();
    parser.parse(entradaXML, parserSax);
  }

  public static void getSax16(String entradaXML) throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    Parser16 parserSax = new Parser16(2);
    parser.parse(entradaXML, parserSax);
  }

  public static void getSax17(String entradaXML) throws ParserConfigurationException, SAXException, IOException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();
    Parser17 parserSax = new Parser17();
    parser.parse(entradaXML, parserSax);
  }
}
