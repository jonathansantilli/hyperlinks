package jonathansantilli.hyperlink.html;

import java.io.IOException;
import java.util.ArrayList;

import jonathansantilli.hyperlink.http.Url;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Class responsible for managing/parsing the HTML Document
 * 
 * @author Jonathan Santilli
 */
public class Page {

    private Url url = null;

    public Page(final Url url) {
        this.url = url;
    }

    /**
     * Get the anchors elements present on the HTML document behind the provided <code>Url</code>
     * 
     * @return <code>ArrayList<String></code> with the anchors links
     * @throws IOException
     */
    public ArrayList<String> getAnchorsElements() throws IOException {
        Elements anchorsElements = this.getAnchorsElementsFromDocument();
        ArrayList<String> anchors = new ArrayList<String>();
        
        anchorsElements.forEach(anchor -> anchors.add(anchor.html("").toString()));

        return anchors;
    }

    /**
     * Internal private method that return the HTML document obtained from the provided <code>Url</code>
     * 
     * @return <code>Document</code>, object with HTML elements
     * @throws IOException
     */
    private Document getDocument() throws IOException {
        return this.url.connectToUrlAsBrowser().get();
    }

    /**
     * Select and returns the anchors within the <code>Document</code>
     * 
     * @return Elements, the <a> (anchors) elements presents in the <code>Document</code>
     * @throws IOException
     */
    private Elements getAnchorsElementsFromDocument() throws IOException {
        Document doc = this.getDocument();
        return doc.select("a");
    } 
}
