package com.rslakra.theorem.adts.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 8:17 PM
 */
public class MinHeapTest extends HeapTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinHeapTest.class);

    @Test
    public void testBuildHeap() {
        List<Integer> inputData = positiveIntListGenerator();
        MinHeap<Integer> minHeap = new MinHeap<>(inputData);
        LOGGER.debug("minHeap: {}", minHeap);
        assertEquals(Arrays.toString(minHeap.getQueue()), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testSortHeap() {
        List<Integer> inputData = positiveIntListGenerator();
        MinHeap<Integer> minHeap = new MinHeap<>(inputData);
        LOGGER.debug("minHeap: {}", minHeap);
        assertEquals(Arrays.toString(minHeap.getQueue()), "[0, 1, 2, 3, 4, 5, 6, 7]");

        minHeap.heapSortDesc();
        LOGGER.debug("sortHeap: {}", Arrays.toString(minHeap.getQueue()));
        assertEquals(Arrays.toString(minHeap.getQueue()), "[7, 6, 5, 4, 3, 2, 1, 0]");
    }
}
