package com.nix.zemnitskiy.karaf.weather.rest.cassandra;

import com.datastax.driver.core.Session;
import com.nix.zemnitskiy.karaf.weather.rest.api.Weather;
import com.savoirtech.hecate.pojo.dao.PojoDao;
import com.savoirtech.hecate.pojo.dao.PojoDaoFactory;
import com.savoirtech.hecate.pojo.dao.def.DefaultPojoDaoFactoryBuilder;
import com.savoirtech.hecate.pojo.dao.listener.CreateSchemaListener;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDaoImpl implements WeatherDao {
    private PojoDao<Weather> weatherPojoDao;
    private CassandraConnector cassandraConnector;

    public WeatherDaoImpl(CassandraConnector cassandraConnector) {
        this.cassandraConnector = cassandraConnector;
        cassandraConnector.connect();
        Session session = cassandraConnector.getSession();
        PojoDaoFactory factory = new DefaultPojoDaoFactoryBuilder(session)
                .withListener(new CreateSchemaListener(session))
                .build();
       this.weatherPojoDao = factory.createPojoDao(Weather.class);
    }

    @Override
    public void save(Weather weather) {
        weatherPojoDao.save(weather);
    }

    @Override
    public Weather find(int id) {
        return weatherPojoDao.findByKey(id);
    }

}
