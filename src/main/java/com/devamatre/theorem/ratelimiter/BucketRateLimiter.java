/**
 *
 */
package com.devamatre.theorem.ratelimiter;

/**
 * @author Rohtash Lakra
 */
public class BucketRateLimiter extends RateLimiter {

    private long capacity;

    private long lastRefillTimeStamp;

    private long refillCountPerSecond;

    private long availableTokens;

    public BucketRateLimiter(long capacity, long windowTimeInSeconds) {
        super(0);
        this.capacity = capacity;
        // this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStamp = System.currentTimeMillis();
        refillCountPerSecond = capacity / windowTimeInSeconds;
        availableTokens = 0;
    }

    /**
     * @param maxRequestsPerSecond
     */
    public BucketRateLimiter(int maxRequestsPerSecond) {
        super(maxRequestsPerSecond);
    }

    /**
     * @return
     */
    public long getAvailableTokens() {
        return this.availableTokens;
    }

    /**
     * @return
     */
    public boolean tryConsume() {
        refill();

        if (availableTokens > 0) {
            --availableTokens;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    private void refill() {
        long now = System.currentTimeMillis();
        if (now > lastRefillTimeStamp) {
            long elapsedTime = now - lastRefillTimeStamp;
            // refill tokens for this duration
            long tokensToBeAdded = (elapsedTime / 1000) * refillCountPerSecond;
            if (tokensToBeAdded > 0) {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStamp = now;

            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BucketRateLimiter rateLimiter = new BucketRateLimiter(5, 60000);
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(rateLimiter.tryConsume());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
