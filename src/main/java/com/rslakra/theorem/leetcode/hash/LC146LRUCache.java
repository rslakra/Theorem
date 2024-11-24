package com.rslakra.theorem.leetcode.hash;

import com.rslakra.theorem.adts.map.EntryNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <url>https://leetcode.com/problems/lru-cache</url>
 *
 * @author Rohtash Lakra
 * @created 1/12/24 10:27 AM
 */
public class LC146LRUCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC146LRUCache.class);
    private Map<Integer, EntryNode<Integer, Integer>> cache = new HashMap<>();
    private EntryNode<Integer, Integer> head;
    private EntryNode<Integer, Integer> tail;
    private int capacity;

    /**
     * @param capacity
     */
    public LC146LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return
     */
    private boolean checkEviction() {
        return (cache.size() >= capacity);
    }

    /**
     * @param key
     * @return
     */
    public int get(int key) {
        return moveToFront(key).getValue();
    }

    /**
     * Adds the new node in the cache and also adds that node as the head of the queue.
     *
     * @param newNode
     */
    private void addHead(EntryNode<Integer, Integer> newNode) {
        LOGGER.debug("+addHead({})", newNode);
        if (Objects.nonNull(head)) {
            newNode.setNext(head);
        }

        head = newNode;
        // check head and tail points to same node in the beginning
        if (Objects.isNull(tail)) {
            tail = head;
        }
        // add in the cache
        cache.put(newNode.getKey(), newNode);
        LOGGER.debug("-addHead(), newNode:{}, size:{}", newNode, cache.size());
    }

    /**
     * Returns the current entry if exists and moves that entry as the head of the queue.
     *
     * @param key
     */
    private EntryNode<Integer, Integer> moveToFront(int key) {
        LOGGER.debug("+moveToFront({})", key);
        EntryNode<Integer, Integer> currNode = new EntryNode<>(key, -1);
        if (cache.containsKey(key)) {
            currNode = cache.get(key);
            // if the accessed node is already a head node, nothing to do
            if (head != currNode) {
                if (currNode.hasPrevious()) {
                    currNode.getPrevious().setNext(currNode.getNext());
                    // if the last node is the accessed node, change the last node pointer
                    if (tail == currNode) {
                        tail = currNode.getPrevious();
                    }
                    // make sure this node has no references
                    currNode.setPrevious(null);
                    currNode.setNext(null);
                }

                // remove from queue
                currNode.setNext(head);
                head = currNode;
            }
        }

        LOGGER.debug("-moveToFront(), currNode:{}, size:{}", currNode, cache.size());
        return currNode;
    }

    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        LOGGER.debug("+put({}, {})", key, value);
        EntryNode<Integer, Integer> currNode = null;
        // if the key already in the cache (means cache hit), just mark the key as the latest
        if (cache.containsKey(key)) {
            currNode = moveToFront(key);
            // update the current node value if different
            if (currNode.getValue() != value) {
                currNode.setValue(value);
            }
            LOGGER.debug("Updated currNode:{}, size:{}", currNode, cache.size());
        } else {
            // if the key doesn't exist in the cache (means cache miss), then move the accessed key as the latest
            if (checkEviction()) {
                currNode = tail;
                if (currNode.hasPrevious()) {
                    currNode.getPrevious().setNext(null);
                    tail = currNode.getPrevious();
                    currNode.setPrevious(null);
                    currNode.setNext(null);
                }

                // if only 1 key in the cache, both head and tail points to the same.
                if (Objects.isNull(tail)) {
                    // head should be null as well.
                    head = tail;
                }
                // remove from cache and queue
                cache.remove(currNode.getKey());
                LOGGER.debug("Removed currNode:{}, size:{}", currNode, cache.size());
            }

            // add new key in the cache
            addHead(new EntryNode<>(key, value));
        }

        LOGGER.debug("-put(), size:{}", cache.size());
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return EntryNode.toString(head);
    }
}
