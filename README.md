## Hyperlinks finder

*Hyperlinks finder* is a simple Web link scraper.

The Java-based REST service provide just one end-point, */links*. 

The end-point takes as input a single HTTP url and find all the hyper links (anchors) present on the page identified by the input url. **The url should be encode**

*Hyperlinks finder* use *Jersey* as JAX-RS layer provider and *Grizzly* as HTTP server

## Quickstart

This project assume you have [Apache Maven](http://maven.apache.org/) and [Java](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) installed in your system.

To start the server, run:

	mvn compile exec:java

The */links* end-point is expecting an encode URL as parameter, like:

	curl http://localhost:8080/links/http%3A%2F%2Flocalhost:8080%2Fstatic-content%2Fexample-with-one-link
	
The previous example is completely functional. After executing the previous call you should get a response like:

	[
		"<a href="http://www.example.com"></a>"
	]

## Testing

To run the tests, execute:

	mvn clean test
