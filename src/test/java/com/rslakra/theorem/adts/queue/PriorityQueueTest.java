package com.rslakra.theorem.adts.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rslakra.theorem.adts.heap.HeapTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/17/23 4:58 PM
 */
public class PriorityQueueTest extends HeapTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriorityQueueTest.class);

    @Test
    public void testBuildPriorityQueue() {
        LOGGER.debug("testBuildPriorityQueue()");
        List<Integer> inputData = Arrays.asList(6, 7, 4, 5, 3, 2, 0, 1);
        LOGGER.debug("inputData: {}", inputData);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        // test peek
        assertEquals(0, priorityQueue.peek());
        // test add
        //  assertEquals(true, priorityQueue.add(9));
    }

    @Test
    public void testMaxPriorityQueue() {
        LOGGER.debug("testMaxPriorityQueue()");
        List<Integer> inputData = Arrays.asList(6, 7, 4, 5, 3, 2, 0, 1);
        LOGGER.debug("inputData: {}", inputData);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        priorityQueue.addAll(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        //  assertEquals(7, priorityQueue.peek());
    }

    @Test
    public void testMinPriorityQueue() {
        LOGGER.debug("testMinPriorityQueue()");
        List<Integer> inputData = Arrays.asList(6, 7, 4, 5, 3, 2, 0, 1);
        LOGGER.debug("inputData: {}", inputData);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        assertEquals(0, priorityQueue.peek());
    }

    @Test
    public void testJavaPriorityQueue() {
        LOGGER.debug("testJavaPriorityQueue()");
        List<String> inputData = Arrays.asList("ram", "arm", "cat", "dog");
        LOGGER.debug("inputData: {}", inputData);
        java.util.PriorityQueue<String> priorityQueue = new java.util.PriorityQueue<>(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        // test peek
        assertEquals(4, priorityQueue.size());
        assertEquals("arm", priorityQueue.peek());
        assertEquals("arm", priorityQueue.poll());

        // remove test items.
        while (!priorityQueue.isEmpty()) {
            LOGGER.debug(priorityQueue.poll());
        }
    }

}
