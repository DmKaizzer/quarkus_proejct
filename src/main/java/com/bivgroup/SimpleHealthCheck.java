package com.bivgroup;

import com.bivgroup.entity.Flat;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class SimpleHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        try {
            Flat flat = Flat.findById(333L);
            if (flat.id == 333L) {
                return HealthCheckResponse.up("Simple health check");
            } else
                return HealthCheckResponse.down("Simple health check");
        } catch (Exception ew) {
            return HealthCheckResponse.down("Simple health check");
        }
    }

}