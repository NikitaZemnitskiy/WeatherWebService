package com.nix.zemnitskiy.karaf.weather.rest.api;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public interface WeatherService {

    @Path("/city/{city}")
    @Produces("application/json")
    @GET
    Response getWeather(@PathParam("city") String city);
}
