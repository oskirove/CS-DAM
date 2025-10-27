package dev.lib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.net.ssl.HttpsURLConnection;

public class JsonUtils {

    public JsonValue leeJSON(String ruta) throws URISyntaxException {
        try {
            if (ruta.toLowerCase().startsWith("http://")) {
                return leerHttp(ruta);
            } else if (ruta.toLowerCase().startsWith("https://")) {
                return leerHttps(ruta);
            } else {
                return leerFichero(ruta);
            }
        } catch (IOException e) {
            System.out.println("Error procesando documento Json " +
                    e.getLocalizedMessage());
            return null;
        }
    }

    public JsonValue leerFichero(String ruta) throws FileNotFoundException {
        try (JsonReader reader = Json.createReader(new FileReader(ruta))) {
            return reader.read();
            /*
             * JsonStructure jsonSt = reader.read();
             * System.out.println(jsonSt.getValueType());
             * JsonObject jsonObj = reader.readObject();
             * System.out.println(jsonObj.getValueType());
             * JsonArray jsonArr = reader.readArray();
             * System.out.println(jsonArr.getValueType());
             */
        }
    }

    public JsonValue leerHttp(String direccion) throws IOException, URISyntaxException {
        URL url = new URI(direccion).toURL();
        try (InputStream is = url.openStream();
                JsonReader reader = Json.createReader(is)) {
            return reader.read();
        }
    }

    public JsonValue leerHttps(String direccion) throws IOException, URISyntaxException {
        URL url = new URI(direccion).toURL();
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        try (InputStream is = conn.getInputStream();
                JsonReader reader = Json.createReader(is)) {
            return reader.read();
        } finally {
            conn.disconnect();
        }
    }
}
