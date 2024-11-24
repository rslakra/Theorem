package com.rslakra.theorem.leetcode.array.matrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <url>https://leetcode.com/problems/valid-sudoku/</url>
 *
 * @author Rohtash Lakra
 * @created 4/11/24 2:57 PM
 */
public class LC36ValidSudoku {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC36ValidSudoku.class);

    /**
     * Returns true if the board contains unique [0-9] in the provided <code>row</code>.
     *
     * @param row
     * @param value
     * @param rowMap
     * @return
     */
    private boolean isValidRow(int row, int value, Map<Integer, Set<Integer>> rowMap) {
        LOGGER.debug("+isValidRow({}, {}, {})", row, value, rowMap);
        // valid the row must contain the digits 1-9 without repetition.
        if (rowMap.containsKey(row)) {
            if (rowMap.get(row).contains(value)) {
                LOGGER.debug("-isValidRow(), false [row:{}, value:{}, rowMap:{}]", row, value, rowMap);
                return false;
            }
        } else {
            rowMap.put(row, new HashSet<>());
            rowMap.get(row).add(value);
        }

        LOGGER.debug("-isValidRow(), true");
        return true;
    }

    /**
     * Returns true if the board contains unique [0-9] in the provided <code>column</code>.
     *
     * @param col
     * @param value
     * @param colMap
     * @return
     */
    private boolean isValidColumn(int col, int value, Map<Integer, Set<Integer>> colMap) {
        LOGGER.debug("+isValidColumn({}, {}, {})", col, value, colMap);
        // valid the row must contain the digits 1-9 without repetition.
        if (colMap.containsKey(col)) {
            if (colMap.get(col).contains(value)) {
                LOGGER.debug("-isValidColumn(), false [col:{}, value:{}, colMap:{}]", col, value, colMap);
                return false;
            }
        } else {
            colMap.put(col, new HashSet<>());
            colMap.get(col).add(value);
        }

        LOGGER.debug("-isValidColumn(), true");
        return true;
    }

    /**
     * Returns true if each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * col/row->{index, set of #} {row/3 + col/3, set of numbers}
     *
     * @param row
     * @param col
     * @param value
     * @param sqrMap
     * @return
     */
    private boolean isValidSquare(int row, int col, int value, Map<Integer, Set<Integer>> sqrMap) {
        LOGGER.debug("+isValidSquare({}, {}, {}, {})", row, col, value, sqrMap);
        // row and col are valid indices
        // valid the 3x3 box must contain the digits 1-9 without repetition.
        int index = row / 3 * 3 + col / 3;
        LOGGER.debug("row:{}, col:{}, index:{}, value:{}", row, col, index, value);
        if (sqrMap.containsKey(index)) {
            if (sqrMap.get(index).contains(value)) {
                LOGGER.debug("-isValidColumn(), false [index:{}, value:{}, sqrMap:{}]", index, value, sqrMap);
                return false;
            }
        } else {
            sqrMap.put(index, new HashSet<>());
            sqrMap.get(index).add(value);
        }

        LOGGER.debug("-isValidSquare(), true");
        return true;
    }

    /**
     * <pre>
     *  Determine if a 9 x 9 Sudoku board is valid.
     *  Only the filled cells need to be validated according to the following rules:
     *
     *  Each row must contain the digits 1-9 without repetition.
     *  Each column must contain the digits 1-9 without repetition.
     *  Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     *  Note:
     *   A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     *   Only the filled cells need to be validated according to the mentioned rules.
     *
     *  For example, here is a valid grid which should return true:
     *
     *  int[][] sudokuGrid = {
     *   {5,3,4,6,7,8,9,1,2},
     *   {6,7,2,1,9,5,3,4,8},
     *   {1,9,8,3,4,2,5,6,7},
     *   {8,5,9,7,6,1,4,2,3},
     *   {4,2,6,8,5,3,7,9,1},
     *   {7,1,3,9,2,4,8,5,6},
     *   {9,6,1,5,3,7,2,8,4},
     *   {2,8,7,4,1,9,6,3,5},
     *   {3,4,5,2,8,6,1,7,9}
     *  };
     * </pre>
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(Integer[][] board) {
        // Could store set in a bit map, which could save space.
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> sqrMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    if (!isValidRow(i, board[i][j], rowMap) || !isValidColumn(j, board[i][j], colMap) || !isValidSquare(
                        i, j, board[i][j], sqrMap)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(Integer[][] board) {
        // Could store set in a bit map, which could save space.
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null) {
                    int number = board[i][j];
                    if (!set.add(number + " row " + i) || !set.add(number + " column " + j) || !set.add(
                        number + " block " + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }

        LOGGER.debug("set:{}", set);

        return true;
    }


}
