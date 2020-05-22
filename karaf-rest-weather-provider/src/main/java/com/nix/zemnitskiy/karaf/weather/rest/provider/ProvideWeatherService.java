package com.nix.zemnitskiy.karaf.weather.rest.provider;

import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;

public interface ProvideWeatherService {
    public Weather getWeatherByCity(String city);
}
