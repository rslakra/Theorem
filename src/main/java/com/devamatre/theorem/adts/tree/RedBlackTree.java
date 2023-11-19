package com.devamatre.theorem.adts.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Rohtash Lakra
 * @created 8/17/20 3:34 PM
 */
@Getter
@NoArgsConstructor
public class RedBlackTree<K extends Comparable, V extends Comparable> {

    private RedBlackNode<K, V> root;

    /**
     * Returns the value for the key.
     *
     * @param key
     * @return
     */
    public V get(K key) {
        RedBlackNode<K, V> redBlackNode = root;
        while (redBlackNode != null) {
            int result = key.compareTo(redBlackNode.getKey());
            if (result < 0) {
                redBlackNode = redBlackNode.getLeft();
            } else if (result > 0) {
                redBlackNode = redBlackNode.getRight();
            } else {
                return redBlackNode.getValue();
            }
        }

        return null;
    }

    /**
     * Adds the new node and balance the tree.
     * <p>
     * Balance Criteria:
     * <p>
     * 1. Right child red, left child black - rotate left.
     * <p>
     * 2. Left child, left-left grandchild red - rotate right. 3.
     * <p>
     * 3. Both children red - flip colors.
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private RedBlackNode addNode(RedBlackNode node, K key, V value) {
        // add new node here.
        if (node == null) {
            return new RedBlackNode(key, value, RedBlackNode.RED);
        }

        //Replace current node or add new node as child.
        int result = key.compareTo(node.getKey());
        if (result == 0) {
            node.setValue(value);
        } else if (result < 0) {
            node.setLeft(addNode(node.getLeft(), key, value));
        } else if (result > 0) {
            node.setRight(addNode(node.getRight(), key, value));
        }

        //balance red-black tree.
        if (RedBlackNode.isRed(node.getRight()) && !RedBlackNode.isRed(node.getLeft())) {
            node = RedBlackNode.rotateLeft(node);
        } else if (RedBlackNode.isRed(node.getLeft()) && RedBlackNode.isRed(node.getLeft().getLeft())) {
            node = RedBlackNode.rotateRight(node);
        } else if (RedBlackNode.isRed(node.getLeft()) && RedBlackNode.isRed(node.getRight())) {
            RedBlackNode.flipColors(node);
        }

        return node;
    }

    /**
     * Adds the new node at the right place.
     *
     * @param key
     * @param value
     */
    public void addNode(K key, V value) {
        root = addNode(root, key, value);
    }

}
