package org.apache.karaf.weather.rest.provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.karaf.weather.rest.api.Weather;

import javax.ws.rs.core.Application;
import java.io.IOException;
import java.net.URL;


public class ProviderWeatherService extends Application {


    public Weather getWeatherByCity(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&APPID=9bc9127b5ca9be05751bd273761634d4";
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(new URL(url), Weather.class);
        } catch (IOException e) {
            throw new IllegalStateException("invalid city name");
        }
    }
}
