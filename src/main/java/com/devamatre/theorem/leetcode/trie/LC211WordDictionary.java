package com.devamatre.theorem.leetcode.trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <url>https://leetcode.com/problems/design-add-and-search-words-data-structure</url>
 *
 * <pre>
 * Constraints:
 *  1 <= word.length <= 25
 *  word in addWord consists of lowercase English letters.
 *  word in search consist of '.' or lowercase English letters.
 *  There will be at most 2 dots in word for search queries.
 *  At most 104 calls will be made to addWord and search.
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 22, 2019 5:33:16 PM
 */
public class LC211WordDictionary {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC211WordDictionary.class);

    private Trie.TrieNode rootNode;

    public LC211WordDictionary() {
        rootNode = new Trie.TrieNode();
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param word
     */
    public void addWord(String word) {
        LOGGER.debug("+addWord({})", word);
        Trie.TrieNode trieNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char keyChar = word.charAt(i);
            if (!trieNode.contains(keyChar)) {
                trieNode.addNode(keyChar, new Trie.TrieNode(keyChar));
            }
            trieNode = trieNode.getNode(keyChar);
        }
        trieNode.setEnds(true);
        LOGGER.debug("-addWord(), rootNode:{}", rootNode);
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param word
     * @param index
     * @param rootNode
     * @return
     */
    public boolean search(String word, int index, Trie.TrieNode rootNode) {
        LOGGER.debug("+search({}, {}, {})", word, index, rootNode);
        if (index == word.length()) {
            LOGGER.debug("-search(), index:{} == length:{}, rootNode:{}", index, word.length(), rootNode);
            return rootNode.isEnds();
        }

        char keyChar = word.charAt(index);
        // if char is . (dot), find other alternatives
        if ('.' == keyChar) {
            Map<Character, Trie.TrieNode> childNodes = rootNode.getChildren();
            for (Character nextChar : childNodes.keySet()) {
                if (search(word, index + 1, rootNode.getNode(nextChar))) {
                    LOGGER.debug("-search(), return true! keyChar:{}", keyChar);
                    return true;
                }
            }
        } else if (rootNode.contains(keyChar)) { // if not a .(dot), find other chars
            if (search(word, index + 1, rootNode.getNode(keyChar))) {
                LOGGER.debug("-search(), return true! keyChar:{}", keyChar);
                return true;
            }
        }

        LOGGER.debug("-search(), return false");
        return false;
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        LOGGER.debug("+search({})", word);
        if (word == null || word.length() == 0) {
            LOGGER.debug("-search(), return true! Null or Empty word always exist!");
            return true;
        }

        Trie.TrieNode trieNode = rootNode;
        if (search(word, 0, trieNode)) {
            LOGGER.debug("-search(), return true! i:0");
            return true;
        }

        LOGGER.debug("-search(), return false");
        return false;
    }

}
