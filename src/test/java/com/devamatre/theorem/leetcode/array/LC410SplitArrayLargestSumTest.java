package com.devamatre.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.array.LC410SplitArrayLargestSum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 5:35 PM
 */
public class LC410SplitArrayLargestSumTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LC410SplitArrayLargestSumTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{7, 2, 5, 10, 8}, 2, 18});
        input.add(new Object[]{new int[]{1, 2, 3, 4, 5}, 2, 9});

        return input.iterator();
    }

    /**
     * Tests the <code>splitArray()</code> method
     * <pre>
     * Example 1:
     * Input: nums = [7,2,5,10,8], k = 2
     * Output: 18
     * Explanation: There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two sub-array is only 18.
     *
     * Example 2:
     * Input: nums = [1,2,3,4,5], k = 2
     * Output: 9
     * Explanation: There are four ways to split nums into two subarrays.
     * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
     * </pre>
     *
     * @param input
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testSplitArray(int[] input, int k, int expected) {
        LOGGER.debug("testSplitArray({}, {}, {})", input, k, expected);
        LC410SplitArrayLargestSum instance = new LC410SplitArrayLargestSum();
        int result = instance.splitArray(input, k);
        LOGGER.debug("target:{}, result:{}", k, result);
        assertEquals(expected, result);
    }
}
