package org.apache.karaf.weather.rest.provider;

import org.apache.karaf.weather.rest.api.Temperature;
import org.apache.karaf.weather.rest.api.Weather;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProviderWeatherServiceImplRestTest {

    @Test
    public void getWeatherMethodDefaultValueCheck() {
        ProviderWeatherServiceImpl mock = Mockito.mock(ProviderWeatherServiceImpl.class);
        Weather londonWeather = new Weather("london", "clouds",new Temperature(), 15,15);
        Mockito.when(mock.getWeatherByCity("london")).thenReturn(londonWeather);
        WeatherServiceRest weatherServiceRest = new WeatherServiceRest(mock);
        assertEquals(weatherServiceRest.getWeather("london"), londonWeather);

    }

    @Test
    public void getWeatherMethodInvalidValueCheck() {
       ProviderWeatherServiceImpl mock = Mockito.mock(ProviderWeatherServiceImpl.class);
        Mockito.when(mock.getWeatherByCity("FictionalCity")).thenThrow(new IllegalStateException("invalid city name"));
        WeatherServiceRest weatherServiceRest = new WeatherServiceRest(mock);
        Throwable thrown = assertThrows(IllegalStateException.class, () ->
            new WeatherServiceRest(mock).getWeather("FictionalCity")
        );
        assertEquals(thrown.getMessage(), "invalid city name");
    }
}