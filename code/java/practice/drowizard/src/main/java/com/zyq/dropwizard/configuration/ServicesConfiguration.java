package com.zyq.dropwizard.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
public class ServicesConfiguration extends Configuration {

    @NotEmpty
    private String healthCheckProperty;

    @NotEmpty
    private String redisHost;

    @NotEmpty
    private String redisPort;

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    private FlywayFactory flywayFactory = new FlywayFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("flyway")
    public FlywayFactory getFlywayFactory() {
        return flywayFactory;
    }


}
