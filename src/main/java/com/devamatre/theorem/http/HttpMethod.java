/**
 *
 */
package com.devamatre.theorem.http;

import java.util.Arrays;

/**
 * There are nine HTTP methods explicitly defined by the Hypertext Transfer Protocol specification. Actually, there are
 * 10 if you include the PRI connection preface method defined in the HTTP/2 specification released in May 2015.
 *
 * <url>https://www.iana.org/assignments/http-methods/http-methods.xhtml</url>
 * <url>https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods</url>
 *
 * @author Rohtash Lakra
 * @created 2/28/20 4:43 PM
 */
public enum HttpMethod {

    /*
     * @since 1.1
     * The connect operation is used to create a connection with a server-side resource. The most common target of the
     * HTTP method CONNECT is a proxy server, which a client must access to tunnel out of the local network.
     *
     * RESTful API designers rarely interact with the CONNECT HTTP request method.
     */
    CONNECT,

    /*
     * @since 1.1
     * The HTTP DELETE method is self-explanatory. After execution, the resource a DELETE operation points to is removed from the server.
     *
     * As with PUT operations, the HTTP DELETE method is idempotent and unsafe.
     */
    DELETE,

    /*
     * @since 1.0
     * The GET is most commonly used HTTP method and the purpose of this method is to simply retrieve data from the server.
     *
     * The GET method is used to request any of the following resources:
     * A webpage or HTML file.
     * An image or video.
     * A JSON document.
     * A CSS file or JavaScript file.
     * An XML file.
     *
     * The GET request method is said to be a safe operation, which means it should not change the state of any resource on the server.
     */
    GET,

    /*
     * @since 1.0
     * The HTTP HEAD method simply returns metadata about a resource on the server. it returns all the headers
     * associated with a resource at a given URL, but does not actually return the resource.
     *
     * The HTTP HEAD method is commonly used to check the following conditions:
     *
     * The size of a resource on the server.
     * If a resource exists on the server or not.
     * The last-modified date of a resource.
     * Validity of a cached resource on the server.
     *
     *
     * The following example shows sample data returned from a HEAD request:
     *
     * <pre>
     *  HTTP/1.1 200 OK
     *  Date: Fri, 19 Aug 2023 12:00:00 GMT
     *  Content-Type: text/html
     *  Content-Length: 1234
     *  Last-Modified: Thu, 18 Aug 2023 15:30:00 GMT
     * </pre>
     */
    HEAD,

    /*
     * @since 1.1
     *
     * The server does not have to support every HTTP method for every resource it manages.
     *
     * Some resources support the PUT and POST operations. Other resources only support GET operations.
     *
     * The HTTP OPTIONS method returns a listing of which HTTP methods are supported and allowed.
     *
     * The following is a sample response to an HTTP OPTIONS method call to a server:
     *
     * <pre>
     *  OPTIONS /example/resource HTTP/1.1
     *  Host: www.example.com HTTP/1.1 200 OK
     *  Allow: GET, POST, DELETE, HEAD, OPTIONS
     *  Access-Control-Allow-Origin: *
     *  Access-Control-Allow-Methods: GET, POST, DELETE, OPTIONS
     *  Access-Control-Allow-Headers: Authorization, Content-Type
     * </pre>
     */
    OPTIONS,

    /*
     * @since 1.1
     * Sometimes object representations get very large. The requirement for a PUT operation to always send a complete
     * resource representation to the server is wasteful if only a small change is needed to a large resource.
     *
     * The PATH HTTP method, added to the Hypertext Transfer Protocol independently as part of RFC 5789, allows for
     * updates of existing resources. It is significantly more efficient, for example, to send a small payload rather
     * than a complete resource representation to the server.
     *
     * PATCH, the newest of the five, is still rarely used, although it is increasingly incorporated in new APIs.
     */
    PATCH,

    /*
     * @since 1.0
     * POST HTTP request method sends data to the server for processing.
     *
     * The data sent to the server is typically in the following form:
     *
     * Input fields from online forms.
     * XML or JSON data.
     * Text data from query parameters.
     */
    POST,

    /*
     * @since 1.1
     * The HTTP PUT method is used to completely replace a resource identified with a given URL.
     *
     * The HTTP PUT request method includes two rules:
     * A PUT operation always includes a payload that describes a completely new resource definition to be saved by the server.
     * The PUT operation uses the exact URL of the target resource.
     *
     * If a resource exists at the URL provided by a PUT operation, the resource’s representation is completely replaced.
     * If a resource does not exist at that URL, a new resource is created.
     *
     * The payload of a PUT operation can be anything that the server understands, although JSON and XML are the most
     * common data exchange formats for RESTful webservices and microservices.
     *
     * Idempotent and safe
     * PUT operations are said to be unsafe but idempotent.
     *
     * They are not safe because they change the state of a resource on the server.
     * They are idempotent because multiple invocations leave the server in the same state.
     *
     * For example, if a PUT operation sets the status of a flight to ontime, that operation could be invoked 100 times
     * and the status would always end up being ontime. That’s the idea behind idempotence.
     *
     * In contrast to PUT, POST operations are not idempotent.
     */
    PUT,

    /*
     * @since 1.1
     *
     * The TRACE HTTP method is used for diagnostics, debugging and troubleshooting. It simply returns a diagnostic
     * trace that logs data from the request-response cycle.
     *
     * The content of a trace is often just an echo back from the server of the various request headers that the client sent.
     */
    TRACE;

    /**
     * Returns the <code>HttpMethod</code> for the provided <code>methodName</code>.
     *
     * @param methodName
     * @return
     */
    public static HttpMethod ofString(String methodName) {
        return Arrays.stream(values())
            .filter(httpMethod -> httpMethod.name().equalsIgnoreCase(methodName))
            .findFirst()
            .orElse(null);
    }
}
