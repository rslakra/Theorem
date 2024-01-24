/**
 *
 */
package com.devamatre.theorem.leetcode.tree;

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
     * @param str
     */
    public void addNode(String str) {
        TrieNode node = getRoot();
        for (int i = 0; i < str.length(); i++) {
            char keyChar = str.charAt(i);
            if (!node.contains(keyChar)) {
                node.addNode(keyChar, new TrieNode(keyChar));
            }
            node = node.next(keyChar);
        }
        node.setEnd(true);
    }

    /**
     * @param key
     * @return
     */
    public TrieNode getNode(char key) {
        return getRoot().next(key);
    }

    /**
     * @return
     */
    public int size() {
        return getRoot().size();
    }

}
