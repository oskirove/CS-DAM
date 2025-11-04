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

        JsonObject jsonObject = (JsonObject) json;

        JsonArray weatherArray = jsonObject.getJsonArray("weather");

        JsonObject weatherItem = weatherArray.getJsonObject(0);

        String mainweather = weatherItem.getString("main");

        System.out.println(mainweather);
    }

    public void getTiempoCoords(double lat, double lon) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%.5f&lon=%.5f&appid=%s", lat,
                lon, API_KEY);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonArray listArray = jsonObject.getJsonArray("list");

        JsonObject firstForecast = listArray.getJsonObject(0);

        JsonArray weatherArray = firstForecast.getJsonArray("weather");

        JsonObject weatherDetails = weatherArray.getJsonObject(0);

        String description = weatherDetails.getString("description");
        String mainWeather = weatherDetails.getString("main");

        System.out.println("Predicción: " + mainWeather);
        System.out.println("Descripción: " + description);
    }

    public void getTiempoCiudades(double lat, double lon, int ciudades) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/find?lat=%.5f&lon=%.5f&cnt=%s&appid=%s",
                lat, lon, ciudades, API_KEY);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        System.out.println(json);
    }
}