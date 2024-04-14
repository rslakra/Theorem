package com.devamatre.theorem.leetcode.array.matrix;

import com.devamatre.theorem.adts.array.ArrayUtils;
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
public class LC37SudokuSolverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC37SudokuSolverTest.class);

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
        input.add(new Object[]{new String[][]{
            {"5", "3", ".", ".", "7", ".", ".", ".", "."},
            {"6", ".", ".", "1", "9", "5", ".", ".", "."},
            {".", "9", "8", ".", ".", ".", ".", "6", "."},
            {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
            {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
            {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
            {".", "6", ".", ".", ".", ".", "2", "8", "."},
            {".", ".", ".", "4", "1", "9", ".", ".", "5"},
            {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        }, true});

        // Example 2
        input.add(new Object[]{new String[][]{
            {"8", "3", ".", ".", "7", ".", ".", ".", "."},
            {"6", ".", ".", "1", "9", "5", ".", ".", "."},
            {".", "9", "8", ".", ".", ".", ".", "6", "."},
            {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
            {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
            {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
            {".", "6", ".", ".", ".", ".", "2", "8", "."},
            {".", ".", ".", "4", "1", "9", ".", ".", "5"},
            {".", ".", ".", ".", "8", ".", ".", "7", "9"}
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
    public void testIsValidSudoku(String[][] board, boolean expected) {
        LOGGER.debug("testIsValidSudoku({}, {})", board, expected);
        ArrayUtils.printMatrix(board);
        LC37SudokuSolver instance = new LC37SudokuSolver();
        instance.solveSudoku(board);
//        assertEquals(expected, result);
    }
}
