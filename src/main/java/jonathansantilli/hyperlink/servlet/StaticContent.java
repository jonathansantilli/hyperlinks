package jonathansantilli.hyperlink.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jonathansantilli.hyperlink.exception.UnavailableContentException;
import jonathansantilli.hyperlink.service.PageService;

/**
 * Servlet that handle the HTTP requests to return static content for tests purpose
 * 
 * @author Jonathan Santilli
 */
@Path("static-content")
public class StaticContent {

	private PageService pageService = null;
	
	public StaticContent() {
		this.pageService = new PageService();
	}
    /**
     * Get a HTML page with one link.
     * The method handle HTTP GET requests.
     * The returned object will be sent to the client as "text/html" Content-type.
     *
     * @return String that will be returned as a HTML response.
     * @throws UnavailableContentException 
     */
    @GET
    @Path("example-with-one-link")
    @Produces(MediaType.TEXT_HTML)
    public String getHTMLTextWithOneLinks() throws UnavailableContentException {	
    	return this.pageService.getTextFromHTMLDocument("example_with_one_link.html");
    }
    
    /**
     * Get a HTML page with no links within it.
     * The method handle HTTP GET requests.
     * The returned object will be sent to the client as "text/html" Content-type.
     *
     * @return String that will be returned as a HTML response.
     * @throws UnavailableContentException 
     */
    @GET
    @Path("example-with-no-link")
    @Produces(MediaType.TEXT_HTML)
    public String getHTMLTextWithNoLinks() throws UnavailableContentException {	
    	return this.pageService.getTextFromHTMLDocument("example_with_no_link.html");
    }
}
