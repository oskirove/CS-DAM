package dev.lib;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Functions {

    // Ejercicios con Open Weather Map
    private static final String API_KEY_OPEN_WEATHER_MAP = System.getenv("API_KEY_OPEN_WEATHER_MAP");

    public static void initializeApiKey() {

        if (API_KEY_OPEN_WEATHER_MAP == null || API_KEY_OPEN_WEATHER_MAP.isEmpty()) {
            System.err.println(
                    "ERROR: La variable de entorno " + API_KEY_OPEN_WEATHER_MAP
                            + " no está definida en tu terminal. Usa 'export "
                            + API_KEY_OPEN_WEATHER_MAP + "=\"...\"'.");
            System.exit(1);
        }

        System.out.println("Clave API cargada con exito.");

        System.out.println("Clave (fragmento): "
                + API_KEY_OPEN_WEATHER_MAP.substring(0, Math.min(API_KEY_OPEN_WEATHER_MAP.length(), 8)) + "...");
        System.out.println();
    }

    // Ejercicio 1

    public void getTiempoCiudad(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid="
                + API_KEY_OPEN_WEATHER_MAP;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonArray weatherArray = jsonObject.getJsonArray("weather");

        JsonObject weatherItem = weatherArray.getJsonObject(0);

        String mainweather = weatherItem.getString("main");

        System.out.println(mainweather);
    }

    // Ejercicio 2

    public void getTiempoCoords(double lat, double lon) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%.5f&lon=%.5f&appid=%s", lat,
                lon, API_KEY_OPEN_WEATHER_MAP);

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

    // Ejercicio 3

    public void getTiempoCiudades(double lat, double lon, int ciudades) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/find?lat=%.5f&lon=%.5f&cnt=%s&appid=%s",
                lat, lon, ciudades, API_KEY_OPEN_WEATHER_MAP);

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

    // Ejercicio 4

    public void getCityID(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid="
                + API_KEY_OPEN_WEATHER_MAP;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        int ID = jsonObject.getInt("id");

        System.out.println(ID);
    }

    // Ejercicio 5

    public void getCityName(double lat, double lon) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%.5f&lon=%.5f&appid=%s", lat,
                lon, API_KEY_OPEN_WEATHER_MAP);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        String nombre = jsonObject.getString("name");

        System.out.println(nombre);
    }

    // Ejercicio 6

    public void getCityCo(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid="
                + API_KEY_OPEN_WEATHER_MAP;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonObject coordenadas = jsonObject.getJsonObject("coord");
        JsonNumber lat = coordenadas.getJsonNumber("lat");
        JsonNumber lon = coordenadas.getJsonNumber("lon");

        System.out.printf("Coordenadas de %s\nlat: %.5f, lon: %.5f", ciudad, lat.doubleValue(), lon.doubleValue());
    }

    // Ejercicio 7

    public void pronosticoCompleto(String ciudad) throws URISyntaxException {

        // Apartado para el ejercicio 11, evitamos espacios en blanco en la url para las ciudades
        // ----------------------------------------------------------------------------
        String encodedCiudad = null;
        try {
            encodedCiudad = URLEncoder.encode(ciudad, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // ----------------------------------------------------------------------------

        String URL = "https://api.openweathermap.org/data/2.5/forecast?q=" + encodedCiudad + "&appid="
                + API_KEY_OPEN_WEATHER_MAP;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonArray listArray = jsonObject.getJsonArray("list");

        for (int i = 0; i < listArray.size(); i += 8) {

            JsonObject objecList = listArray.getJsonObject(i);

            // Fecha
            long date = objecList.getJsonNumber("dt").longValue();
            String fechaFormateada = unixTimeToString(date);

            // Temperatura
            JsonObject mainObject = objecList.getJsonObject("main");
            double temperatura = mainObject.getJsonNumber("temp").doubleValue();

            // Humedad
            int humedad = mainObject.getInt("humidity");

            // Posibilidad de cielo con nubes
            JsonObject cloudsObject = objecList.getJsonObject("clouds");
            int probabilidadNubes = cloudsObject.getInt("all");

            // Viento
            JsonObject windObject = objecList.getJsonObject("wind");
            Double velocidadViento = windObject.getJsonNumber("speed").doubleValue();

            // Tiempo
            JsonArray weatherList = objecList.getJsonArray("weather");
            JsonObject objectWeather = weatherList.getJsonObject(0);
            String tiempo = objectWeather.getString("main");
            String detalles = objectWeather.getString("description");

            System.out.println(fechaFormateada);
            System.out.printf(
                    " - Temperatura: %.2f ºC\n - Humedad: %s\n - Nublado: %s %%\n - Viento: %.2f km/h\n - Tiempo: %s\n - Detalles: %s\n",
                    temperatura - 273.15,
                    humedad,
                    probabilidadNubes,
                    velocidadViento,
                    tiempo,
                    detalles);

            System.out.println();
        }
    }

    // Ejercicio 8

    public void pronosticoCompletoCiudades(double lat, double lon, int ciudades) throws URISyntaxException {

        String URL = String.format("https://api.openweathermap.org/data/2.5/find?lat=%.5f&lon=%.5f&cnt=%s&appid=%s",
                lat, lon, ciudades, API_KEY_OPEN_WEATHER_MAP);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonArray listArray = jsonObject.getJsonArray("list");

        for (int i = 0; i < listArray.size(); i++) {

            JsonObject objecList = listArray.getJsonObject(i);

            String ciudad = objecList.getString("name");

            // Fecha
            long date = objecList.getJsonNumber("dt").longValue();
            String fechaFormateada = unixTimeToString(date);

            // Temperatura
            JsonObject mainObject = objecList.getJsonObject("main");
            double temperatura = mainObject.getJsonNumber("temp").doubleValue();

            // Humedad
            int humedad = mainObject.getInt("humidity");

            // Posibilidad de cielo con nubes
            JsonObject cloudsObject = objecList.getJsonObject("clouds");
            int probabilidadNubes = cloudsObject.getInt("all");

            // Viento
            JsonObject windObject = objecList.getJsonObject("wind");
            Double velocidadViento = windObject.getJsonNumber("speed").doubleValue();

            // Tiempo
            JsonArray weatherList = objecList.getJsonArray("weather");
            JsonObject objectWeather = weatherList.getJsonObject(0);
            String tiempo = objectWeather.getString("main");
            String detalles = objectWeather.getString("description");

            System.out.println(ciudad + ": " + fechaFormateada);
            System.out.printf(
                    " - Temperatura: %.2f ºC\n - Humedad: %s\n - Nublado: %s %%\n - Viento: %.2f km/h\n - Tiempo: %s\n - Detalles: %s\n",
                    temperatura - 273.15,
                    humedad,
                    probabilidadNubes,
                    velocidadViento,
                    tiempo,
                    detalles);

            System.out.println();
        }
    }

    public String unixTimeToString(long unixTime) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT+1")).format(formatter);
    }

    // Ejercicios con Open Trivia Database

    private static final String URLOpenTrivia = "https://opentdb.com/api.php?amount=10&category=18&difficulty=hard";

    // Ejercicio 9
    public void mostrarPreguntas() throws URISyntaxException {

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URLOpenTrivia);

        JsonObject jsonObject = (JsonObject) json;

        JsonArray arrayResults = jsonObject.getJsonArray("results");

        for (int i = 0; i < arrayResults.size(); i++) {
            JsonObject objetoResults = arrayResults.getJsonObject(i);
            String pregunta = objetoResults.getString("question");
            String preguntaCorrecta = objetoResults.getString("correct_answer");

            JsonArray arrayIncorrectAnswers = objetoResults.getJsonArray("incorrect_answers");

            System.out.println("\033[1;44m Pregunta " + (i + 1) + "\033[0m");
            System.out.println("\033[1;34m" + pregunta + "\033[0m");
            System.out.println();
            System.out.println("1.- \033[1;32m" + preguntaCorrecta + "\033[0m");

            for (int index = 0; index < arrayIncorrectAnswers.size(); index++) {
                String incorrectAnswers = arrayIncorrectAnswers.getString(index);
                System.out.println((index + 2) + ".- \033[1;31m" + incorrectAnswers + "\033[0m");
            }

            System.out.println();
        }
    }

    // Ejercicios con Ticket master

    private static final String API_KEY_TICKET_MASTER = System.getenv("API_KEY_TICKET_MASTER");

    public static void initializeApiKeyTicketMaster() {

        if (API_KEY_TICKET_MASTER == null || API_KEY_TICKET_MASTER.isEmpty()) {
            System.err.println(
                    "ERROR: La variable de entorno " + API_KEY_TICKET_MASTER
                            + " no está definida en tu terminal. Usa 'export "
                            + API_KEY_TICKET_MASTER + "=\"...\"'.");
            System.exit(1);
        }

        System.out.println("Clave API cargada con exito.");

        System.out.println("Clave (fragmento): "
                + API_KEY_TICKET_MASTER.substring(0, Math.min(API_KEY_TICKET_MASTER.length(), 8)) + "...");
        System.out.println();
    }

    // Ejercicio 10
    public void mostrarEventosPais(String codigoPais) throws URISyntaxException {
        String URL = String.format("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=%s&apikey=%s",
                codigoPais, API_KEY_TICKET_MASTER);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonObject embeddedObject = jsonObject.getJsonObject("_embedded");

        JsonArray eventsArray = embeddedObject.getJsonArray("events");

        for (int i = 0; i < eventsArray.size(); i++) {
            JsonObject objecEvents = eventsArray.getJsonObject(i);

            String evento = objecEvents.getString("name");

            System.out.println(evento);
        }
    }

    // Ejercicio 11 y 12

    public String[] getIdEventosPais(String codigoPais) throws URISyntaxException {
        String URL = String.format("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=%s&apikey=%s",
                codigoPais, API_KEY_TICKET_MASTER);

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        JsonObject jsonObject = (JsonObject) json;

        JsonObject embeddedObject = jsonObject.getJsonObject("_embedded");

        JsonArray eventsArray = embeddedObject.getJsonArray("events");

        String[] arrayID = new String[eventsArray.size()];

        for (int i = 0; i < eventsArray.size(); i++) {
            JsonObject objecEvents = eventsArray.getJsonObject(i);

            String id = objecEvents.getString("id");

            arrayID[i] = id;
        }

        return arrayID;
    }

    public void mostrarDatosEvento(String[] listaID) throws URISyntaxException, InterruptedException {

        for (String id : listaID) {
            String URL = String.format("https://app.ticketmaster.com/discovery/v2/events/%s.json?apikey=%s", id,
                    API_KEY_TICKET_MASTER);

            JsonUtils jUtils = new JsonUtils();
            JsonValue json = jUtils.leeJSON(URL);

            JsonObject jsonObject = (JsonObject) json;

            // Mostrar nombre evento
            String name = jsonObject.getString("name");
            System.out.println("Nombre: " + name);

            // Mostrar Fecha
            JsonObject jsonObjectFechas = jsonObject.getJsonObject("dates");
            JsonObject jsonObjectFecha = jsonObjectFechas.getJsonObject("start");

            String fecha = jsonObjectFecha.getString("localDate");

            System.out.println("Fecha: " + fecha);

            // Mostrar localización
            JsonObject embeddedObject = jsonObject.getJsonObject("_embedded");
            JsonArray venuesArray = embeddedObject.getJsonArray("venues");

            JsonObject venuesObject = venuesArray.getJsonObject(0);

            String localizacion = venuesObject.getString("name");

            JsonObject cityObject = venuesObject.getJsonObject("city");

            String ciudad = cityObject.getString("name");

            System.out.printf("Localización: %s, %s\n", localizacion, ciudad);
            System.out.println("Pronóstico: ");
            pronosticoCompleto(ciudad);

            System.out.println("--------------------------------------------------");

            Thread.sleep(200);
        }
    }
}