package com.zyq.dropwizard.flyway;

import com.zyq.dropwizard.configuration.ServicesConfiguration;
import io.dropwizard.db.DatabaseConfiguration;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.setup.Environment;

public class FlywayBundleImpl extends FlywayBundle<ServicesConfiguration> implements DatabaseConfiguration<ServicesConfiguration> {
    @Override
    public void run(ServicesConfiguration configuration, Environment environment) throws Exception {

    }

    @Override
    public PooledDataSourceFactory getDataSourceFactory(ServicesConfiguration configuration) {
        return configuration.getDataSourceFactory();
    }

    @Override
    public FlywayFactory getFlywayFactory(ServicesConfiguration configuration) {
        return configuration.getFlywayFactory();
    }
}
