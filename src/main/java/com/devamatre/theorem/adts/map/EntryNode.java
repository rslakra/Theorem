package com.devamatre.theorem.adts.map;

import lombok.Data;

/**
 * @author Rohtash Lakra
 * @created 10/16/23 3:51 PM
 */
@Data
public class EntryNode<K, V> {

    private K key;
    private V value;
    private EntryNode next;

    /**
     * @param key
     * @param value
     * @param nextNode
     */
    public EntryNode(K key, V value, EntryNode nextNode) {
        this.key = key;
        this.value = value;
        if (nextNode != null) {
            this.next = nextNode;
            nextNode.next = null;
        } else {
            this.next = null;
        }
    }
}
