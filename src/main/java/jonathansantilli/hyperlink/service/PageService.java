package jonathansantilli.hyperlink.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import jonathansantilli.hyperlink.exception.UnavailableContentException;
import jonathansantilli.hyperlink.html.Page;
import jonathansantilli.hyperlink.http.Url;

import org.apache.commons.io.IOUtils;

/**
 * Class facade to get the links from the HTML Web page
 * 
 * @author Jonathan Santilli
 */
public class PageService {

    /**
     * Get the links presents within the HTML Web page
     * 
     * @param pageUrl String with the url page
     * @return ArrayList<String> with the links (<a>)
     * @throws IOException
     */
    public static List<String> getHyperLinks(String pageUrl) throws IOException {
        Url url = new Url(pageUrl);
        Page page = new Page(url);

        return page.getAnchorsElements();
    }

    /**
     * Return the text HTML, this method is for local test purpose.
     * The method read the local HTML file to be served as String
     * 
     * @param pageName String page name, local resource page
     * @return String, the HTML text
     * @throws UnavailableContentException
     */
    public String getTextFromHTMLDocument(String pageName) throws UnavailableContentException {
        InputStream is = PageService.class.getClassLoader().getResourceAsStream(pageName);
        String content = "";
        try {
            content = IOUtils.toString(is, "UTF-8");
        } catch (IOException e) {
            throw new UnavailableContentException(e);
        } finally {
            IOUtils.closeQuietly(is);
        }

        return content;
    }
}
