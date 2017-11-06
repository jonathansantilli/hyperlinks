package jonathansantilli.hyperlink.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
    public ArrayList<String> getHyperLinks(@PathParam("url") String pageUrl) {
    	
        try {
        	PageService service = new PageService();
        	return service.getHyperLinks(pageUrl);
        } catch (IOException e) {
        	System.err.println("There was a problem getting the Links from the URL: " + pageUrl + "\n"
        			+ "Error: " + e.toString());
        }
        
        return null;
    }
}
