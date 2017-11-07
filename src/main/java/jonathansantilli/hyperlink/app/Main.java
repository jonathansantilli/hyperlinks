package jonathansantilli.hyperlink.app;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main entry point for the Application
 * 
 * @author Jonathan Santilli
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
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
        logger.info(String.format("\n\n\nApp started and available at %s\n"
                    + "Hit <ENTER> to stop the App...\n\n\n", AppConfiguration.BASE_URI 
                    + "links/<encodec_url_parameter>"));
        System.in.read();
        server.shutdownNow();
    }
}

