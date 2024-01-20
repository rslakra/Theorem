package com.devamatre.theorem.adts.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/08/2023 10:03 PM
 */
public class ArrayUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayUtilsTest.class);

    /**
     * Tests the <code>fillList()</code> method.
     */
    @Test
    public void testFillList() {
        int size = 5;
        List<Integer> inputData = new ArrayList<>();
        assertNotNull(inputData);
        ArrayUtils.fillList(inputData, size, null);
        LOGGER.debug("result:{}", inputData);
        assertEquals(size, inputData.size());
    }

    /**
     * Tests the <code>initMultiDimensionArray()</code> method.
     */
    @Test
    public void testInitMultiDimensionArray() {
        Integer[][] result = ArrayUtils.initMultiDimensionArray(Integer.class, 2, 3);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        ArrayUtils.printMatrix(result);
        assertEquals(2, result.length);
        assertEquals(3, result[0].length);
    }


    /**
     * Tests the <code>initArray()</code> method.
     */
    @Test
    public void testInitOneDimensionArray() {
        Integer[] result = ArrayUtils.initArray(Integer.class, 2);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        assertEquals(2, result.length);
    }

    /**
     * Tests the <code>initArray()</code> method.
     */
    @Test
    public void testInitArray() {
        int size = 5;
        Integer[] result = ArrayUtils.initArray(size, Integer.class);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        assertEquals(size, result.length);
    }

    /**
     * Tests the <code>initArray()</code> method.
     */
    @Test
    public void testInitIntArray() {
        int size = 5;
        Integer[] result = ArrayUtils.initIntArray(size);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        assertEquals(size, result.length);
    }

    /**
     * Tests the <code>asArray()</code> method.
     */
    @Test
    public void testAsIntegerArray() {
        List<Integer> inputData = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] result = ArrayUtils.asArray(inputData, Integer.class);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        assertEquals(inputData.size(), result.length);
    }

    /**
     * Tests the <code>asArray()</code> method.
     */
    @Test
    public void testAsStringArray() {
        List<String> inputData = Arrays.asList("Amey", "Rohtash", null);
        String[] result = ArrayUtils.asArray(inputData, String.class);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        assertEquals(inputData.size(), result.length);
    }


    /**
     * Tests the <code>asList()</code> method.
     */
    @Test
    public void testAsMultiList() {
        Integer[][] inputData = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        List<List<Integer>> result = ArrayUtils.asList(inputData);
        assertNotNull(result);
        LOGGER.debug("result:{}", result);
        assertEquals(inputData.length, result.size());
    }

    /**
     * Tests the <code>toIntArray()</code> method.
     */
    @Test
    public void testToIntArray() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        LOGGER.debug("data:{}", data);
        Integer[] result = ArrayUtils.asIntArray(data);
        assertNotNull(result);
        LOGGER.debug("result:{}", Arrays.toString(result));
        assertEquals(data.size(), result.length);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findMaxValueIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{1, 4, 3, 2, 5}, 4});
        inputs.add(new Object[]{new int[]{4, 1, 3, 5, 2}, 3});
        inputs.add(new Object[]{new int[]{4, 1, 5, 2, 3}, 2});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */

    /**
     * Tests the <code>findMaxValueIndex()</code> method.
     */
    @Test(dataProvider = "findMaxValueIndexData")
    public void testFindMaxValueIndex(int[] inputData, int expected) {
        LOGGER.debug("inputData:{}", inputData);
        int result = ArrayUtils.findMaxValueIndex(ArrayUtils.asIntArray(inputData));
        assertNotNull(result);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrintMatrix() {
        ArrayUtils.printArray(new Integer[]{1, 2, 3, 4, 5});
    }

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrint2DMatrix() {
        Integer[][] data = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        ArrayUtils.printArray(data);
    }

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrintDiagonally() {
        Integer[][] data = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        ArrayUtils.printDiagonally(data);
    }

}
