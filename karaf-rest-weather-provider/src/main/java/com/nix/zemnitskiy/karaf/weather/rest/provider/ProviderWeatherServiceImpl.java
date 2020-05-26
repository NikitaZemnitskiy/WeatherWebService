package com.nix.zemnitskiy.karaf.weather.rest.provider;

import com.nix.zemnitskiy.karaf.weather.rest.cassandra.WeatherDao;
import com.nix.zemnitskiy.karaf.weather.rest.cassandra.WeatherDaoImpl;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.jaxrs.client.WebClient;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;


@RequiredArgsConstructor
public class ProviderWeatherServiceImpl implements ProvideWeatherService {
    private final String weatherKey = "9bc9127b5ca9be05751bd273761634d4";
    private final String units = "metric";
    private final WebClient webClient;
    private final WeatherDao weatherDao;


    public Weather getWeatherByCity(String city) {
        Weather weather = webClient.reset()
                .query("q",city)
                .query("units",units)
                .query("APPID", weatherKey)
                .get(Weather.class);
        weatherDao.save(weather);
        return weather;
    }
}
