# Apache Karaf REST Example

## Artifacts

* **karaf-rest-weather-api** is a common bundle containing the `Weather` POJO and the `WeatherService` interface.   
* **karaf-rest-weather-provider** is a blueprint bundle providing the `WeatherServiceRestImpl` implementation of the `WeatherService` interface.
* **karaf-rest-weather-features** provides a Karaf features repository used for the deployment.

## Build

The build uses Apache Maven. Simply use:

```
mvn clean install
```

## Feature and Deployment

On a running Karaf instance, register the features repository using:

```
karaf@root()> feature:repo-add mvn:com.nix.zemnitskiy/karaf-rest-weather-features/1.0.0/xml
```

Then, you can install the service blueprint provider feature:

```
karaf@root()> feature:install karaf-rest-weather-provider
```
