package dev.lib;

import java.net.URISyntaxException;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Functions {

    private static final String API_KEY = System.getenv("API_KEY");

    public static void initializeApiKey() {

        if (API_KEY == null || API_KEY.isEmpty()) {
            System.err.println(
                    "ERROR: La variable de entorno " + API_KEY + " no está definida en tu terminal. Usa 'export "
                            + API_KEY + "=\"...\"'.");
            System.exit(1);
        }

        System.out.println("Clave API cargada con exito.");

        System.out.println("Clave (fragmento): " + API_KEY.substring(0, Math.min(API_KEY.length(), 8)) + "...");
        System.out.println();
    }

    public void getTiempoCiudad(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=" + API_KEY;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        if (json.getValueType() != JsonValue.ValueType.OBJECT) {
            throw new IllegalStateException("Se esperaba un objeto JSON (JsonObject) en la respuesta.");
        }

        JsonObject jsonObject = (JsonObject) json;

        JsonArray weatherArray = jsonObject.getJsonArray("weather");

        JsonObject weatherItem = weatherArray.getJsonObject(0);

        String mainweather = weatherItem.getString("main");

        System.out.println(mainweather);
    }

    public void getTiempoCoords(double lat, double lon) throws URISyntaxException {


        // "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY;
        String URL = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%.5f&lon=%.5f&appid=%s",lat, lon, API_KEY);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        if (json.getValueType() != JsonValue.ValueType.OBJECT) {
            throw new IllegalStateException("Se esperaba un objeto JSON (JsonObject) en la respuesta.");
        }

        JsonObject jsonObject = (JsonObject) json;

        JsonArray weatherArray = jsonObject.getJsonArray("weather");

        JsonObject weatherItem = weatherArray.getJsonObject(0);

        System.out.println(json.toString());

    }
}
