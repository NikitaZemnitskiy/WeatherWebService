package org.apache.karaf.weather.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class Weather {
    private String base;
    private String name;
    private Temperature main;
    private double visibility;
    private double timezone;
}
