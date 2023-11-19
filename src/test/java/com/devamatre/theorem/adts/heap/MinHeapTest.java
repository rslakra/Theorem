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
 * @created 10/11/23 8:17 PM
 */
public class MinHeapTest {

    private static Logger LOGGER = LoggerFactory.getLogger(MinHeapTest.class);
    private static int SIZE = 8;

    @Test
    public void testBuildHeap() {
        List<Integer> result = AlgoUtils.positiveIntListGenerator(SIZE);
        LOGGER.debug("result: {}", result);
        assertEquals(SIZE, result.size());
        assertEquals(result, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        result.forEach(item -> assertTrue(item < SIZE));

//        MinHeap<Integer> minHeap = new MinHeap<>(result);
//        LOGGER.debug("minHeap: {}", minHeap);
//        assertEquals(Arrays.toString(minHeap.getData()), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testSortHeap() {
        List<Integer> result = AlgoUtils.positiveIntListGenerator(SIZE);
        LOGGER.debug("result: {}", result);
        assertEquals(SIZE, result.size());
        assertEquals(result, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        result.forEach(item -> assertTrue(item < SIZE));

//        MinHeap<Integer> minHeap = new MinHeap<>(result);
//        LOGGER.debug("minHeap: {}", minHeap);
//        assertEquals(Arrays.toString(minHeap.getData()), "[0, 1, 2, 3, 4, 5, 6, 7]");
//
//        minHeap.sort();
//        LOGGER.debug("sortHeap: {}", Arrays.toString(minHeap.getData()));
//        assertEquals(Arrays.toString(minHeap.getData()), "[7, 6, 5, 4, 3, 2, 1, 0]");
    }
}
