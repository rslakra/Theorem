/**
 *
 */
package com.devamatre.theorem.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 7:07:05 PM
 */
public class TrieNode {

    private char key;
    private Map<Character, TrieNode> children;
    private boolean end;

    /**
     * @param key
     */
    public TrieNode(char key) {
        this.key = key;
        children = new HashMap<>();
        end = false;
    }

    /**
     * @return
     */
    public char getkey() {
        return key;
    }

    /**
     * @return
     */
    public int size() {
        return children.size();
    }

    /**
     * @return
     */
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    /**
     * Returns the children value;
     *
     * @return children
     */
    public TrieNode next(char key) {
        return children.get(key);
    }

    /**
     * @param key
     * @return
     */
    public boolean contains(char key) {
        return children.containsKey(key);
    }

    /**
     * @param key
     * @param newNode
     */
    public void addNode(char key, TrieNode newNode) {
        children.put(key, newNode);
    }

    /**
     * Returns the end value;
     *
     * @return end
     */
    public boolean isEnd() {
        return end;
    }

    /**
     * The end to be set.
     *
     * @param end
     */
    public void setEnd(boolean end) {
        this.end = end;
    }

}
