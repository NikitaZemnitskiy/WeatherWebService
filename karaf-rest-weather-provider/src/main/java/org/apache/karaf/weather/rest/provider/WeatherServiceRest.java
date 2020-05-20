package org.apache.karaf.weather.rest.provider;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.karaf.weather.rest.api.Weather;
import org.apache.karaf.weather.rest.api.WeatherService;


@Path("/")
public class WeatherServiceRest implements WeatherService {
    @Context
    ProviderWeatherService providerWeatherService = new ProviderWeatherService();

    @Override
    public Weather getWeather(String city) {
        return providerWeatherService.getWeatherByCity(city);
    }
}