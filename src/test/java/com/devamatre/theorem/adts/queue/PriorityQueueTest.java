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
        List<Integer> result = positiveIntListGenerator();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(result);
        LOGGER.debug("priorityQueue: {}", priorityQueue);
        assertEquals(Arrays.toString(priorityQueue.getData()), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testMaxPriorityQueue() {
        List<Integer> result = positiveIntListGenerator();
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(result);
        LOGGER.debug("maxPriorityQueue: {}", maxPriorityQueue);
        assertEquals(Arrays.toString(maxPriorityQueue.getData()), "[7, 4, 6, 3, 0, 5, 2, 1]");

        maxPriorityQueue.sort();
        LOGGER.debug("sortHeap: {}", Arrays.toString(maxPriorityQueue.getData()));
        assertEquals(Arrays.toString(maxPriorityQueue.getData()), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testMinPriorityQueue() {
        List<Integer> result = positiveIntListGenerator();
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>(result);
        LOGGER.debug("minPriorityQueue: {}", minPriorityQueue);
        assertEquals(Arrays.toString(minPriorityQueue.getData()), "[0, 1, 2, 3, 4, 5, 6, 7]");

        minPriorityQueue.sort();
        LOGGER.debug("sortHeap: {}", Arrays.toString(minPriorityQueue.getData()));
        assertEquals(Arrays.toString(minPriorityQueue.getData()), "[7, 6, 5, 4, 3, 2, 1, 0]");
    }

}
