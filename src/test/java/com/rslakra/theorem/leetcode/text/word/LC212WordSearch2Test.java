package com.rslakra.theorem.leetcode.text.word;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/29/24 7:34 AM
 */
public class LC212WordSearch2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC79WordSearchTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // Example 1
        // Input:
        // board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        // words = ["oath","pea","eat","rain"]
        // Output: ["eat","oath"]
        inputs.add(
            new Object[]{
                new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}, Arrays.asList("eat", "oath")});

        // Example 2
        // Input:
        // board = [["a","b"],["c","d"]]
        // words = ["abcb"]
        // Output: []
        inputs.add(new Object[]{new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"}, Arrays.asList()});

        // Example 3
        // Input:
        // board = [["a","b"],["c","d"]]
        // words = ["abcb"]
        // Output: []
        inputs.add(new Object[]{
            new char[][]{{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}},
            new String[]{"oa", "oaa"}, Arrays.asList("oa", "oaa")});

        return inputs.iterator();
    }

    /**
     * Tests the <code>findWords()</code> method.
     *
     * @param board
     * @param words
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testFindWords(char[][] board, String[] words, List<String> expected) {
        LOGGER.debug("testFindWords({}, {}, {})", board, words, expected);
        LC212WordSearch2 instance = new LC212WordSearch2();
        List<String> result = instance.findWords(board, words);
        assertTrue(expected.containsAll(result));
    }
}
