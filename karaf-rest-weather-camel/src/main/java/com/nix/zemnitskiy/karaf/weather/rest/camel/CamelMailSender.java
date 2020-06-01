package com.nix.zemnitskiy.karaf.weather.rest.camel;

import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;

public interface CamelMailSender {
    public void sendEmail(Weather weather);
}
