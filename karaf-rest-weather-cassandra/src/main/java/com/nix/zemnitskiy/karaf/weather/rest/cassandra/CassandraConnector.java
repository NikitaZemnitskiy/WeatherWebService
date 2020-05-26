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

        session = cluster.connect(keyspace);
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}