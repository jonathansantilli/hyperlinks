package jonathansantilli.hyperlink.servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.junit.Test;

public class HyperLinkTest extends ServerTest {
	
	private String staticContentUrl = "http://localhost:8080/static-content";

    /**
     * Test to verify if the HTML response contains the anchors (links).
     * 
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void testLinksEndPointReturnTheLinkPresentOnTheHTMLDocument() throws UnsupportedEncodingException {
    	String urlParameter = URLEncoder.encode(staticContentUrl + "/example-with-one-link", "UTF-8");
    	String linksPath = "links/" + urlParameter;
    	ArrayList<String> expectedResponse = new ArrayList<>();
    	expectedResponse.add("<a href=\"http://www.example.com\"></a>");
    	
    	@SuppressWarnings("unchecked")
		ArrayList<String> response = getTarget().path(linksPath).request().get(ArrayList.class);
    	
        assertEquals(expectedResponse, response);
        assertTrue(response.size() == 1);
    }
    
    /**
     * Test to verify that the HTML response does not contains anchors (empty array).
     * 
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void testLinksEndPointReturnEmptyResponse() throws UnsupportedEncodingException {
    	String urlParameter = URLEncoder.encode(staticContentUrl + "/example-with-no-link", "UTF-8");
    	String linksPath = "links/" + urlParameter;
    	ArrayList<String> expectedResponse = new ArrayList<>();
    	
    	@SuppressWarnings("unchecked")
		ArrayList<String> response = getTarget().path(linksPath).request().get(ArrayList.class);
    	
        assertEquals(expectedResponse, response);
        assertTrue(response.isEmpty());
    }
}
