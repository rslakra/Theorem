package com.devamatre.theorem.leetcode.array;

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
 * @created 1/16/24 1:45 PM
 */
public class LC523ContinuousSubarraySumTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC523ContinuousSubarraySumTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        //[23,2,4,6,7], k = 6
//        input.add(new Object[]{new int[]{5, 2, 3, 1, 7}, 6, true});
//        input.add(new Object[]{new int[]{10, 5, 2, 7, 1, 9}, 15, true});
//        input.add(new Object[]{new int[]{-5, 3, -1, 2, 4, 8}, 4, true});
//        input.add(new Object[]{new int[]{23, 2, 4, 6, 7}, 8, false});
//        input.add(new Object[]{new int[]{2, 4, 6, 4, 7, 23}, 12, true});
//        input.add(new Object[]{new int[]{2, 1, -1, 3, 1, 4}, 4, true});
//        input.add(new Object[]{new int[]{23, 2, 4, 6, 6}, 6, true});
        input.add(new Object[]{new int[]{23, 2, 6, 4, 7}, 6, false});

        return input.iterator();
    }

    /**
     * Tests the <code>checkSubarraySum()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testCheckSubarraySum(int[] inputData, int target, boolean expected) {
        LOGGER.debug("testCheckSubarraySum({}, {}, {})", Arrays.toString(inputData), target, expected);
        LC523ContinuousSubarraySum instance = new LC523ContinuousSubarraySum();
        // boolean result = instance.checkSubarraySum(inputData, target);
        // boolean result = instance.checkSubarraySum2(inputData, target);
        boolean result = instance.checkSubarraySum3(inputData, target);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
        // assertEquals(expected, instance.checkSubarraySum2(inputData, target));
        // assertEquals(expected, instance.checkSubarraySum3(inputData, target));
    }
}
