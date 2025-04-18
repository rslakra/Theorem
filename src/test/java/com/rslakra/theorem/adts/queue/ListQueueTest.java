package com.rslakra.theorem.adts.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rslakra.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 03:32:51 PM
 * @since 1.0.0
 */
public class ListQueueTest extends AbstractQueueTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListQueueTest.class);

    /**
     * Tests the <code>Queue</code>
     */
    @Test
    @Override
    public void buildQueue() {
        Queue<Integer> queue = new ListQueue<>();
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
        Queue<Integer> queue = new ListQueue<>(SIZE);
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
        Queue<Integer> queue = new ListQueue<>();
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
        Queue<Integer> queue = new ListQueue<>(SIZE);
        fillIntQueue(queue, SIZE);
        // add 5 more items to auto increase the size.
        AlgoUtils.randomIntListGenerator(SIZE, 100).forEach(item -> queue.add(item));
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(10, queue.getSize());
    }

    /**
     * Tests the <code>offer(element)</code>
     */
    @Test
    @Override
    public void testOffer() {
        Queue<Integer> queue = new ListQueue<>();
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
        Queue<Integer> queue = new ListQueue<>();
        fillIntQueue(queue, SIZE);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(SIZE, queue.getSize());

        // offer
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
        Queue<Integer> queue = new ListQueue<>();
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
        Queue<Integer> queue = new ListQueue<>();
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
        Queue<Integer> queue = new ListQueue<>();
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
        Queue<Integer> queue = QueueFactory.getQueueFor(QueueType.ARRAY_QUEUE);
        // queue = QueueFactory.getQueueFor(QueueType.LIST_QUEUE);
        // queue = QueueFactory.getQueueFor(QueueType.LINKED_LIST_QUEUE);
        fillIntQueue(queue, 16);
        assertNotNull(queue);
        LOGGER.debug(queue.toString());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(16, queue.getSize());
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
}