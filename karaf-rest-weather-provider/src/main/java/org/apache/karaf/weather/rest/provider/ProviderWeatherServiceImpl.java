package org.apache.karaf.weather.rest.provider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.karaf.weather.rest.api.Weather;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequiredArgsConstructor
public class ProviderWeatherServiceImpl implements ProvideWeatherService {
    private final String weatherKey = "9bc9127b5ca9be05751bd273761634d4";
    private final String units = "metric";
    private final WebClient webClient;

    public Weather getWeatherByCity(String city) {
        return webClient.query("q",city).query("units",units).query("APPID", weatherKey).get(Weather.class);
   /*     String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=%s&APPID=%s", city, units, weatherKey);
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = builder.get();
        Weather weather = response.readEntity(Weather.class);
        if(weather.getName() == null){
            throw new BadRequestException("City "+city+" is not in our database");
        }
        return weather;*/
    }
}
