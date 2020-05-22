package com.nix.zemnitskiy.karaf.weather.rest.provider;

import org.apache.cxf.jaxrs.client.WebClient;
import com.nix.zemnitskiy.karaf.weather.rest.api.Temperature;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import javax.ws.rs.BadRequestException;
import static org.mockito.Matchers.*;



import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProviderWeatherServiceImplTest {
    @Mock
    WebClient mockWebClient;

    @Test
    public void getWeatherByCityCorrectInput() {
        Weather londonWeather = new Weather("london", "clouds", new Temperature(), 15, 15);
        Mockito.when(mockWebClient.reset()).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.query(anyString(), anyString())).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.get(Weather.class)).thenReturn(londonWeather);
        ProviderWeatherServiceImpl providerWeatherService = new ProviderWeatherServiceImpl(mockWebClient);
        assertEquals(providerWeatherService.getWeatherByCity("london"), londonWeather);
    }
    @Test
    public void getWeatherByCityIncorrectInput() {
        ProviderWeatherServiceImpl providerWeatherService = new ProviderWeatherServiceImpl(mockWebClient);
        Mockito.when(mockWebClient.reset()).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.query(anyString(), anyString())).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.get(Weather.class)).thenThrow(new BadRequestException("City FictionalCity is not in our database"));
        Throwable thrown = assertThrows(BadRequestException.class, () ->
                new WeatherServiceImpl(providerWeatherService).getWeather("FictionalCity")
        );
        assertEquals(thrown.getMessage(), "City FictionalCity is not in our database");
    }
}