package com.nix.zemnitskiy.karaf.weather.rest.provider;

import lombok.RequiredArgsConstructor;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import com.nix.zemnitskiy.karaf.weather.rest.api.WeatherService;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final ProviderWeatherServiceImpl providerWeatherServiceImpl;

    @Override
    public Weather getWeather(String city) {
        return providerWeatherServiceImpl.getWeatherByCity(city);
    }
}