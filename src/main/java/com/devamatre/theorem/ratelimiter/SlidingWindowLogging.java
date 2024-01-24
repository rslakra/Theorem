/**
 *
 */
package com.devamatre.theorem.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 */
public class SlidingWindowLogging extends RateLimiter {

    private final Queue<Long> queue = new LinkedList<>();

    /**
     * @param maxRequestsPerSeccond
     */
    protected SlidingWindowLogging(int maxRequestsPerSeccond) {
        super(maxRequestsPerSeccond);
    }

    @Override
    public boolean tryConsume() {
        long curTime = System.currentTimeMillis();
        long boundary = curTime - 1000;
        synchronized (queue) {
            while (!queue.isEmpty() && queue.element() <= boundary) {
                queue.poll();
            }
            queue.add(curTime);
            return queue.size() <= getMaxRequestsPerSecond();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    }

}
