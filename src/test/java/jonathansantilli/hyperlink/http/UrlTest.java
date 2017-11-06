package jonathansantilli.hyperlink.http;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.jsoup.Connection;
import org.junit.Test;

public class UrlTest {

    /**
     * Test the Url to return a valid Connection class when establishing the connection
     */
    @Test
    public void testTheUrlConnectAsBrowserAndCheckTheConnectionInstance() {
        String exampleUrl = "http://example.com";
        Url url = new Url(exampleUrl);

        Connection connection = url.connectToUrlAsBrowser();

        assertThat(connection, instanceOf(Connection.class));
    }
}
