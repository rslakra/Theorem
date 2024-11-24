/**
 *
 */
package com.rslakra.theorem.ratelimiter;

/**
 * @author Rohtash Lakra
 */
public abstract class RateLimiter {

    protected final int maxRequestsPerSecond;

    /**
     * @param maxRequestsPerSecond
     */
    protected RateLimiter(int maxRequestsPerSecond) {
        this.maxRequestsPerSecond = maxRequestsPerSecond;
    }

    /**
     * @return
     */
    public final int getMaxRequestsPerSecond() {
        return maxRequestsPerSecond;
    }

    protected abstract boolean tryConsume();
}
