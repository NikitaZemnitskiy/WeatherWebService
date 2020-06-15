package com.nix.zemnitskiy.karaf.weather.rest.provider;

import lombok.RequiredArgsConstructor;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import com.nix.zemnitskiy.karaf.weather.rest.api.WeatherService;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.ws.rs.core.Response;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final ProviderWeatherServiceImpl providerWeatherServiceImpl;

    @CrossOriginResourceSharing(
            allowAllOrigins = true,
            allowCredentials = true,
            maxAge = 1209600 )
    @Override
    public Response getWeather(String city) {
        Weather weather = providerWeatherServiceImpl.getWeatherByCity(city);
        return Response
               .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(weather)
                .build();
    }
}