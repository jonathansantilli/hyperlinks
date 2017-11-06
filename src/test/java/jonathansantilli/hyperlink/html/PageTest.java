package jonathansantilli.hyperlink.html;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import jonathansantilli.hyperlink.http.Url;
import jonathansantilli.hyperlink.servlet.ServerTest;

import org.junit.Test;

public class PageTest extends ServerTest {

    /**
     * Test the Page to return the anchors elements within the document.
     * This test will call an internal served Web page.
     * 
     * @throws IOException
     */
    @Test
    public void testPageToReturnsAnchorsElementsFromDocument() throws IOException {
        String exampleUrl = "http://localhost:8080/static-content/example-with-one-link";
        Url url = new Url(exampleUrl);
        Page page = new Page(url);
        ArrayList<String> expectedResponse = new ArrayList<>();
        expectedResponse.add("<a href=\"http://www.example.com\"></a>");

        ArrayList<String> response = page.getAnchorsElements();

        assertEquals(expectedResponse, response);
    }
}
