package com.rslakra.theorem.adts.map;

import com.rslakra.appsuite.core.HashUtils;

/**
 * @author Rohtash Lakra
 * @created 11/12/20 11:42 AM
 */
public class HashTableWithLinklist<K extends Comparable<K>, V extends Comparable<V>> {

    private static final int BUCKETS = 97;
    private EntryNode[] entries = new EntryNode[BUCKETS];

    public HashTableWithLinklist() {
    }

    /**
     * @param key
     * @return
     */
    private int hashCode(K key) {
        return HashUtils.getHashIndex(key, BUCKETS);
    }

    /**
     * @param key
     * @return
     */
    public V get(K key) {
        int index = hashCode(key);
        for (EntryNode node = entries[index]; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                return (V) node.getValue();
            }
        }

        return null;
    }

    /**
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hashCode(key);
        for (EntryNode<K, V> node = entries[index]; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                entries[index].setValue(value);
                return;
            }
        }

        // always add at the beginning.
        entries[index] = new EntryNode(null, key, value, entries[index]);
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder("{");
        for (int index = 0; index < entries.length; index++) {
            EntryNode node = entries[index];
            if (node != null) {
                if (strBuilder.length() > 1) {
                    strBuilder.append(", ");
                }
                strBuilder.append(node.getKey()).append("=").append(node.getValue());
                EntryNode current = node.getNext();
                while (current != null) {
                    strBuilder.append(", ").append(current.getKey()).append("=").append(current.getValue());
                    current = current.getNext();
                }
            }
        }

        strBuilder.append("}");

        return strBuilder.toString();
    }
}
