package com.nix.zemnitskiy.karaf.weather.rest.camel;

import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

@RequiredArgsConstructor
public class CamelMailSenderImpl implements CamelMailSender {

    private final CamelContext context;

    @Override
    public void sendEmail(Weather weather) {
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        context.start();
        producerTemplate.sendBody("direct:sendWeather", weather);
    }

}
