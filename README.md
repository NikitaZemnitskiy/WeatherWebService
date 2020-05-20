# Apache Karaf REST Example

## Artifacts

* **karaf-rest-example-api** is a common bundle containing the `Booking` POJO and the `BookingService` interface.   
* **karaf-rest-example-blueprint** is a blueprint bundle providing the `BookingServiceRest` implementation of the `WeatherService` interface.
* **karaf-rest-example-features** provides a Karaf features repository used for the deployment.

## Build

The build uses Apache Maven. Simply use:

```
mvn clean install
```

## Feature and Deployment

On a running Karaf instance, register the features repository using:

```
karaf@root()> feature:repo-add mvn:org.apache.karaf.examples/karaf-rest-example-features/LATEST/xml
```

Then, you can install the service blueprint provider feature:

```
karaf@root()> feature:install karaf-rest-example-blueprint
```
