package com.nix.zemnitskiy.karaf.weather.rest.cassandra;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CassandraConnector {


    private Cluster cluster;
    private Session session;
    private final String node;
    private final Integer port;
    private final String keyspace;

    public void connect() {
        Cluster.Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
        try {
            session = cluster.connect(keyspace);
        }
        catch (Exception e){
            session = cluster.connect();
            session.execute("CREATE KEYSPACE IF NOT EXISTS "+ keyspace +" WITH replication = " +
                    "{'class':'SimpleStrategy','replication_factor':'1'};");
            session.execute("USE "+ keyspace);
        }
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}