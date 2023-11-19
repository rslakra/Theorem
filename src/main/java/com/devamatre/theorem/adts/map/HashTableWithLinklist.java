package com.devamatre.theorem.adts.map;

import com.devamatre.appsuite.core.HashUtils;

/**
 * @author Rohtash Lakra
 * @created 11/12/20 11:42 AM
 */
public class HashTableWithLinklist<Key, Value> {

    private static final int BUCKETS = 97;
    private EntryNode[] entryNodes = new EntryNode[BUCKETS];

    public HashTableWithLinklist() {
    }

    /**
     * @param key
     * @return
     */
    private int hashCode(Key key) {
        return HashUtils.getHashIndex(key, BUCKETS);
    }

    /**
     * @param key
     * @return
     */
    public Value get(Key key) {
        int index = hashCode(key);
        for (EntryNode node = entryNodes[index]; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                return (Value) node.getValue();
            }
        }

        return null;
    }

    /**
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        int index = hashCode(key);
        for (EntryNode node = entryNodes[index]; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                entryNodes[index].setValue(value);
                return;
            }
        }
        // always add at the beginning.
        entryNodes[index] = new EntryNode(key, value, entryNodes[index]);
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder strBuilder = new StringBuilder("{");
        for (int index = 0; index < entryNodes.length; index++) {
            EntryNode node = entryNodes[index];
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
