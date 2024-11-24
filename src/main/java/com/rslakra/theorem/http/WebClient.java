/**
 *
 */
package com.rslakra.theorem.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * <url>https://www.iana.org/assignments/http-methods/http-methods.xhtml</url>
 * <url>https://www.baeldung.com/java-9-http-client</url>
 *
 * @author Rohtash Lakra
 * @created 2/28/20 4:43 PM
 */
public enum WebClient {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClient.class);
    private static final String HTTPS = "https://";

    private int connectionTimeout;
    private HttpRequest httpRequest;
    private HttpClient httpClient;

    /**
     * @return
     */
    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    /**
     * @return
     */
    public HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Builds the request with the provided details.
     *
     * @param url
     * @param httpMethod
     * @param payload
     * @throws MalformedURLException
     */
    private void buildRequest(String url, HttpMethod httpMethod, Object payload) {
        LOGGER.debug("+buildRequest({}, {})", url, httpMethod);
        if (!url.startsWith(HTTPS)) {
            url = HTTPS + url;
        }

        // default connection timeout
        connectionTimeout = 20;
        switch (httpMethod) {
            case CONNECT:
                break;
            case DELETE:
                break;
            case GET:
                httpRequest = HttpRequest.newBuilder(URI.create(url)).GET().build();
                break;
            case HEAD:
                break;
            case OPTIONS:
                break;
            case PATCH:
                break;
            case POST:
                break;
            case PUT:
                break;
            case TRACE:
                break;
        }

        // initialize client
        httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(connectionTimeout))
            .proxy(ProxySelector.getDefault())
            // .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
            // .authenticator(Authenticator.getDefault())
            // .authenticator(new PasswordAuthenticator("username", "password"))
            .build();
        LOGGER.debug("-buildRequest(), httpRequest:{}, httpClient:{}", httpRequest, httpClient);
    }

    /**
     * New HttpClient provides two possibilities for sending a request to a server:
     * <p>
     * send(…) – synchronously (blocks until the response comes)
     *
     * @param url
     * @param httpMethod
     * @return
     * @throws WebClientException
     */
    private String execute(String url, HttpMethod httpMethod, Object payload) throws WebClientException {
        LOGGER.debug("+execute({}, {}, {})", url, httpMethod, payload);
        try {
            // build request and init httpClient
            buildRequest(url, httpMethod, null);
            // execute request and get response
            HttpResponse<String> response = getHttpClient()
                .send(getHttpRequest(), HttpResponse.BodyHandlers.ofString());
            LOGGER.debug("statusCode:{}, response:{}", response.statusCode(), response);
            String result = response.body();
            LOGGER.debug("result:{}", result);
            LOGGER.debug("-execute(), result:{}", result);
            return result;
        } catch (IOException | InterruptedException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new WebClientException(ex);
        }
    }

    /**
     * @param url
     * @param httpMethod
     * @return
     * @throws WebClientException
     */
    private String execute(String url, HttpMethod httpMethod) throws WebClientException {
        return execute(url, httpMethod, null);
    }

    /**
     * HttpClient sends a request to a server:
     * <p>
     * sendAsync(…) – asynchronously (does not wait for the response, non-blocking)
     *
     * @param url
     * @param httpMethod
     * @param payload
     * @return
     * @throws WebClientException
     */
    private String executeAsync(String url, HttpMethod httpMethod, Object payload) throws WebClientException {
        return null;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static String get(String url) throws WebClientException {
        return INSTANCE.execute(url, HttpMethod.GET);
    }

}
