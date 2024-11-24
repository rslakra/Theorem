package com.rslakra.theorem.algos.lang;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * @since 01/02/2024 8:14 AM
 */
public class FibonacciSeriesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciSeriesTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> fibSeriesData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, new int[]{0}});
        input.add(new Object[]{1, new int[]{0, 1}});
        input.add(new Object[]{2, new int[]{0, 1, 1}});
        input.add(new Object[]{3, new int[]{0, 1, 1, 2}});
        input.add(new Object[]{4, new int[]{0, 1, 1, 2, 3}});
        input.add(new Object[]{5, new int[]{0, 1, 1, 2, 3, 5}});
        input.add(new Object[]{6, new int[]{0, 1, 1, 2, 3, 5, 8}});
        input.add(new Object[]{7, new int[]{0, 1, 1, 2, 3, 5, 8, 13}});
        input.add(new Object[]{8, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21}});
        input.add(new Object[]{9, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}});
        input.add(new Object[]{10, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55}});

        return input.iterator();
    }

    /**
     * Tests the <code>printFibonacci()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "fibSeriesData")
    public void testFibSeries(int number, int[] expected) {
        int result = FibonacciSeries.fibSeries(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected[expected.length - 1], result);
    }

    /**
     * Tests the <code>printFibonacci()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "fibSeriesData")
    public void testPrintFibonacci(int number, int[] expected) {
        FibonacciSeries.printFibonacci(number);
    }


    /**
     * Tests the <code>printFibonacci()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "fibSeriesData")
    public void testPrintFibonacciRecursively(int number, int[] expected) {
        FibonacciSeries.printFibonacciRecursively(number);
    }

    /**
     * Tests the <code>printFibonacci()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "fibSeriesData")
    public void testGetFibonacciDynamically(int number, int[] expected) {
        LOGGER.debug("testGetFibonacciDynamically({}, {})", number, expected);
        int[] result = FibonacciSeries.getFibonacciDynamically(number);
        LOGGER.debug("number:{}, result:{}", number, Arrays.toString(result));
        assertArrayEquals(expected, result);
    }
}
