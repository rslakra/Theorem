package com.devamatre.theorem.adts.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.AlgoUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 10/9/23 7:54 PM
 */
public class HeapUtilsTest {

    private static Logger LOGGER = LoggerFactory.getLogger(HeapUtilsTest.class);
    private static int SIZE = 8;

    @Test
    public void testHeapUtils() {
        LOGGER.debug("0x7F: {}", 0x7F);
    }

    @Test
    public void testBuildMaxHeap() {
        Integer[] result = AlgoUtils.positiveIntArrayGenerator(SIZE, false);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(SIZE, result.length);
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");
        Arrays.stream(result).forEach(item -> assertTrue(item < SIZE));

        HeapUtils.buildMaxHeap(result);
        LOGGER.debug("buildMaxHeap: {}", Arrays.toString(result));
        assertEquals(Arrays.toString(result), "[7, 4, 6, 3, 0, 5, 2, 1]");
    }

    @Test
    public void testBuildMinHeap() {
        Integer[] result = AlgoUtils.positiveIntArrayGenerator(SIZE, false);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(SIZE, result.length);
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");
        Arrays.stream(result).forEach(item -> assertTrue(item < SIZE));

        HeapUtils.buildMinHeap(result);
        LOGGER.debug("buildMinHeap: {}", Arrays.toString(result));
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testHeapSortAsc() {
        Integer[] result = AlgoUtils.positiveIntArrayGenerator(SIZE, false);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(SIZE, result.length);
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");
        Arrays.stream(result).forEach(item -> assertTrue(item < SIZE));

        HeapUtils.buildMaxHeap(result);
        LOGGER.debug("buildMaxHeap: {}", Arrays.toString(result));
        assertEquals(Arrays.toString(result), "[7, 4, 6, 3, 0, 5, 2, 1]");

        HeapUtils.heapSortAsc(result);
        LOGGER.debug("heapSortAsc: {}", Arrays.toString(result));
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testHeapSortDesc() {
        Integer[] result = AlgoUtils.positiveIntArrayGenerator(SIZE, false);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(SIZE, result.length);
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");
        Arrays.stream(result).forEach(item -> assertTrue(item < SIZE));

        HeapUtils.buildMinHeap(result);
        LOGGER.debug("buildMinHeap: {}", Arrays.toString(result));
        assertEquals(Arrays.toString(result), "[0, 1, 2, 3, 4, 5, 6, 7]");

        HeapUtils.heapSortDesc(result);
        LOGGER.debug("heapSortDesc: {}", Arrays.toString(result));
        assertEquals(Arrays.toString(result), "[7, 6, 5, 4, 3, 2, 1, 0]");
    }
}
