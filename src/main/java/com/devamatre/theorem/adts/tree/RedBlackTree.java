package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.BeanUtils;
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
            int result = redBlackNode.getKey().compareTo(key);
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
     * Adds the new redBlackNode and balance the tree.
     * <p>
     * Balance Criteria:
     * <p>
     * 1. Right child red, left child black - rotate left.
     * <p>
     * 2. Left child, left-left grandchild red - rotate right. 3.
     * <p>
     * 3. Both children red - flip colors.
     *
     * @param redBlackNode
     * @param key
     * @param value
     * @return
     */
    private RedBlackNode addNode(RedBlackNode redBlackNode, K key, V value) {
        // add new redBlackNode here.
        if (BeanUtils.isNull(redBlackNode)) {
            return new RedBlackNode(key, value, RedBlackNode.RED);
        }

        // Replace current redBlackNode or add new redBlackNode as child.
        int result = redBlackNode.getKey().compareTo(key);
        if (result == 0) {
            redBlackNode.setValue(value);
        } else if (result < 0) {
            redBlackNode.setLeft(addNode(redBlackNode.getLeft(), key, value));
        } else if (result > 0) {
            redBlackNode.setRight(addNode(redBlackNode.getRight(), key, value));
        }

        // balance red-black tree.
        if (RedBlackNode.isRed(redBlackNode.getRight()) && !RedBlackNode.isRed(redBlackNode.getLeft())) {
            redBlackNode = RedBlackNode.rotateLeft(redBlackNode);
        } else if (RedBlackNode.isRed(redBlackNode.getLeft()) && RedBlackNode.isRed(redBlackNode.getLeft().getLeft())) {
            redBlackNode = RedBlackNode.rotateRight(redBlackNode);
        } else if (RedBlackNode.isRed(redBlackNode.getLeft()) && RedBlackNode.isRed(redBlackNode.getRight())) {
            RedBlackNode.flipColors(redBlackNode);
        }

        return redBlackNode;
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
