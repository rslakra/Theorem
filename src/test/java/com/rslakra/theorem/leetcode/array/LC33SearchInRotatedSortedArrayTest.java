package com.rslakra.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 1:25 PM
 */
public class LC33SearchInRotatedSortedArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC33SearchInRotatedSortedArrayTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4});
        input.add(new Object[]{new int[]{5, 6, 7, 0, 1}, 0, 3});
        input.add(new Object[]{new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1});
        input.add(new Object[]{new int[]{1}, 0, -1});
        input.add(new Object[]{new int[]{1}, 1, 0});
        input.add(new Object[]{new int[]{1, 3}, 1, 0});
        input.add(new Object[]{new int[]{3, 5, 1}, 3, 0});

        return input.iterator();
    }

    /**
     * Tests the <code>search()</code> method.
     *
     * @param input
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testSearch(int[] input, int target, int expected) {
        LOGGER.debug("testSearch({}, {}, {})", input, target, expected);
        LC33SearchInRotatedSortedArray instance = new LC33SearchInRotatedSortedArray();
        int result = instance.search(input, target);
        LOGGER.debug("target:{}, result:{}", target, result);
        assertEquals(expected, result);
    }
}
