package com.nix.zemnitskiy.karaf.weather.rest.cassandra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.nix.zemnitskiy.karaf.weather.rest.api.Temperature;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class WeatherDaoImplTest {

    private Session session;
    private WeatherDao weatherDao;
    private final Temperature londonT = new Temperature();
    private final Weather londonWeather = new Weather(1000001,"london", "clouds", londonT, 15, 15);

    @BeforeEach
    public void connect() {
        CassandraConnector client = new CassandraConnector("127.0.0.1",9042, "weather_keyspace");
        client.connect();
        this.session = client.getSession();
        this.weatherDao = new WeatherDaoImpl(client);
    }

    @Test
    void whenAddingNewWeather_thenWeatherExists() {
        weatherDao.save(londonWeather);
        ResultSet result = session.execute("select * from weather where id = 1000001");
        Row row = result.one();
        Weather weather = new Weather(row.getInt(0),
                row.getString(1),
                row.getString(3),
                londonWeather.getMain(),
                row.getDouble(4),
                row.getDouble(5));
        assertEquals(weather, londonWeather);
    }
    @AfterEach
    public void deleteWeather() {
        session.execute("delete from weather where id = " + londonWeather.getId());
        session.execute("delete from temperature where temp_id = '" + londonWeather.getMain().getTempId() + "'");
    }
}