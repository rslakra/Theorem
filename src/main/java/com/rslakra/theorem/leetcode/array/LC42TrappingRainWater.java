/**
 *
 */
package com.rslakra.theorem.leetcode.array;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 21, 2019 9:44:27 PM
 */
public class LC42TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
     * water it is able to trap after raining.
     * <p>
     * <p>
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
     * (blue section) are being trapped.
     * <p>
     * Example:
     *
     * <pre>
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * </pre>
     * <p>
     * Time Complexity: O(N)
     * <p>
     * Space Complexity: O(3 * N)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftMost = 0;
        int[] leftHigh = new int[height.length];
        leftHigh[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftHigh[i] = Math.max(height[i - 1], leftMost);
            leftMost = Math.max(height[i - 1], leftMost);
        }

        int rigthMost = 0;
        int[] rightHigh = new int[height.length];
        rightHigh[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightHigh[i] = Math.max(height[i + 1], rigthMost);
            rigthMost = Math.max(height[i + 1], rigthMost);
        }

        int[] tapWater = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftHigh[i], rightHigh[i]);
            tapWater[i] = (min == 0 || (min - height[i]) < 0) ? 0 : (min - height[i]);
        }

        int sum = 0;
        for (int i = 0; i < tapWater.length; i++) {
            sum += tapWater[i];
        }

        return sum;
    }

    /**
     * @param height
     * @return
     */
    public int trapOptimized(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int[] tapWater = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            /**
             int min = Math.min(leftHigh[i], rightHigh[i]);
             tapWater[i] = (min == 0 || (min - height[i]) < 0) ? 0 : (min - height[i]);
             */
        }

        int sum = 0;
        for (int i = 0; i < tapWater.length; i++) {
            sum += tapWater[i];
        }

        return sum;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC42TrappingRainWater tapWater = new LC42TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Arrays.toString(height) + " : " + tapWater.trap(height));
    }

}
