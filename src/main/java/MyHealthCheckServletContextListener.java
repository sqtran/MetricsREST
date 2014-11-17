import javax.servlet.annotation.WebListener;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;

/**
 * Need to need the HealthCheckRegistry to the Servlet Context for Metrics-Servlet API
 */
@WebListener
public class MyHealthCheckServletContextListener extends HealthCheckServlet.ContextListener {

    public static final HealthCheckRegistry HEALTH_CHECK_REGISTRY = new HealthCheckRegistry();

    @Override
    protected HealthCheckRegistry getHealthCheckRegistry() {
        return HEALTH_CHECK_REGISTRY;
    }
}