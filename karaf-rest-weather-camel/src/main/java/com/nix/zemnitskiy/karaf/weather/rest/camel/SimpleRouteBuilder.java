package com.nix.zemnitskiy.karaf.weather.rest.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start").doTry().setHeader("subject", simple("JavaInUse Invitation111"))
                .setHeader("to", simple("javainuse@gmail.com,testouthworking@gmail.com"))
                .to("smtp://localhost:25");
    }
}