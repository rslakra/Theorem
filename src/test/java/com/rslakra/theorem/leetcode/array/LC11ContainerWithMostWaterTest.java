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
 * @created 1/31/24 3:09 PM
 */
public class LC11ContainerWithMostWaterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC11ContainerWithMostWaterTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: height = [1,8,6,2,5,4,8,3,7]
     *  Output: 49
     *  Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     *  In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Example 2:
     *  Input: height = [1,1]
     *  Output: 1
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}});
        input.add(new Object[]{new int[]{3, 2, 4}, 6, new int[]{1, 2}});
        input.add(new Object[]{new int[]{-1, 0}, -1, new int[]{0, 1}});

        return input.iterator();
    }

    /**
     * Tests the <code>maxArea()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testMaxArea(int[] inputData, int expected) {
        LOGGER.debug("testMaxArea({}, {}, {})", inputData, expected);
        LC11ContainerWithMostWater instance = new LC11ContainerWithMostWater();
        int result = instance.maxArea(inputData);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
        assertEquals(expected, instance.maxArea2(inputData));
    }
}
