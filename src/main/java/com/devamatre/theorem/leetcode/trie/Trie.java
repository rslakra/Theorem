/**
 *
 */
package com.devamatre.theorem.leetcode.trie;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 7:12:12 PM
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('-');
    }

    /**
     * @return
     */
    public TrieNode getRoot() {
        return root;
    }

    /**
     * @param input
     */
    public void addNode(String input) {
        TrieNode trieNode = getRoot();
        for (int i = 0; i < input.length(); i++) {
            char keyChar = input.charAt(i);
            if (!trieNode.contains(keyChar)) {
                trieNode.addNode(keyChar, new TrieNode(keyChar));
            }
            trieNode = trieNode.getKeyNode(keyChar);
        }
        trieNode.setEndOfKey(true);
    }

    /**
     * @param key
     * @return
     */
    public TrieNode getNode(char key) {
        return getRoot().getKeyNode(key);
    }

    /**
     * @return
     */
    public int size() {
        return getRoot().size();
    }

}
