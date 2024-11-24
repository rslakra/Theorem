package com.rslakra.theorem.leetcode.array.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rslakra.theorem.adts.array.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:14 PM
 */
public class LC36ValidSudokuTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC36ValidSudokuTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: nums = [1,2,3]
     *  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * Example 2:
     *  Input: nums = [0,1]
     *  Output: [[0,1],[1,0]]
     *
     * Example 3:
     *  Input: nums = [1]
     *  Output: [[1]]
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();

        /**
         * <pre>
         *  Example 1:
         *  Input: board =
         * [["5","3",".",".","7",".",".",".","."]
         * ,["6",".",".","1","9","5",".",".","."]
         * ,[".","9","8",".",".",".",".","6","."]
         * ,["8",".",".",".","6",".",".",".","3"]
         * ,["4",".",".","8",".","3",".",".","1"]
         * ,["7",".",".",".","2",".",".",".","6"]
         * ,[".","6",".",".",".",".","2","8","."]
         * ,[".",".",".","4","1","9",".",".","5"]
         * ,[".",".",".",".","8",".",".","7","9"]]
         * Output: true
         *
         * Example 2:
         * Input: board =
         * [["8","3",".",".","7",".",".",".","."]
         * ,["6",".",".","1","9","5",".",".","."]
         * ,[".","9","8",".",".",".",".","6","."]
         * ,["8",".",".",".","6",".",".",".","3"]
         * ,["4",".",".","8",".","3",".",".","1"]
         * ,["7",".",".",".","2",".",".",".","6"]
         * ,[".","6",".",".",".",".","2","8","."]
         * ,[".",".",".","4","1","9",".",".","5"]
         * ,[".",".",".",".","8",".",".","7","9"]]
         * Output: false
         *
         * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
         * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
         * </pre>
         */

        // Example 1
        input.add(new Object[]{new Integer[][]{
            {5, 3, null, null, 7, null, null, null, null},
            {6, null, null, 1, 9, 5, null, null, null},
            {null, 9, 8, null, null, null, null, 6, null},
            {8, null, null, null, 6, null, null, null, 3},
            {4, null, null, 8, null, 3, null, null, 1},
            {7, null, null, null, 2, null, null, null, 6},
            {null, 6, null, null, null, null, 2, 8, null},
            {null, null, null, 4, 1, 9, null, null, 5},
            {null, null, null, null, 8, null, null, 7, 9}
        }, true});

        // Example 2
        input.add(new Object[]{new Integer[][]{
            {8, 3, null, null, 7, null, null, null, null},
            {6, null, null, 1, 9, 5, null, null, null},
            {null, 9, 8, null, null, null, null, 6, null},
            {8, null, null, null, 6, null, null, null, 3},
            {4, null, null, 8, null, 3, null, null, 1},
            {7, null, null, null, 2, null, null, null, 6},
            {null, 6, null, null, null, null, 2, 8, null},
            {null, null, null, 4, 1, 9, null, null, 5},
            {null, null, null, null, 8, null, null, 7, 9}
        }, false});

        return input.iterator();
    }

    /**
     * Tests the <code>isValidSudoku()</code> method.
     *
     * @param board
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testIsValidSudoku(Integer[][] board, boolean expected) {
        LOGGER.debug("testIsValidSudoku({}, {})", board, expected);
        ArrayUtils.printMatrix(board);
        LC36ValidSudoku instance = new LC36ValidSudoku();
        boolean result = instance.isValidSudoku(board);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
        assertEquals(expected, instance.isValidSudoku2(board));
    }
}
