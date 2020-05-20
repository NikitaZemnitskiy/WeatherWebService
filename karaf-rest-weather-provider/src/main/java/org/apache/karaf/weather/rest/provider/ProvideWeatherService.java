package org.apache.karaf.weather.rest.provider;

import org.apache.karaf.weather.rest.api.Weather;

public interface ProvideWeatherService {
    public Weather getWeatherByCity(String city);
}
