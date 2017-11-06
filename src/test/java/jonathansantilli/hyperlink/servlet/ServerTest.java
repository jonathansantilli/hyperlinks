package jonathansantilli.hyperlink.servlet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import jonathansantilli.hyperlink.app.AppConfiguration;
import jonathansantilli.hyperlink.app.Main;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

public class ServerTest {

	private HttpServer server = null;
	private WebTarget target = null;

	@Before
	public void setUp() throws Exception {
		server = Main.startServer();
		Client client = ClientBuilder.newClient();
		target = client.target(AppConfiguration.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.shutdownNow();
	}

	public WebTarget getTarget() {
		return this.target;
	}

}
