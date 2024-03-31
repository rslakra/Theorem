/**
 *
 */
package com.devamatre.theorem.leetcode.trie;

/**
 * @author Rohtash Lakra
 */
public final class CommonPrefix {

    private Trie trie;

    public CommonPrefix() {
        trie = new Trie();
    }

    /**
     * @param inputs
     */
    private String buildTrie(String[] inputs) {
        String smallString = "";
        if (inputs != null) {
            for (int i = 0; i < inputs.length; i++) {
                if (i == 0 || inputs[i].length() < smallString.length()) {
                    smallString = inputs[i];
                }
                trie.insert(inputs[i]);
            }
        }

        return smallString;
    }

    /**
     * https://leetcode.com/problems/longest-common-prefix/
     * <p>
     * Problem #14
     * <p>
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     *
     * <pre>
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * </pre>
     * <p>
     * Example 2:
     *
     * <pre>
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * </pre>
     * <p>
     * Note:
     * <p>
     * All given inputs are in lowercase letters a-z.
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String longestCommonPrefix = "";
        String smallString = buildTrie(strs);
        Trie.TrieNode node = trie.getRootNode();
        for (int i = 0; i < smallString.length(); i++) {
            node = node.getNode(smallString.charAt(i));
            longestCommonPrefix += smallString.charAt(i);
            if (node.size() > 1) {
                break;
            }
        }

        return longestCommonPrefix;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CommonPrefix prefix = new CommonPrefix();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(prefix.longestCommonPrefix(strs));
    }

}
