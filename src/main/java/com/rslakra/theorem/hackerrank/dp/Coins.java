/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.theorem.hackerrank.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-11-05 05:41:55 PM
 * @since 1.0.0
 */
public class Coins {

    /**
     * @param sum
     * @param coins
     * @param coinIndex
     * @return
     */
    public static long getWaysToChange(long sum, long[] coins, int coinIndex) {
        if (sum < 0) { // sum < 0, but coins available, so no way to change
            return 0;
        } else if (sum == 0) { // coins may or may not be available and no sum is required, so don't include the coin.
            return 1;
        } else if (sum > 0 && coinIndex == coins.length) { // sum required but no coins left, no solution
            return 0;
        } else {
            return getWaysToChange(sum - coins[coinIndex], coins, coinIndex)
                    + getWaysToChange(sum, coins, coinIndex + 1);
        }
    }

    /**
     * @param sum
     * @param coins
     * @param coinIndex
     * @return
     */
    public static long getWaysToChangeBackward(long sum, long[] coins, int coinIndex) {
        if (sum < 0) { // sum < 0, but coins available, so no way to change
            return 0;
        } else if (sum == 0) { // coins may or may not be available and no sum is required, so don't include the coin.
            return 1;
        } else if (coinIndex <= 0) { // no coins left, no solution
            return 0;
        } else {
            return getWaysToChangeBackward(sum, coins, coinIndex - 1)
                    + getWaysToChangeBackward(sum - coins[coinIndex - 1], coins, coinIndex);
        }
    }

    public static long getWays(int sum, long[] coins) {
        // Complete this function
        if (sum < 0) {
            return 0;
        } else if (sum == 0) {
            return 1;
        } else {
            int[] change = new int[sum + 1];
            change[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                int coin = (int) coins[i];
                for (int j = coin; j < change.length; j++) {
                    change[j] += change[j - coin];
                }
            }

            return change[sum];
        }
    }

    /**
     * @param listCoins
     * @param times
     */
    private static void addCoin(long coin, List<Long> listCoins, int times) {
        for (int i = 0; i < times; i++) {
            listCoins.add(coin);
        }
    }

    public static List<Long> getChange(long sum, long[] coins) {
        List<Long> listCoins = new ArrayList<>();
        int index = coins.length - 1;
        while (sum > 0 && index >= 0) {
            if (sum >= coins[index]) {
                int times = (int) (sum / coins[index]);
                addCoin(coins[index], listCoins, times);
                sum = sum % coins[index];
                if (sum > 0 && sum < coins[index]) {
                    index--;
                }
            } else {
                index--;
            }
        }

        return listCoins;
    }

    /**
     * This also works but need to understand better.
     *
     * @param coins
     * @param money
     * @return
     */
    public static long makeChange(int[] coins, int money) {
        long[] dp = new long[money + 1]; // O(N) space.
        dp[0] = 1L; // n == 0 case.
        for (int coin : coins) {
            System.out.println(coin);
            for (int j = coin; j < dp.length; j++) {
                // The only tricky step.
                System.out.println("dp[" + j + "] += dp[" + (j - coin) + "]");
                dp[j] += dp[j - coin];
            }
        }
        return dp[money];
    }

    // public static long[][] cache;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] coins = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = in.nextInt();
        }

        // Print the number of ways of making change for 'n' units using coins
        // having the values given by 'c'
        // System.out.println(getWays(n, coins));
        in.close();
        // System.out.println(getWaysToChange(n, coins, m));
        // System.out.println(getChange(n, coins));
        System.out.println(makeChange(coins, n));

        // int N = 4;
        // long[] lCoins = new long[]{1, 2, 3};
        // System.out.println(getWaysToChange(N, lCoins, 0));
        // System.out.println(getWaysToChangeBackward(N, lCoins, lCoins.length));
    }

}
