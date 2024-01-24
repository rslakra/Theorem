/**
 *
 */
package com.devamatre.theorem.leetcode.tree;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 22, 2019 5:33:16 PM
 */
public class LC211WordDictionary {

    private class TrieNode {

        boolean end;
        TrieNode[] next = new TrieNode[26];
    }

    private TrieNode rootNode;

    /**
     * Initialize your data structure here.
     */
    public LC211WordDictionary() {
        rootNode = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     *
     * <code>addWord("lakra")</code>
     *
     * @param word
     */
    public void addWord(final String word) {
        if (word != null) {
            TrieNode node = rootNode;
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                if (node.next[charIndex] == null) {
                    node.next[charIndex] = new TrieNode();
                }
                node = node.next[charIndex];
            }
            node.end = true;
        }
    }

    /**
     * @param word
     * @param index
     * @param node
     * @return
     */
    public boolean search(String word, int index, TrieNode node) {
        System.out.println("search(" + index + ")");
        // base case
        if (index == word.length()) {
            System.out.println("return[" + index + "] end:" + node.end);
            return node.end;
        }

        System.out.println("word.charAt(" + index + ")" + word.charAt(index));
        // if not dot
        if (word.charAt(index) != '.') {
            int charIndex = word.charAt(index) - 'a';
            TrieNode nextNode = node.next[charIndex];
            return (nextNode != null && search(word, index + 1, nextNode));
        }

        // if dot, find all alternatives
        for (TrieNode nextNode : node.next) {
            if (nextNode != null && search(word, index + 1, nextNode)) {
                System.out.println("return[" + index + "] true");
                return true;
            }
        }

        System.out.println("return false");
        return false;

    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
     * letter.
     *
     * <code>search("lakra")</code>
     *
     * @param word
     * @return
     */
    public boolean search(final String word) {
        return search(word, 0, rootNode);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        LC211WordDictionary wordDictionary = new LC211WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        // false
        // System.out.println(wordDictionary.search("pad"));
        // true
        // System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println();
        System.out.println(wordDictionary.search("b.."));
    }

}
