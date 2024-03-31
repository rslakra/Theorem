/**
 *
 */
package com.devamatre.theorem.leetcode.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 7:12:12 PM
 */
public class Trie {

    private static final char ROOT = '-';

    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode(ROOT);
    }

    /**
     * @return
     */
    public TrieNode getRootNode() {
        return rootNode;
    }

    /**
     * @param word
     */
    public void insert(String word) {
        TrieNode keyNode = getRootNode();
        for (char keyChar : word.toCharArray()) {
            if (!keyNode.contains(keyChar)) {
                keyNode.addNode(keyChar, new TrieNode(keyChar));
            }
            keyNode = keyNode.getNode(keyChar);
        }
        keyNode.setEnds(true);
    }

    /**
     * Insert words.
     *
     * @param words
     */
    public void insert(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    /**
     * Returns true if the word exists otherwise false.
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode trieNode = rootNode;
        for (char keyChar : word.toCharArray()) {
            if (!trieNode.contains(keyChar)) {
                return false;
            }
            trieNode = trieNode.getNode(keyChar);
        }

        return trieNode.isEnds();
    }

    /**
     * @param key
     * @return
     */
    public TrieNode getNode(char key) {
        return getRootNode().getNode(key);
    }

    /**
     * @return
     */
    public int size() {
        return getRootNode().size();
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder rootBuilder = new StringBuilder("[");
        TrieNode.toString(rootNode, rootBuilder);
        return rootBuilder.append("]").toString();
    }

    /**
     * TrieNode
     */
    static class TrieNode {

        private char keyChar;
        private Map<Character, TrieNode> children;
        private boolean ends;

        /**
         * @param keyChar
         */
        public TrieNode(char keyChar) {
            this.keyChar = keyChar;
            children = new HashMap<>();
            ends = false;
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
        public TrieNode getNode(char keyChar) {
            return children.get(keyChar);
        }

        /**
         * @param keyChar
         * @return
         */
        public boolean contains(char keyChar) {
            return children.containsKey(keyChar);
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
        public boolean isEnds() {
            return ends;
        }

        /**
         * The end to be set.
         *
         * @param ends
         */
        public void setEnds(boolean ends) {
            this.ends = ends;
        }

        /**
         * @param rootNode
         * @return
         */
        static void toString(TrieNode rootNode, StringBuilder rootBuilder) {
            if (Objects.isNull(rootNode) || rootNode.getChildren().isEmpty()) {
                rootBuilder.append("[]");
            } else {
                int index = 0;
                for (Character keyChar : rootNode.getChildren().keySet()) {
                    StringBuilder childBuilder = new StringBuilder("[");
                    childBuilder.append(keyChar);
                    TrieNode keyNode = rootNode.getNode(keyChar);
                    StringBuilder keyBuilder = new StringBuilder();
                    toString(keyNode, keyBuilder);
                    childBuilder.append(", ").append(keyBuilder);
                    childBuilder.append(", ").append(keyNode.isEnds());
                    childBuilder.append("]");
                    rootBuilder.append(childBuilder);
                    if (index < rootNode.size() - 1) {
                        rootBuilder.append(", ");
                    }
                    index++;
                }
            }
        }

        /**
         * Returns string.
         *
         * @return
         */
        @Override
        public String toString() {
            StringBuilder rootBuilder = new StringBuilder();
            TrieNode.toString(this, rootBuilder);
            return rootBuilder.toString();
        }
    }

}
