package com.nix.zemnitskiy.karaf.weather.rest.cassandra;

import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;

public interface WeatherDao {
     void save(Weather weather);
     Weather find(int id);
}
