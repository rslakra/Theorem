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

    /**
     * @param firstElementEmpty
     * @return
     */
    public static Integer[] positiveIntListGenerator(boolean firstElementEmpty) {
        Integer[] inputData = AlgoUtils.positiveIntArrayGenerator(SIZE, firstElementEmpty);
        LOGGER.debug("inputData: {}", Arrays.toString(inputData));
        assertEquals(SIZE, inputData.length);
        assertEquals(Arrays.toString(inputData), "[0, 1, 2, 3, 4, 5, 6, 7]");
        Arrays.stream(inputData).forEach(item -> assertTrue(item < SIZE));
        return inputData;
    }

    @Test
    public void testBuildMaxHeap() {
        Integer[] inputData = positiveIntListGenerator(false);
        HeapUtils.buildMaxHeap(inputData);
        LOGGER.debug("buildMaxHeap: {}", Arrays.toString(inputData));
        assertEquals(Arrays.toString(inputData), "[7, 4, 6, 3, 0, 5, 2, 1]");
    }

    @Test
    public void testBuildMinHeap() {
        Integer[] inputData = positiveIntListGenerator(false);
        HeapUtils.buildMinHeap(inputData);
        LOGGER.debug("buildMinHeap: {}", Arrays.toString(inputData));
        assertEquals(Arrays.toString(inputData), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testHeapSortAsc() {
        Integer[] inputData = positiveIntListGenerator(false);
        HeapUtils.buildMaxHeap(inputData);
        LOGGER.debug("buildMaxHeap: {}", Arrays.toString(inputData));
        assertEquals(Arrays.toString(inputData), "[7, 4, 6, 3, 0, 5, 2, 1]");

        HeapUtils.heapSortAsc(inputData);
        LOGGER.debug("heapSortAsc: {}", Arrays.toString(inputData));
        assertEquals(Arrays.toString(inputData), "[0, 1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void testHeapSortDesc() {
        Integer[] inputData = positiveIntListGenerator(false);
        HeapUtils.buildMinHeap(inputData);
        LOGGER.debug("buildMinHeap: {}", Arrays.toString(inputData));
        assertEquals(Arrays.toString(inputData), "[0, 1, 2, 3, 4, 5, 6, 7]");

        HeapUtils.heapSortDesc(inputData);
        LOGGER.debug("heapSortDesc: {}", Arrays.toString(inputData));
        assertEquals(Arrays.toString(inputData), "[7, 6, 5, 4, 3, 2, 1, 0]");
    }
}
