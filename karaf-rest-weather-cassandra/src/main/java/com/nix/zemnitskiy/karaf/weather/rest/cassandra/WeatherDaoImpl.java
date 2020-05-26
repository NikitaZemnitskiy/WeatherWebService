package com.nix.zemnitskiy.karaf.weather.rest.cassandra;

import com.datastax.driver.core.Session;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import com.savoirtech.hecate.pojo.dao.PojoDao;
import com.savoirtech.hecate.pojo.dao.PojoDaoFactory;
import com.savoirtech.hecate.pojo.dao.def.DefaultPojoDaoFactoryBuilder;
import com.savoirtech.hecate.pojo.dao.listener.CreateSchemaListener;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherDaoImpl implements WeatherDao {
    private PojoDao<Weather> weatherPojoDao;
    private final CassandraConnector cassandraConnector;

    public PojoDao<Weather> getWeatherPojoDao() {
        if(weatherPojoDao == null){
            cassandraConnector.connect();
            Session session = cassandraConnector.getSession();
            PojoDaoFactory factory = new DefaultPojoDaoFactoryBuilder(session)
                    .withListener(new CreateSchemaListener(session))
                    .build();
           weatherPojoDao = factory.createPojoDao(Weather.class);
        }
        return weatherPojoDao;
    }

    @Override
    public void save(Weather weather) {
        getWeatherPojoDao().save(weather);
    }

}
