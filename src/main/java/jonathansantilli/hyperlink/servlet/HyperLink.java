package jonathansantilli.hyperlink.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jonathansantilli.hyperlink.service.PageService;


/**
 * Servlet that handle the HTTP requests to return the links from a Web page behind a url
 * 
 * @author Jonathan Santilli
 */
@Path("links/{url}")
public class HyperLink {
    private static final Logger logger = Logger.getLogger(HyperLink.class.getName());

    /**
     * Main resource (exposed at "links" path)
     * 
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" Content-type.
     *
     * @return ArrayList<String> that will be returned as a JSON response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getHyperLinks(@PathParam("url") String pageUrl) {
        ArrayList<String> links = new ArrayList<>();
        try {
            links = (ArrayList<String>)PageService.getHyperLinks(pageUrl);
        } catch (IOException e) {
            logger.info("There was a problem getting the Links from the URL: " + pageUrl + "\n"
                        + "Error: " + e.toString());
        }

        return links;
    }
}
