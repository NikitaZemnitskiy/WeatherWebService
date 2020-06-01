package com.nix.zemnitskiy.karaf.weather.rest.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:sendWeather").doTry().setHeader("subject", simple("Test Message"))
                .setHeader("to", simple("nik.zemnitskiy@gmail.com"))
                .to("smtp://localhost:25");
    }
}