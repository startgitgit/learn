package com.zyq.dropwizard;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by jagmeet.singh on 03/01/15.
 */
public class ServicesHealthCheck extends HealthCheck {

    private static final String EXPECTED_HEALTH_CHECK_PROPERTY = "Flipkart ThunderingRhino Ad";
    private String healthCheckProperty;

    public ServicesHealthCheck(String healthCheckProperty) {
        this.healthCheckProperty = healthCheckProperty;
    }

    @Override
    protected Result check() throws Exception {
        Result result = Result.healthy();
        if (!EXPECTED_HEALTH_CHECK_PROPERTY.equals(healthCheckProperty)) {
            result = Result.unhealthy("Expected configuration not loaded.");
        }

        return result;
    }
}
