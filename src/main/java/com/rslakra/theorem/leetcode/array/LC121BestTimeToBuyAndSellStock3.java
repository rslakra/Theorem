package com.rslakra.theorem.leetcode.array;

/**
 * <url>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii</url>
 *
 * @author Rohtash Lakra
 * @created 3/19/24 1:40 PM
 */
public class LC121BestTimeToBuyAndSellStock3 {

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(n)
     * </pre>
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int min = prices[0];
        // build left buying table
        for (int i = 1; i < prices.length; i++) {
            // update buy price
            if (prices[i] < min) {
                min = prices[i];
            }
            // calculate profit
            int profit = prices[i] - min;
            // fill left table
            left[i] = Math.max(left[i - 1], profit);
        }

        int max = prices[prices.length - 1];
        // build right selling table
        for (int i = prices.length - 2; i >= 0; i--) {
            // update sell price
            if (prices[i] > max) {
                max = prices[i];
            }
            // calculate profit
            int profit = max - prices[i];
            // fill right table
            right[i] = Math.max(right[i + 1], profit);
        }

        int maxProfit = 0;
        // build right selling table
        for (int i = 0; i < prices.length; i++) {
            // calculate max profit
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
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

        int buyPrice1 = Integer.MAX_VALUE;
        int lastProfit = Integer.MIN_VALUE;
        int buyPrice2 = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            //first Transaction
            buyPrice1 = Math.min(buyPrice1, prices[i]);
            lastProfit = Math.max(lastProfit, prices[i] - buyPrice1);

            //Second Transaction
            buyPrice2 = Math.min(buyPrice2, prices[i] - lastProfit);
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice2);
        }

        return maxProfit;
    }


}
