package com.devamatre.theorem.adts.heap;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 8:03 PM
 */
public class MaxHeapTest extends HeapTest {

    private static Logger LOGGER = LoggerFactory.getLogger(MaxHeapTest.class);

    @Test
    public void testBuildMaxHeap() {
        List<Integer> inputData = positiveIntListGenerator();
        MaxHeap<Integer> maxHeap = new MaxHeap<>(inputData);
        LOGGER.debug("maxHeap:{}", maxHeap);
        assertEquals(Arrays.toString(maxHeap.getQueue()), "[7, 4, 6, 3, 0, 5, 2, 1]");
    }

    @Test
    public void testSortHeap() {
        List<Integer> inputData = positiveIntListGenerator();
        MaxHeap<Integer> maxHeap = new MaxHeap<>(inputData);
        LOGGER.debug("maxHeap: {}", maxHeap);
        assertEquals(Arrays.toString(maxHeap.getQueue()), "[7, 4, 6, 3, 0, 5, 2, 1]");

        maxHeap.heapSortAsc();
        LOGGER.debug("sortHeap: {}", Arrays.toString(maxHeap.getQueue()));
        assertEquals(Arrays.toString(maxHeap.getQueue()), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }
}
