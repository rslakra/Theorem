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
public class LC121BestTimeToBuyAndSellStock4Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC121BestTimeToBuyAndSellStock4Test.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        //   Example 0:
        input.add(new Object[]{new int[]{12, 17, 11, 15, 1}, 2, 9});

        //   Example 1:
        //   prices = [2,4,1],  k = 2
        //   Output: 2
        //   Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
        input.add(new Object[]{new int[]{2, 4, 1}, 2, 2});

        //   Example 2:
        //   Input:
        //   prices = [3,2,6,5,0,3],  k = 2
        //   Output: 7
        //   Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        input.add(new Object[]{new int[]{3, 2, 6, 5, 0, 3}, 2, 7});

        return input.iterator();
    }

    /**
     * Tests the <code>maxProfit()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testThreeSum(int[] inputData, int k, Integer expected) {
        LOGGER.debug("testThreeSum({}, {}, {})", inputData, expected);
        LC121BestTimeToBuyAndSellStock4 instance = new LC121BestTimeToBuyAndSellStock4();
        Integer result = instance.maxProfit(inputData, k);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
