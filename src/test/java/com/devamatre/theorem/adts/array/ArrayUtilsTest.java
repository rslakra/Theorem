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
     * Tests the <code>toIntArray()</code> method.
     */
    @Test
    public void testToIntArray() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        LOGGER.debug("data:{}", data);
        Integer[] result = ArrayUtils.toIntArray(data);
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
    public Iterator<Object[]> findMaxIndexData() {
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
     * Tests the <code>findMaxIndex()</code> method.
     */
    @Test(dataProvider = "findMaxIndexData")
    public void testFindMaxIndex(Integer[] inputData, int expected) {
        LOGGER.debug("inputData:{}", inputData);
        int result = ArrayUtils.findMaxIndex(inputData);
        assertNotNull(result);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }


    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrintMatrix() {
        ArrayUtils.printMatrix(new Integer[]{1, 2, 3, 4, 5});
    }

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrint2DMatrix() {
        Integer[][] data = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        ArrayUtils.printMatrix(data);
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
