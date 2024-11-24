package com.rslakra.theorem.leetcode.array;

import java.util.Arrays;

/**
 * <url>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv</url>
 *
 * @author Rohtash Lakra
 * @created 3/19/24 1:40 PM
 */
public class LC121BestTimeToBuyAndSellStock4 {

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     */
    public int maxProfit(int[] prices, int index, int txCount, boolean bought) {
        if (index >= prices.length || txCount <= 0) {
            return 0;
        }

        // skip the day for transaction
        int profit = maxProfit(prices, index + 1, txCount, bought);
        if (bought) {
            // sell on this day and calculate the max profit and reduce the transaction
            profit = Math.max(profit, prices[index] + maxProfit(prices, index + 1, txCount - 1, false));
        } else {
            // buy on this day and reduce the profit
            profit = Math.max(profit, maxProfit(prices, index + 1, txCount, true) - prices[index]);
        }

        return profit;
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     */
    public int maxProfit(int[] prices, int k) {
        if (prices == null || k <= 0) {
            return 0;
        }

        // // if k > prices.length / 2, then unlimited transactions
        // int profit = 0;
        // if (k >= prices.length / 2) {
        //  for (int i = 0; i < prices.length - 1; i++) {
        //   if (prices[i] < prices[i + 1]) {
        //   profit += prices[i + 1] - prices[i];
        //  }
        // }
        //
        //  return profit;
        // }

        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k];

        // iterate over all the prices
        for (int price : prices) {
            // iterate over all states
            for (int i = 0; i < k; i++) {
                buy[i] = Math.min(buy[i], price - (i > 0 ? sell[i - 1] : 0));
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }

        return sell[k - 1];
    }
}
