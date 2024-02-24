package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:09 PM
 */
public class LC11ContainerWithMostWater {

    /**
     * <url>https://leetcode.com/problems/container-with-most-water</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int gap = j - i;
                max = Math.max(max, minHeight * gap);
            }
        }

        return max;
    }

    /**
     * <url>https://leetcode.com/problems/container-with-most-water</url>
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height == null) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int leftValue = height[left];
            int rightValue = height[right];
            int min = Math.min(leftValue, rightValue);
            int diff = right - left;
            max = Math.max(max, diff * min);
            if (leftValue < rightValue) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}
