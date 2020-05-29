package com.nix.zemnitskiy.karaf.weather.rest.camel;

import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelMailSender {
    SimpleRouteBuilder simpleRouteBuilder = new SimpleRouteBuilder();
    public void sendEmail(Weather weather) {
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(simpleRouteBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            context.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:start", weather);
        try {
            context.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
