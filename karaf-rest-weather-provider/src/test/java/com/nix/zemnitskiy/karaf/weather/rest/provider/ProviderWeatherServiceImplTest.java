package com.nix.zemnitskiy.karaf.weather.rest.provider;

import org.apache.cxf.jaxrs.client.WebClient;
import com.nix.zemnitskiy.karaf.weather.rest.api.Temperature;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;


@RunWith(MockitoJUnitRunner.class)
public class ProviderWeatherServiceImplTest {
    @Mock
    WebClient mockWebClient;

    @Test
    public void getWeatherByCityCorrectInput() {
        Weather londonWeather = new Weather(6223,"london", "clouds", new Temperature(), 15, 15);
        Mockito.when(mockWebClient.reset()).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.query(anyString(), anyString())).thenReturn(mockWebClient);
        Mockito.when(mockWebClient.get(Weather.class)).thenReturn(londonWeather);
        ProviderWeatherServiceImpl providerWeatherService = new ProviderWeatherServiceImpl(mockWebClient);
        assertEquals(providerWeatherService.getWeatherByCity("london"), londonWeather);
    }

}