package com.devamatre.theorem.adts.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.adts.heap.HeapTest;
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

    private static Logger LOGGER = LoggerFactory.getLogger(PriorityQueueTest.class);

    @Test
    public void testBuildPriorityQueue() {
        List<Integer> inputData = Arrays.asList(6, 7, 4, 5, 3, 2, 0, 1);
        LOGGER.debug("inputData: {}", inputData);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        // test peek
        assertEquals(0, priorityQueue.peek());
        // test add
//        assertEquals(true, priorityQueue.add(9));
    }

    @Test
    public void testMaxPriorityQueue() {
        List<Integer> inputData = Arrays.asList(6, 7, 4, 5, 3, 2, 0, 1);
        LOGGER.debug("inputData: {}", inputData);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        priorityQueue.addAll(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
//        assertEquals(7, priorityQueue.peek());
    }

    @Test
    public void testMinPriorityQueue() {
        List<Integer> inputData = Arrays.asList(6, 7, 4, 5, 3, 2, 0, 1);
        LOGGER.debug("inputData: {}", inputData);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(inputData);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        assertEquals(0, priorityQueue.peek());
    }

}
