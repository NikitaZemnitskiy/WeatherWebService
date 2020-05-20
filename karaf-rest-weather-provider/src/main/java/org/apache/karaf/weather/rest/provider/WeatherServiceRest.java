package org.apache.karaf.weather.rest.provider;

import javax.ws.rs.Path;

import lombok.RequiredArgsConstructor;
import org.apache.karaf.weather.rest.api.Weather;
import org.apache.karaf.weather.rest.api.WeatherService;

@RequiredArgsConstructor
public class WeatherServiceRest implements WeatherService {

    private final ProviderWeatherServiceImpl providerWeatherServiceImpl;

    @Override
    public Weather getWeather(String city) {
        return providerWeatherServiceImpl.getWeatherByCity(city);
    }
}