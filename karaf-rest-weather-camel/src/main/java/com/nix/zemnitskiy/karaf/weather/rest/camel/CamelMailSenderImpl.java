package com.nix.zemnitskiy.karaf.weather.rest.camel;

import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;


public class CamelMailSenderImpl implements CamelMailSender {

    SimpleRouteBuilder simpleRouteBuilder;
    CamelContext camelContext;

    public CamelMailSenderImpl(SimpleRouteBuilder simpleRouteBuilder, CamelContext camelContext) {
        this.simpleRouteBuilder = simpleRouteBuilder;
        this.camelContext = camelContext;
    }

    @Override
    public void sendEmail(Weather weather) {

        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(simpleRouteBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ProducerTemplate producerTemplate = context.createProducerTemplate();
        context.start();
        producerTemplate.sendBody("direct:sendWeather", weather);
    }

}
