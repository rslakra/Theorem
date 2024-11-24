package com.rslakra.theorem.leetcode.text.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <url>https://leetcode.com/problems/word-search</url>
 *
 * @author Rohtash Lakra
 * @created 2/29/24 7:35 AM
 */
public class LC79WordSearchTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC79WordSearchTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // Example 1
        // Input:
        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
        // word = "ABCCED"
        // Output: true
        inputs.add(
            new Object[]{
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCCED", true});

        // Example 2
        // Input:
        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
        // word = "SEE"
        // Output: true
        inputs.add(
            new Object[]{
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "SEE", true});

        // Example 3
        // Input:
        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
        // word = "ABCB"
        // Output: false
        inputs.add(
            new Object[]{
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCB", false});

        // Example 4
        // Input:
        // board = [['a', 'b']],
        // word = "ab"
        // Output: true
        inputs.add(new Object[]{new char[][]{{'a', 'b'}}, "ab", true});

        // Example 5
        // Input:
        // board = [['a', 'b']],
        // word = "ba"
        // Output: true
        inputs.add(new Object[]{new char[][]{{'a', 'b'}}, "ba", true});

        // Example 6
        // Input:
        // board = [["b"],["a"],["b"],["b"],["a"]]
        // word = "baa"
        // Output: false
        inputs.add(new Object[]{new char[][]{{'b'}, {'a'}, {'b'}, {'b'}, {'a'}}, "baa", false});

        return inputs.iterator();
    }

    /**
     * Tests the <code>exist()</code> method.
     *
     * @param board
     * @param word
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testExist(char[][] board, String word, boolean expected) {
        LOGGER.debug("testExist({}, {}, {})", board, word, expected);
        LC79WordSearch instance = new LC79WordSearch();
        boolean result = instance.exist(board, word);
        assertEquals(expected, result);
    }
}
