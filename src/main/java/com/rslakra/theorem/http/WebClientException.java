package com.rslakra.theorem.http;

/**
 * @author Rohtash Lakra
 * @created 2/28/24 5:31 PM
 */
public class WebClientException extends RuntimeException {

    public WebClientException() {
        super();
    }

    /**
     * @param message
     */
    public WebClientException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public WebClientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public WebClientException(Throwable cause) {
        super(cause);
    }
}
