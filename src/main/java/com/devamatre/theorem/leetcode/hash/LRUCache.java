/**
 *
 */
package com.devamatre.theorem.leetcode.hash;

import java.util.HashMap;

/**
 * @author Rohtash Lakra
 */
public class LRUCache {

    private final int capacity;
    private final HashMap<Integer, CacheNode> map;
    private CacheNode head;
    private CacheNode tail;

    /**
     * @param capacity
     */
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    /**
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }

        return -1;
    }

    /**
     * Removes the node in doubly linked list.
     *
     * @param node
     */
    private void remove(CacheNode node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }
    }

    /**
     * @param newNode
     */
    private void setHead(CacheNode newNode) {
        newNode.next = head;
        newNode.previous = null;

        if (head != null) {
            head.previous = newNode;
        }

        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            CacheNode newNode = new CacheNode(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }

    /**
     *
     */
    @Override
    public String toString() {
        return map.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        System.out.println(cache);
    }

}
