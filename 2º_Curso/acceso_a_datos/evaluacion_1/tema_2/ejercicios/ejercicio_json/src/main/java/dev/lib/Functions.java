package dev.lib;

import java.net.URISyntaxException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.json.JsonArray;
import javax.json.JsonNumber;
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

        JsonObject jsonObject = (JsonObject) json;

        JsonArray listArray = jsonObject.getJsonArray("list");

        for (int i = 0; i < ciudades; i++) {
            JsonObject forecasts = listArray.getJsonObject(i);

            JsonArray weatherArray = forecasts.getJsonArray("weather");

            JsonObject weatherDetails = weatherArray.getJsonObject(0);

            String forecast = weatherDetails.getString("main");

            System.out.println(forecast);
        }
    }

    public void getCityID(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=" + API_KEY;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        int ID = jsonObject.getInt("id");

        System.out.println(ID);
    }

    public void getCityName(double lat, double lon) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%.5f&lon=%.5f&appid=%s", lat,
                lon, API_KEY);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        String nombre = jsonObject.getString("name");

        System.out.println(nombre);
    }

    public void getCityCo(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=" + API_KEY;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonObject coordenadas = jsonObject.getJsonObject("coord");
        JsonNumber lat = coordenadas.getJsonNumber("lat");
        JsonNumber lon = coordenadas.getJsonNumber("lon");

        System.out.printf("Coordenadas de %s\nlat: %.5f, lon: %.5f", ciudad, lat.doubleValue(), lon.doubleValue());
    }

    public void pronosticoCompleto(String ciudad) throws URISyntaxException {
        String URL = "https://api.openweathermap.org/data/2.5/forecast?q=" + ciudad + "&appid=" + API_KEY;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonArray listArray = jsonObject.getJsonArray("list");

        for (int i = 0; i < listArray.size(); i += 8) {

            JsonObject objectDate = listArray.getJsonObject(i);

            long date = objectDate.getJsonNumber("dt").longValue();

            // jsonObject objectMain = 

            // String fechaFormateada = unixTimeToString(date);

            // System.out.println(fechaFormateada);
        }
    }

    public String unixTimeToString(long unixTime) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT+1")).format(formatter);
    }
}