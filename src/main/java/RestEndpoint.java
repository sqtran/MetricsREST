import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.codahale.metrics.Meter;

@ApplicationPath("/")
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RestEndpoint extends Application {

    private final Meter hellos = MyMetricsServletContextListener.METRIC_REGISTRY.meter("hellos");

    private final Meter worlds = MyMetricsServletContextListener.METRIC_REGISTRY.meter("worlds");

    @GET
    @Path("hello")
    public Response getHello() {
        hellos.mark();
        return buildResponse(Response.Status.OK, "hello");
    }

    @GET
    @Path("world")
    public Response getWorld() {
        worlds.mark();
        return buildResponse(Response.Status.OK, "world");
    }

    private Response buildResponse(Response.Status status, Object results) {
        ResponseBuilder rb = Response.status(status);
        rb.entity(results);
        return rb.build();
    }
}