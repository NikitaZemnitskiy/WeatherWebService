package org.apache.karaf.weather.rest.provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.karaf.weather.rest.api.Weather;

import java.io.IOException;
import java.net.URL;


public class ProviderWeatherServiceImpl implements ProvideWeatherService {
    private final String weatherKey = "9bc9127b5ca9be05751bd273761634d4";
    private final String units = "metric";

    public Weather getWeatherByCity(String city) {
        StringBuilder url = new StringBuilder();
        url.append("https://api.openweathermap.org/data/2.5/weather?q=")
                .append(city)
                .append("&units=").append(units)
                .append("&APPID=").append(weatherKey);
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(new URL(url.toString()), Weather.class);
        } catch (IOException e) {
            throw new IllegalStateException("invalid city name");
        }
    }
}
