package jonathansantilli.hyperlink.app;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main entry point for the Application
 * 
 * @author Jonathan Santilli
 */
public class Main {
    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in the Application.
     * 
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // Create a resource configuration that scans for JAX-RS 
        // resources and providers in jonathansantilli.hyperlink.servlet package
        final ResourceConfig config = new ResourceConfig().packages("jonathansantilli.hyperlink.servlet");

        // Create and start a new instance of Grizzly HTTP server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(AppConfiguration.BASE_URI), config);
    }

    /**
     * Main method. Server entry point
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("App started and available at %s\n"
                + "Hit enter to stop it...", AppConfiguration.BASE_URI + "links/<encodec_url_parameter>"));
        System.in.read();
        server.shutdownNow();
    }
}

