package com.devamatre.theorem.adts.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 03:32:51 PM
 * @since 1.0.0
 */
public class CircularQueueTest extends AbstractQueueTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircularQueueTest.class);

    /**
     * Tests the <code>Queue</code>
     */
    @Test
    @Override
    public void buildQueue() {
        Queue<Integer> queue = new CircularQueue<>();
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(0, queue.getSize());
    }

    /**
     * Tests the <code>getSize()</code>
     */
    @Test
    @Override
    public void testGetSize() {
        Queue<Integer> queue = new CircularQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());
    }

    /**
     * Tests the <code>isEmpty()</code>
     */
    @Test
    @Override
    public void testIsEmpty() {
        Queue<Integer> queue = new CircularQueue<>();
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertTrue(queue.isEmpty());
    }

    /**
     * Tests the <code>add</code>
     *
     * @return
     */
    @Test
    @Override
    public void testAdd() {
        Queue<Integer> queue = new CircularQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());
    }

    /**
     * Tests the <code>offer(element)</code>
     */
    @Test
    @Override
    public void testOffer() {
        Queue<Integer> queue = new CircularQueue<>();
        AlgoUtils.positiveIntListGenerator(SIZE).forEach(element -> queue.offer(element));
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());
    }

    /**
     * Tests the <code>remove()</code>
     */
    @Test
    @Override
    public void testRemove() {
        Queue<Integer> queue = new CircularQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());

        // remove
        Integer result = queue.remove();
        LOGGER.debug("result:{}, queue:{}", result, queue);
        assertEquals(0, result);
        assertEquals(SIZE - 1, queue.getSize());
    }

    /**
     * Tests the <code>poll()</code>
     */
    @Test
    @Override
    public void testPoll() {
        Queue<Integer> queue = new CircularQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());

        // offer
        Integer result = queue.poll();
        LOGGER.debug("result:{}", result);
        assertEquals(0, result);
        assertEquals(SIZE - 1, queue.getSize());
    }

    /**
     * Tests the <code>element()</code>
     */
    @Test
    @Override
    public void testElement() {
        Queue<Integer> queue = new CircularQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());

        // offer
        Integer result = queue.element();
        LOGGER.debug("result:{}", result);
        assertEquals(0, result);
        assertEquals(SIZE, queue.getSize());
    }

    /**
     * Tests the <code>peek()</code>
     */
    @Test
    @Override
    public void testPeek() {
        Queue<Integer> queue = new CircularQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());

        // offer
        Integer result = queue.peek();
        LOGGER.debug("result:{}", result);
        assertEquals(0, result);
        assertEquals(SIZE, queue.getSize());
    }

    /**
     * Tests the queue.
     */
    @Override
    public void testQueue() {
        Queue<Integer> queue = QueueFactory.getQueueFor(QueueType.CIRCULAR_QUEUE);
        fillIntQueue(queue, Queue.DEFAULT_SIZE);
        LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
        assertNotNull(queue);
        assertEquals(Queue.DEFAULT_SIZE, queue.getSize());
        assertFalse(queue.isEmpty());

        LOGGER.debug("offer");
        try {
            queue.offer(10);
        } catch (IllegalStateException ex) {
            assertEquals("Overflow!", ex.getMessage());
        }
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(16, queue.getSize());

        LOGGER.debug("remove");
        assertEquals(0, queue.remove());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(15, queue.getSize());

        LOGGER.debug("poll");
        assertEquals(1, queue.poll());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(14, queue.getSize());

        LOGGER.debug("element");
        assertEquals(2, queue.element());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(14, queue.getSize());

        LOGGER.debug("peek");
        assertEquals(2, queue.peek());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(14, queue.getSize());

        int size = 5;
        LOGGER.debug("poll {} items", size);
        for (int i = 0; i < size; i++) {
            queue.poll();
        }
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(9, queue.getSize());

        LOGGER.debug("remove");
        assertEquals(7, queue.remove());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(8, queue.getSize());
    }

    /**
     * Tests the <code>CircularQueue</code> operations.
     */
    @Test
    public void testCircularQueue() {
        int size = 5;
        Queue<Integer> queue = new CircularQueue<>(size);
        LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
        assertNotNull(queue);
        assertEquals(0, queue.getSize());
        assertTrue(queue.isEmpty());

        // fill queue with elements
        fillIntQueue(queue, size);
//  LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());
        assertFalse(queue.isEmpty());
        LOGGER.debug("queue:{}", queue);

        // peek an element of the queue
        LOGGER.debug("peek:{}, queue:{}", queue.peek(), queue);
        assertEquals(size, queue.getSize());

        int removeSize = 3;
        // remove 3 elements of the queue
        for (int i = 0; i < removeSize; i++) {
            LOGGER.debug("remove:{}, queue:{}", queue.remove(), queue);
        }
        assertEquals(size - removeSize, queue.getSize());

        // add 1 element of the queue
        LOGGER.debug("add:{}, queue:{}", queue.add(1), queue);
        LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
        assertEquals(3, queue.getSize());

    }
}
