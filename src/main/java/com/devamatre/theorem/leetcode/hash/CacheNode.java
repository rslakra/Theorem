package com.devamatre.theorem.leetcode.hash;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/20/2024 5:02 PM
 */
public class CacheNode {

    int key;
    int value;
    CacheNode next;
    CacheNode previous;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CacheNode[" + key + "-" + value + "]";
    }
}
