/**
 *
 */
package com.rslakra.theorem.ratelimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <url>https://github.com/hechaoli/simple-rate-limiters</url>
 *
 * @author Rohtash Lakra
 */
public class RateLimiterTest {

    //    @Test
    public void testRateLimiter() throws InterruptedException {
        // new a BucketRateLimiter here
        RateLimiter rateLimiter = new SlidingWindowLogging(5);

        final Thread requestThread = new Thread(() -> {
            sendRequest(rateLimiter, 10, 1);
            sendRequest(rateLimiter, 20, 2);
            sendRequest(rateLimiter, 50, 5);
            sendRequest(rateLimiter, 100, 10);
            sendRequest(rateLimiter, 200, 20);
            sendRequest(rateLimiter, 250, 25);
            sendRequest(rateLimiter, 500, 50);
            sendRequest(rateLimiter, 1000, 100);
        });

        requestThread.start();
        requestThread.join();
    }

    /**
     * @param rateLimiter
     * @param maxRequestsPerSeccond
     */
    private static void sendRequest(RateLimiter rateLimiter, int totalCount, int maxRequestsPerSeccond) {
        long startTime = System.currentTimeMillis();
        CountDownLatch doneSignal = new CountDownLatch(totalCount);
        for (int i = 0; i < totalCount; i++) {
            try {
                new Thread(() -> {
                    while (!rateLimiter.tryConsume()) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    doneSignal.countDown();
                }).start();

                TimeUnit.MILLISECONDS.sleep(1000 / maxRequestsPerSeccond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double duration = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalCount + " requests processed in " + duration + " seconds. " + "Rate: "
                           + (double) totalCount / duration + " per second");
    }
}
