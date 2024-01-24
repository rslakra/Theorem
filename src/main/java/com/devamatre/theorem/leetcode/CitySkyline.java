/**
 *
 */
package com.devamatre.theorem.leetcode;

/**
 * @author Rohtash Lakra
 */
public class CitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;

        if (grid != null && grid.length > 0) {
            int[] maxLeftOrRight = new int[grid.length];
            int[] maxTopOrBottom = new int[grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // find max value from left or right
                    if (grid[i][j] > maxLeftOrRight[i]) {
                        maxLeftOrRight[i] = grid[i][j];
                    }

                    // find max value from top or bottom
                    if (grid[j][i] > maxTopOrBottom[i]) {
                        maxTopOrBottom[i] = grid[j][i];
                    }

                }
            }

            for (int i = 0; i < maxLeftOrRight.length; i++) {
                for (int j = 0; j < maxLeftOrRight.length; j++) {
                    sum += (Math.min(maxLeftOrRight[i], maxTopOrBottom[j]) - grid[i][j]);
                }
            }
        }

        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        CitySkyline obj = new CitySkyline();
        System.out.println(obj.maxIncreaseKeepingSkyline(grid));
    }

}
