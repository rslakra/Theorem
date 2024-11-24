/**
 *
 */
package com.rslakra.theorem.algos.lang;

/**
 * You are given an array of integers representing the prices of a single stock on various days (each index in the array
 * represents a different day). You are also given an integer k, which represents the number of transactions you are
 * allowed to make. One transaction consists of buying the stock on a given day and selling it on another, later day.
 * Write a function that returns the maximum profit that you can make buying and selling the stock, given k
 * transactions. Note that you can only hold 1 share of the stock at a time; in other words, you cannot buy more than 1
 * share of the stock on any given day, and you cannot buy a share of the stock if you are still holding another share.
 * <p>
 * Sample input: [5, 11, 3, 50, 60, 90], 2
 * <p>
 * Sample output: 93 (Buy: 5, Sell: 11; Buy: 3, Sell: 90)
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 22, 2019 7:21:12 PM
 */
public class MaxProfits {

    /**
     * @param prices
     * @param k
     * @return
     */
    public int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices == null) {
            return 0;
        }

        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length && k > 0; i++) {
            if (prices[i] < min) {
                maxProfit += prices[i - 1] - min;
                k--;
                min = prices[i];
            }
        }

        if (k > 0) {
            maxProfit += prices[prices.length - 1] - min;
        }

        return maxProfit;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MaxProfits maxProfits = new MaxProfits();
        int[] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;
        System.out.println(maxProfits.maxProfitWithKTransactions(prices, k));
    }

}
