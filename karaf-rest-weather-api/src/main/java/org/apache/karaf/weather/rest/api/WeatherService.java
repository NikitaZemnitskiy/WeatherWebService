package org.apache.karaf.weather.rest.api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


public interface WeatherService {
    @Path("/city/{city}")
    @Produces("application/json")
    @GET
    Weather getWeather(@PathParam("city") String city);
}
