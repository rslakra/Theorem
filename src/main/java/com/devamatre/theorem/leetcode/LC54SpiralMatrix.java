package com.devamatre.theorem.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/12/23 4:26 PM
 */
public class LC54SpiralMatrix {

    /**
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix != null && matrix.length > 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int top = 0;
            int left = 0;
            int bottom = rows - 1;
            int right = cols - 1;
            while (left <= right && top <= bottom) {
                // process top row
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;

                // process right row
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

                // process bottom row
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                // process left row
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                }
            }
        }

        return result;
    }
}
