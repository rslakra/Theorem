package com.devamatre.theorem.adts.trie;

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
     * Returns the size of the trie trieNode.
     *
     * @param trieNode
     * @return
     */
    public static int getSize(TrieNode trieNode) {
        int size = 0;
        if (trieNode != null) {
            for (Character key : trieNode.getChildren().keySet()) {
                size += getSize(trieNode.getChildren().get(key)) + 1;
            }
        }

        return size;
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
        final Trie trie = new TrieMap();
        fillTrie(trie, list);
        return trie;
    }
}
