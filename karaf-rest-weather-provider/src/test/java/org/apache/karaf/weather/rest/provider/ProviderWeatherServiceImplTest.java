package org.apache.karaf.weather.rest.provider;

import org.apache.karaf.weather.rest.api.Weather;
import org.junit.Test;

import javax.ws.rs.BadRequestException;

import static org.junit.Assert.*;

public class ProviderWeatherServiceImplTest {

    @Test
    public void getWeatherByCityCorrectInput() {
        ProviderWeatherServiceImpl providerWeatherService = new ProviderWeatherServiceImpl();
        Weather weather = providerWeatherService.getWeatherByCity("london");
        assertNotNull(weather.getBase());
        assertNotNull(weather.getName());
        assertNotNull(weather.getMain());
    }
    @Test
    public void getWeatherByCityIncorrectInput() {
        ProviderWeatherServiceImpl providerWeatherService = new ProviderWeatherServiceImpl();
        Throwable thrown = assertThrows(BadRequestException.class, () ->
                new WeatherServiceImpl(providerWeatherService).getWeather("FictionalCity")
        );
        assertEquals(thrown.getMessage(), "City FictionalCity is not in our database");
    }
}