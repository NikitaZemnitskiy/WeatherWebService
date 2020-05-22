package com.nix.zemnitskiy.karaf.weather.rest.provider;

import com.nix.zemnitskiy.karaf.weather.rest.api.Temperature;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.BadRequestException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class ProviderWeatherServiceImplRestTest {
    @Mock
    ProviderWeatherServiceImpl providerWeatherServiceImplmock;

    @Test
    public void getWeatherMethodDefaultValueCheck() {

        Weather londonWeather = new Weather("london", "clouds", new Temperature(), 15, 15);
        Mockito.when(providerWeatherServiceImplmock.getWeatherByCity("london")).thenReturn(londonWeather);
        WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl(providerWeatherServiceImplmock);
        assertEquals(weatherServiceImpl.getWeather("london"), londonWeather);

    }

    @Test
    public void getWeatherMethodInvalidValueCheck() {

        Mockito.when(providerWeatherServiceImplmock.getWeatherByCity("FictionalCity")).thenThrow(new BadRequestException("City FictionalCity is not in our database"));
        WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl(providerWeatherServiceImplmock);
        Throwable thrown = assertThrows(BadRequestException.class, () ->
                new WeatherServiceImpl(providerWeatherServiceImplmock).getWeather("FictionalCity")
        );
        assertEquals(thrown.getMessage(), "City FictionalCity is not in our database");
    }
}