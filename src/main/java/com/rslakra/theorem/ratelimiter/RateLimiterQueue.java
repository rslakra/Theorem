/**
 *
 */
package com.rslakra.theorem.ratelimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 */
public class RateLimiterQueue {

    public static final int REQUEST_LIMIT = 5;
    public static final Long TIME_LIMIT = 1000L;

    private class HitCounter {

        private int maxRequestsPerSeconds;
        private Queue<Long> queue;

        public HitCounter(int maxRequestsPerSeconds) {
            this.maxRequestsPerSeconds = maxRequestsPerSeconds;
            queue = new LinkedList<>();
        }

        /**
         * @param timestamp
         * @return
         */
        public boolean hit(long timestamp) {
            /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT */
            while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) {
                queue.poll();
            }

            if (queue.size() < maxRequestsPerSeconds) {
                queue.add(timestamp);
                return true;
            }

            return false;
        }
    }

    private HashMap<String, HitCounter> mapClientHits = new HashMap<>();

    /**
     * @param clientId
     * @return
     */
    public boolean isConsumed(String clientId) {
        long currentTime = System.currentTimeMillis();
        HitCounter hitCounter = null;
        if (mapClientHits.containsKey(clientId)) {
            hitCounter = mapClientHits.get(clientId);
            // return hitCounter.hit(currentTime);
        } else {
            hitCounter = new HitCounter(REQUEST_LIMIT);
            // return true;
        }
        return hitCounter.hit(currentTime);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        RateLimiterQueue rateLimiter = new RateLimiterQueue();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    System.out.println(rateLimiter.isConsumed("rslakra"));
                }
            }.start();

        }
    }

}
