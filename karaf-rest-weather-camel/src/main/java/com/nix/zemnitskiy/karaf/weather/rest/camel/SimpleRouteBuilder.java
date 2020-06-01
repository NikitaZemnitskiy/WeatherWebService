package com.nix.zemnitskiy.karaf.weather.rest.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

private static final String EMAIL = "nik.zemnitskiy@gmail.com";
private static final String SMTP = "smtp://localhost:25";
private static final String TITLE = "Test Message";

    @Override
    public void configure() {
        from("direct:sendWeather").doTry().setHeader("subject", simple(TITLE))
                .setHeader("to", simple(EMAIL))
                .to(SMTP);
    }
}