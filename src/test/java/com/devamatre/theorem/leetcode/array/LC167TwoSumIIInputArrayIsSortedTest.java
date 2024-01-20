package com.devamatre.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 4:01 PM
 */
public class LC167TwoSumIIInputArrayIsSortedTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LC167TwoSumIIInputArrayIsSortedTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}});
        input.add(new Object[]{new int[]{2, 3, 4}, 6, new int[]{1, 3}});
        input.add(new Object[]{new int[]{-1, 0}, -1, new int[]{1, 2}});

        return input.iterator();
    }

    /**
     * Tests the <code>twoSum()</code> method
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testTwoSum(int[] inputData, int target, int[] expected) {
        LOGGER.debug("testTwoSum({}, {}, {})", inputData, target, expected);
        LC167TwoSumIIInputArrayIsSorted instance = new LC167TwoSumIIInputArrayIsSorted();
        int[] result = instance.twoSum(inputData, target);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertArrayEquals(expected, result);
    }
}
