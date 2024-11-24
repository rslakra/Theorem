package com.rslakra.theorem.algos.lang;

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
 * @since 01/02/2024 8:26 AM
 */
public class PascalTriangleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PascalTriangleTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> pascalTriangleData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, Arrays.asList(0)});
        input.add(new Object[]{1, Arrays.asList(0, 1)});
        input.add(new Object[]{2, Arrays.asList(0, 1, 1)});
        input.add(new Object[]{3, Arrays.asList(0, 1, 1, 2)});
        input.add(new Object[]{4, Arrays.asList(0, 1, 1, 2, 3)});
        input.add(new Object[]{5, Arrays.asList(0, 1, 1, 2, 3, 5)});
        input.add(new Object[]{6, Arrays.asList(0, 1, 1, 2, 3, 5, 8)});
        input.add(new Object[]{7, Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13)});
        input.add(new Object[]{8, Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21)});
        input.add(new Object[]{9, Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)});
        input.add(new Object[]{10, Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)});

        return input.iterator();
    }

    /**
     * Tests the <code>fibonacciSeriesWithPascalTriangle()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "pascalTriangleData")
    public void testFibonacciSeriesWithPascalTriangle(int number, List<Integer> expected) {
        PascalTriangle.fibonacciSeriesWithPascalTriangle(number);
//  LOGGER.debug("number:{}, result:{}", number, result);
//  assertEquals(expected.get(expected.size() - 1), result);
    }
}
