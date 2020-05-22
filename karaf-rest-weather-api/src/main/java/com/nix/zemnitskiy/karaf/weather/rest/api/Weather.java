package com.nix.zemnitskiy.karaf.weather.rest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private String base;
    private String name;
    private Temperature main;
    private double visibility;
    private double timezone;
}
