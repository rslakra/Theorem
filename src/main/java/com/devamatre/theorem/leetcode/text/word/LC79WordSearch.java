package com.devamatre.theorem.leetcode.text.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <url>https://leetcode.com/problems/word-search</url>
 *
 * @author Rohtash Lakra
 * @created 2/29/24 7:35 AM
 */
public class LC79WordSearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC79WordSearch.class);

    /**
     * @param board
     * @param row
     * @param col
     * @param visited
     * @return
     */
    public boolean exist(char[][] board, int row, int col, boolean[][] visited, String word, int index) {
        LOGGER.debug("+exist({}, {}, {}, {}, {})", board, row, col, word, index, visited);
        if (index == word.length()) {
            return true;
        } else if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited[row][col]
                   || board[row][col] != word.charAt(index)) {
            return false;
        }

        LOGGER.debug("board[{}][{}}]:{}", row, col, board[row][col]);
        // check the char exists in the rootNode
        visited[row][col] = true;
        // left
        boolean leftResult = exist(board, row, col - 1, visited, word, index + 1);
        // top
        boolean topResult = exist(board, row - 1, col, visited, word, index + 1);
        // right
        boolean rightResult = exist(board, row, col + 1, visited, word, index + 1);
        // bottom
        boolean bottomResult = exist(board, row + 1, col, visited, word, index + 1);
        // backtracking
        visited[row][col] = false;

        LOGGER.debug("-exist(), leftResult:{}, topResult:{}, rightResult:{}, bottomResult:{}", leftResult, topResult,
                     topResult, rightResult, bottomResult);
        return leftResult || topResult || rightResult || bottomResult;
    }

    /**
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        LOGGER.debug("exist({}, {})", board, word);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && exist(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

}
