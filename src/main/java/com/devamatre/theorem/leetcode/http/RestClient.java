/**
 *
 */
package com.devamatre.theorem.leetcode.http;

import java.net.HttpURLConnection;

/**
 * @author Rohtash Lakra
 */
public final class RestClient {

    public enum HttpMethod {
        GET, HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE;
    }

    /**
     * connection
     */
    private HttpURLConnection connection;

    public RestClient() {
    }

    /**
     * @param urlString
     * @return
     */
    public byte[] execute(String urlString) {
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
