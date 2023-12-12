package com.devamatre.theorem.adts.queue;

import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 03:32:51 PM
 * @since 1.0.0
 */
public abstract class AbstractQueueTest {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractQueueTest.class);

    protected static int SIZE = 5;

    /**
     * @param queue
     * @param size
     */
    public static void fillIntQueue(Queue<Integer> queue, int size) {
        AlgoUtils.positiveIntListGenerator(size).forEach(element -> queue.add(element));
    }

    /**
     * Tests the <code>Queue</code>
     */
    public abstract void buildQueue();

    /**
     * Tests the <code>getSize()</code>
     */
    public abstract void testGetSize();

    /**
     * Tests the <code>isEmpty()</code>
     */
    public abstract void testIsEmpty();

    /**
     * Tests the <code>add</code>
     *
     * @return
     */
    public abstract void testAdd();

    /**
     * Tests the <code>offer(element)</code>
     */
    public abstract void testOffer();

    /**
     * Tests the <code>remove()</code>
     */
    public abstract void testRemove();

    /**
     * Tests the <code>poll()</code>
     */
    public abstract void testPoll();

    /**
     * Tests the <code>element()</code>
     */
    public abstract void testElement();

    /**
     * Tests the <code>peek()</code>
     */
    public abstract void testPeek();

    /**
     * Tests the queue.
     */
    public abstract void testQueue();

}
