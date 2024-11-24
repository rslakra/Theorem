package com.rslakra.theorem.adts.trie;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-11 05:07:50 PM
 * @since 1.0.0
 */
public enum TrieUtils {
    INSTANCE;

    /**
     * Fills the <code>trieNode</code>  node with the provided <code>inputData</code> values.
     *
     * <pre>
     *  [and, bat, add, bag, cat, car]
     * </pre>
     *
     * @param trieNode
     * @param inputData
     */
    public static void fillTrieNode(TrieNode trieNode, List<String> inputData) {
        inputData.forEach(key -> trieNode.insert(key));
    }

    /**
     * Builds the <code>trie</code> with the given <code>list</code>
     *
     * @param list
     * @return
     */
    public static void fillTrie(final Trie trie, List<String> list) {
        list.forEach(key -> trie.insert(key));
    }

    /**
     * Builds the <code>trie</code> with the given <code>list</code>
     *
     * @param list
     * @return
     */
    public static Trie buildTrie(List<String> list) {
        final Trie trie = new MapTrie();
        fillTrie(trie, list);
        return trie;
    }
}
