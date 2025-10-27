package dev.lib;

import java.net.URISyntaxException;

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

    public String getTiempoCiudad(String ciudad) throws URISyntaxException {

        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=" + API_KEY;

        JsonUtils jUtils = new JsonUtils();
        JsonValue json = jUtils.leeJSON(URL);

        return json.toString();
    }
}
