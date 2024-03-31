package com.devamatre.theorem.leetcode.array;

import static org.testng.AssertJUnit.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 4:10 PM
 */
public class LC121BestTimeToBuyAndSellStock2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC121BestTimeToBuyAndSellStock2Test.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();

        // Example 0:
        input.add(new Object[]{new int[]{12, 17, 11, 15, 1}, 9});
        input.add(new Object[]{new int[]{12, 7, 14, 15, 1}, 8});
        input.add(new Object[]{new int[]{2, 7, 4, 15, 1}, 16});

        // Example 1:
        // Input: prices = [7,1,5,3,6,4]
        // Output: 7
        // Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        // Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        // Total profit is 4 + 3 = 7.
        input.add(new Object[]{new int[]{7, 1, 5, 3, 6, 4}, 7});

        // Example 2:
        // Input: prices = [1,2,3,4,5]
        // Output: 4
        // Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        // Total profit is 4.
        input.add(new Object[]{new int[]{1, 2, 3, 4, 5}, 4});

        // Example 3:
        // Input: prices = [7,6,4,3,1]
        // Output: 0
        // Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
        input.add(new Object[]{new int[]{7, 6, 4, 3, 1}, 0});

        return input.iterator();
    }

    /**
     * Tests the <code>maxProfit()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testThreeSum(int[] inputData, int expected) {
        LOGGER.debug("testThreeSum({}, {})", inputData, expected);
        LC121BestTimeToBuyAndSellStock2 instance = new LC121BestTimeToBuyAndSellStock2();
        int result = instance.maxProfit(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
        assertEquals(expected, instance.maxProfit2(inputData));
    }
}
