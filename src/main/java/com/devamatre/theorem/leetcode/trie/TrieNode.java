/**
 *
 */
package com.devamatre.theorem.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 7:07:05 PM
 */
public class TrieNode {

    private static final char ROOT = '-';
    private char keyChar;
    private Map<Character, TrieNode> children;
    private boolean endOfKey;

    /**
     * @param keyChar
     */
    public TrieNode(char keyChar) {
        this.keyChar = keyChar;
        children = new HashMap<>();
        endOfKey = false;
    }

    /**
     *
     */
    public TrieNode() {
        this(ROOT);
    }

    /**
     * @return
     */
    public char getKeyChar() {
        return keyChar;
    }

    /**
     * @return
     */
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * @return
     */
    protected int size() {
        return children.size();
    }

    /**
     * Returns the children value;
     *
     * @return children
     */
    public TrieNode getKeyNode(char key) {
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
     * @param rootNode
     */
    public void addNode(char key, TrieNode rootNode) {
        children.put(key, rootNode);
    }

    /**
     * Returns the end value;
     *
     * @return end
     */
    public boolean isEndOfKey() {
        return endOfKey;
    }

    /**
     * The end to be set.
     *
     * @param endOfKey
     */
    public void setEndOfKey(boolean endOfKey) {
        this.endOfKey = endOfKey;
    }

    /**
     * @param rootNode
     * @return
     */
    public String toString(TrieNode rootNode) {
        StringBuilder strBuilder = new StringBuilder();
        if (rootNode != null) {
            if (rootNode.getChildren().isEmpty()) {
                strBuilder.append("[]");
            } else {
                int index = 0;
                for (Character trieKey : rootNode.getChildren().keySet()) {
                    StringBuilder nodeBuilder = new StringBuilder("[");
                    nodeBuilder.append(trieKey);
                    TrieNode keyNode = rootNode.getKeyNode(trieKey);
                    nodeBuilder.append(", ").append(toString(keyNode));
                    nodeBuilder.append(", ").append(keyNode.endOfKey);
                    nodeBuilder.append("]");
                    strBuilder.append(nodeBuilder);
                    if (index < rootNode.size() - 1) {
                        strBuilder.append(", ");
                    }
                    index++;
                }
            }
        } else {
        }

        return strBuilder.toString();
    }

    /**
     * Returns string.
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("[").append(toString(this)).append("]").toString();
    }

}
