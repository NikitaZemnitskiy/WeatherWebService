package com.nix.zemnitskiy.karaf.weather.rest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.savoirtech.hecate.annotation.PartitionKey;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @PartitionKey
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;
}
