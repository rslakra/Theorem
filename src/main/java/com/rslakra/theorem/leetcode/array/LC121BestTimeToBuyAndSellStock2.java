package com.rslakra.theorem.leetcode.array;

/**
 * <url>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii</url>
 *
 * @author Rohtash Lakra
 * @created 3/19/24 1:40 PM
 */
public class LC121BestTimeToBuyAndSellStock2 {

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
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = Math.max(prices[i], buy);
            }
        }

        return profit;
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     */
    public int maxProfit2(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                profit += prices[i] - buy;
            }

            buy = prices[i];
        }

        return profit;
    }
}
