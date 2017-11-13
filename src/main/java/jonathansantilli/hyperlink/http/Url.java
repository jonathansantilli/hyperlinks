package jonathansantilli.hyperlink.http;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * Class responsible for establishing the HTTP connection to the Server that host the desired Web page
 * 
 * @author Jonathan Santilli
 */
public class Url {

    private String pageUrl = null;

    public Url(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * Connect to the Server through the page url sending headers as a Browser,
     * this is due mainly because some server denied the access to clients that does
     * not seems to be a browser
     * 
     * @return Connection to the server
     */
    public Connection connectToUrlAsBrowser() {
        return Jsoup.connect(this.pageUrl)
                .validateTLSCertificates(false)
                .followRedirects(true)
                .headers(getBrowserHeaders());
    }

    /**
     * Return a Map with the key-value headers
     * 
     * @return HashMap<String, String> with like browser headers
     */
    private Map<String, String> getBrowserHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("Accept-Charset", "utf-8;q=0.7,*;q=0.3");
        headers.put("Accept-Language", "en-US,en;q=0.8");
        headers.put("Connection", "keep-alive");
        headers.put("User-Agent", 
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko)"
                        + " Chrome/42.0.2311.135 Safari/537.36");

        return headers;
    }	
}
