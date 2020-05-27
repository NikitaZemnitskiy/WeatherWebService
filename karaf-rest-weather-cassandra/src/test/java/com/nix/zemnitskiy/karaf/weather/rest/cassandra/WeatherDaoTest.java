package com.nix.zemnitskiy.karaf.weather.rest.cassandra;

import com.datastax.driver.core.Session;
import com.nix.zemnitskiy.karaf.weather.rest.api.Temperature;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import com.savoirtech.hecate.pojo.dao.PojoDao;
import com.savoirtech.hecate.pojo.dao.PojoDaoFactory;
import com.savoirtech.hecate.pojo.dao.def.DefaultPojoDaoFactoryBuilder;
import com.savoirtech.hecate.pojo.dao.listener.CreateSchemaListener;
import com.savoirtech.hecate.test.Cassandra;
import com.savoirtech.hecate.test.CassandraTestCase;
import org.junit.Before;
import org.junit.Test;

@Cassandra
public class WeatherDaoTest extends CassandraTestCase {

    WeatherDaoImpl weatherDao = new WeatherDaoImpl();

    @Before
    public void initDaoFactory() {
        Session session = getSession();
        PojoDaoFactory factory = new DefaultPojoDaoFactoryBuilder(session)
                .withListener(new CreateSchemaListener(session))
                .build();
        PojoDao<Weather> weatherPojoDao =  factory.createPojoDao(Weather.class);
        weatherDao.setWeatherPojoDao(weatherPojoDao);
    }

    @Test
    public void shouldSaveWeatherAndThenFindIt() {
        Weather saveWeather = new Weather(6223,"london", "clouds", new Temperature("someTemp",1,2,3,4,5,6), 15, 15);
        weatherDao.save(saveWeather);
        Weather findWeather = weatherDao.find(6223);
        assertEquals(saveWeather,findWeather);
    }
}
