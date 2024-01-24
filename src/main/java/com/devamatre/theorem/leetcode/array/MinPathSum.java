/**
 *
 */
package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 */
public class MinPathSum {

    /**
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // rows
        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        // cols
        for (int i = 1; i < cols; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MinPathSum pathSum = new MinPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(pathSum.minPathSum(grid));
        grid = new int[][]{{9, 1, 4, 8}};
        System.out.println(pathSum.minPathSum(grid));
    }

}
