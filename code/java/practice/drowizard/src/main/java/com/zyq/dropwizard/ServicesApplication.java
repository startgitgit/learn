package com.zyq.dropwizard;

import com.zyq.dropwizard.configuration.ServicesConfiguration;
import com.zyq.dropwizard.dao.PositionDao;
import com.zyq.dropwizard.flyway.FlywayBundleImpl;
import com.zyq.dropwizard.resources.PositionResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.commons.lang3.ArrayUtils;
import org.skife.jdbi.v2.DBI;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URL;
import java.util.Objects;


public class ServicesApplication extends Application<ServicesConfiguration> {

    public static void main(String[] args) throws Exception {
        if (ArrayUtils.isEmpty(args)) {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("application.yml");
            String path = Objects.requireNonNull(resource).getPath();
            args = new String[]{"server", path};
        }
        new ServicesApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServicesConfiguration> bootstrap) {

        bootstrap.addBundle(new FlywayBundleImpl());
    }

    @Override
    public void run(ServicesConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        PositionDao positionDao = jdbi.onDemand(PositionDao.class);


        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        final JedisPool pool = new JedisPool(poolConfig,configuration.getRedisHost(), Integer.parseInt(configuration.getRedisPort()));


        environment.jersey().register(new PositionResource(positionDao));

        final ServicesHealthCheck servicesHealthCheck = new ServicesHealthCheck(configuration.getHealthCheckProperty());
        environment.healthChecks().register("configurationCheck", servicesHealthCheck);

    }
}
