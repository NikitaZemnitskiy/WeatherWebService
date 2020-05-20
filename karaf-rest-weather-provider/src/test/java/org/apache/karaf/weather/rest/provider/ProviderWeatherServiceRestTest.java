package org.apache.karaf.weather.rest.provider;

import org.apache.karaf.weather.rest.api.Temperature;
import org.apache.karaf.weather.rest.api.Weather;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProviderWeatherServiceRestTest {

    @Test
    public void getWeatherMethodDefaultValueCheck() {
        WeatherServiceRest weatherServiceRest = new WeatherServiceRest();
        ProviderWeatherService mock = Mockito.mock(ProviderWeatherService.class);
        weatherServiceRest.providerWeatherService = mock;
        Weather londonWeather = new Weather("london", "clouds",new Temperature(), 15,15);
        Mockito.when(mock.getWeatherByCity("london")).thenReturn(londonWeather);
        assertEquals(weatherServiceRest.getWeather("london"), londonWeather);

    }

    @Test
    public void getWeatherMethodInvalidValueCheck() {
       ProviderWeatherService mock = Mockito.mock(ProviderWeatherService.class);
        Mockito.when(mock.getWeatherByCity("FictionalCity")).thenThrow(new IllegalStateException("invalid city name"));
        WeatherServiceRest weatherServiceRest = new WeatherServiceRest();
        weatherServiceRest.providerWeatherService = mock;
        Throwable thrown = assertThrows(IllegalStateException.class, () -> {
            new WeatherServiceRest().getWeather("FictionalCity");
        });
        assertEquals(thrown.getMessage(), "invalid city name");
    }
}