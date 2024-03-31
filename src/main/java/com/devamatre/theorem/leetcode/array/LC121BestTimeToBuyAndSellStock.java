package com.devamatre.theorem.leetcode.array;

/**
 * <url>https://leetcode.com/problems/best-time-to-buy-and-sell-stock/</url>
 *
 * @author Rohtash Lakra
 * @created 3/19/24 1:40 PM
 */
public class LC121BestTimeToBuyAndSellStock {

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        return profit;
    }
}
