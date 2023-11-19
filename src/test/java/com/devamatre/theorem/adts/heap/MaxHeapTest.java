package com.devamatre.theorem.adts.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.AlgoUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 8:03 PM
 */
public class MaxHeapTest {

    private static Logger LOGGER = LoggerFactory.getLogger(MaxHeapTest.class);
    private static int SIZE = 8;

    @Test
    public void testBuildMaxHeap() {
        List<Integer> result = AlgoUtils.positiveIntListGenerator(SIZE);
        LOGGER.debug("result: {}", result);
        assertEquals(SIZE, result.size());
        assertEquals(result, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        result.forEach(item -> assertTrue(item < SIZE));

//        MaxHeap<Integer> maxHeap = new MaxHeap<>(result);
//        LOGGER.debug("maxHeap:{}", maxHeap);
//        assertEquals(Arrays.toString(maxHeap.getData()), "[7, 4, 6, 3, 0, 5, 2, 1]");
    }

    @Test
    public void testSortHeap() {
        List<Integer> result = AlgoUtils.positiveIntListGenerator(SIZE);
        LOGGER.debug("result: {}", result);
        assertEquals(SIZE, result.size());
        assertEquals(result, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        result.forEach(item -> assertTrue(item < SIZE));

//        MaxHeap<Integer> maxHeap = new MaxHeap<>(result);
//        LOGGER.debug("buildHeap: {}", maxHeap);
//        assertEquals(Arrays.toString(maxHeap.getData()), "[7, 4, 6, 3, 0, 5, 2, 1]");
//
//        maxHeap.sort();
//        LOGGER.debug("sortHeap: {}", Arrays.toString(maxHeap.getData()));
//        assertEquals(Arrays.toString(maxHeap.getData()), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }
}
