package com.rslakra.theorem.leetcode.text.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <url>https://leetcode.com/problems/word-search-ii/</url>
 *
 * @author Rohtash Lakra
 * @created 2/29/24 7:33 AM
 */
public class LC212WordSearch2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC212WordSearch2.class);

    static class TrieNode {

        TrieNode[] children;
        boolean isEnds;
        boolean isUpperCase;

        TrieNode() {
            children = new TrieNode[26];
            Arrays.fill(children, null);
            isEnds = false;
        }

        boolean existsAtIndex(int index) {
            return children[index] != null;
        }

        TrieNode nodeAtIndex(int index) {
            return children[index];
        }

        void addAtIndex(int index, char cChar) {
            children[index] = new TrieNode();
            children[index].isUpperCase = cChar < 97;
        }

        char charAtIndex(int index) {
            return (char) (index + (nodeAtIndex(index).isUpperCase ? 'A' : 'a'));
        }

        static int indexForChar(char cChar) {
            LOGGER.trace("+indexForChar({})", cChar);
            int index = cChar - (Character.isUpperCase(cChar) ? 'A' : 'a');
            LOGGER.trace("-indexForChar(), index:{}", index);
            return index;
        }

        /**
         * @param rootNode
         * @return
         */
        static String toString(TrieNode rootNode, char[] str, int level) {
            // If  of string, so a null character is added and string is returned
            if (rootNode.isEnds) {
                return new String(str).trim();
            }

            StringBuilder trieBuilder = new StringBuilder();
            int index;
            for (index = 0; index < 26; index++) {
                // if child exists, add parent key to str and call toString() recursively for child node
                if (rootNode.existsAtIndex(index)) {
                    str[level] = rootNode.charAtIndex(index);
                    if (trieBuilder.length() > 0) {
                        trieBuilder.append(", ");
                    }
                    trieBuilder.append(toString(rootNode.children[index], str, level + 1));
                }
            }

            return trieBuilder.toString();
        }

        static String toString(TrieNode rootNode) {
            // the maximum word of dictionary can be 45 chars
            return toString(rootNode, new char[45], 0);
        }
    }

    static class Trie {

        TrieNode rootNode = new TrieNode();

        /**
         * <pre>
         *  Time Complexity: O(N)
         *  Space Complexity: O(N)
         * </pre>
         *
         * @param word
         */
        public void insert(String word) {
            LOGGER.trace("+insert({})", word);
            TrieNode trieNode = rootNode;
            for (char cChar : word.toCharArray()) {
                int index = TrieNode.indexForChar(cChar);
                if (!trieNode.existsAtIndex(index)) {
                    trieNode.addAtIndex(index, cChar);
                }
                trieNode = trieNode.nodeAtIndex(index);
            }
            trieNode.isEnds = true;
            LOGGER.trace("-insert()");
        }

        /**
         * @param word
         * @return
         */
        public boolean search(String word) {
            TrieNode trieNode = rootNode;
            for (char cChar : word.toCharArray()) {
                int index = TrieNode.indexForChar(cChar);
                if (!trieNode.existsAtIndex(index)) {
                    return false;
                }
                trieNode = trieNode.nodeAtIndex(index);
            }

            return trieNode.isEnds;
        }

        /**
         * <pre>
         *  Time Complexity: O(N)
         *  Space Complexity: O(N)
         * </pre>
         *
         * @param words
         */
        public void insert(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(words[i]);
            }
        }

        /**
         * Trie String
         *
         * @return
         */
        @Override
        public String toString() {
            return TrieNode.toString(rootNode);
        }
    }

    public void findWords(char[][] board, int row, int col, String word, boolean[][] visited, TrieNode rootNode,
                          Set<String> result) {
        LOGGER.debug("+findWords({}, {}, {}, {}, {}, {}, {})", board, row, col, word, visited, rootNode, result);
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited[row][col]) {
            return;
        }

        // check the char exists in the trieNode
        LOGGER.debug("board[{}][{}}]:{}", row, col, board[row][col]);
        int index = TrieNode.indexForChar(board[row][col]);
        if (!rootNode.existsAtIndex(index)) {
            return;
        }

        visited[row][col] = true;
        // move to next trie node
        rootNode = rootNode.nodeAtIndex(index);
        // if trie node ends
        if (rootNode.isEnds) {
            LOGGER.debug("word:{}, result:{}", word + board[row][col], result);
            result.add(word + board[row][col]);
        }

        // left
        findWords(board, row, col - 1, word + board[row][col], visited, rootNode, result);
        // top
        findWords(board, row - 1, col, word + board[row][col], visited, rootNode, result);
        // right
        findWords(board, row, col + 1, word + board[row][col], visited, rootNode, result);
        // bottom
        findWords(board, row + 1, col, word + board[row][col], visited, rootNode, result);
        visited[row][col] = false;
        LOGGER.debug("-findWords()");
    }

    /**
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        trie.insert(words);
        LOGGER.debug("trie:{}", trie);
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> set = new HashSet<>();
        TrieNode trieNode = trie.rootNode;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int index = TrieNode.indexForChar(board[i][j]);
                if (trieNode.existsAtIndex(index)) {
                    findWords(board, i, j, "", visited, trieNode, set);
                }
            }
        }
        result.addAll(set);
        return result;
    }

}
