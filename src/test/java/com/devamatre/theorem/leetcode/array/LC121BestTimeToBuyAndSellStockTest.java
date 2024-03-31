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
public class LC121BestTimeToBuyAndSellStockTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC121BestTimeToBuyAndSellStockTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{12, 17, 11, 15, 1}, 5});
        input.add(new Object[]{new int[]{12, 7, 14, 15, 1}, 8});
        input.add(new Object[]{new int[]{2, 7, 4, 15, 1}, 13});

        // Example 1:
        // Input: prices = [7,1,5,3,6,4]
        // Output: 5
        // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        // Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        input.add(new Object[]{new int[]{7, 1, 5, 3, 6, 4}, 5});

        //
        // Example 2:
        // Input: prices = [7,6,4,3,1]
        // Output: 0
        // Explanation: In this case, no transactions are done and the max profit = 0.
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
    public void testThreeSum(int[] inputData, Integer expected) {
        LOGGER.debug("testThreeSum({}, {})", inputData, expected);
        LC121BestTimeToBuyAndSellStock instance = new LC121BestTimeToBuyAndSellStock();
        Integer result = instance.maxProfit(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
