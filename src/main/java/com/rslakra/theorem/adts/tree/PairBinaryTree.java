package com.rslakra.theorem.adts.tree;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 5/13/22 5:18 PM
 */
public class PairBinaryTree<K extends Comparable<K>, V extends Comparable<V>> {

    private PairNode<K, V> root;
    private int size;

    public PairBinaryTree() {
    }

    /**
     * @return
     */
    public PairNode<K, V> getRoot() {
        return root;
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds the <code>key</code>/<code>value</code> pair node to the binary tree.
     *
     * @param value
     * @return
     */
    protected void addNode(final PairNode<K, V> node, final V value) {
        // Case 1: value is less than the current node value
        if (value.compareTo(node.getValue()) < 0) {
            // if node has left child, add it to the left node
            if (node.hasLeft()) {
                addNode(node.getLeft(), value);
            } else {
                // there is no left child, make it the new left node
                node.setLeft(new PairNode(null, value));
                node.getLeft().setParent(node);
            }
        } else { // Case 2: Value is equal to or greater than the current value
            // if node has right child, add it to the right node
            if (node.hasRight()) {
                addNode(node.getRight(), value);
            } else {
                // there is no right child, make it the new right node
                node.setRight(new PairNode(null, value));
                node.getRight().setParent(node);
            }
        }
    }

    /**
     * Adds the <code>value</code> to the binary tree.
     *
     * @param value
     * @return
     */
    public void addNode(K key, V value) {
        // Case 1: The tree is empty - allocate the head
        if (Objects.isNull(getRoot())) {
            root = new PairNode<>(key, value);
        } else {
            // Case 2: The tree is not empty so find the right location to insert
            addNode(getRoot(), value);
        }

        //increment the node count
        size++;
    }

    /**
     * Finds and returns the first node containing the specified value. If the value is not found, returns null.  Also
     * returns the parent of the found node (or null) which is used in Remove.
     *
     * @param value
     * @return
     */
    protected PairNode findNode(K key, V value) {
        // find node's in the tree with the provided <code>value</code>
        PairNode current = getRoot();
        while (current != null) {
            int result = current.getValue().compareTo(value);
            if (result > 0) {
                // if the value is less than current, find in left.
                current = current.getLeft();
            } else if (result < 0) {
                // if the value is more than current, find in right.
                current = current.getRight();
            } else { // find a match
                break;
            }
        }

        return current;
    }

    protected PairNode findNode(K key) {
        return null;
    }

//    /**
//     * Determines if the specified value exists in the binary tree.
//     *
//     * @param value
//     * @return
//     */
//    public boolean contains(final V value) {
//        return (Objects.nonNull(getRoot()) && Objects.nonNull(findNode(value)));
//    }

    /**
     * Removes the first occurrence of the provided value from the tree.
     *
     * @param value
     */
    public boolean remove(K key, V value) {
        PairNode<K, V> current = findNode(key, value);
        if (Objects.isNull(current)) {
            return false;
        }

        // decrease the node count
        size--;

        // Get current's parent node
        final PairNode parent = current.getParent();
        // Case 1: If current node has no right child, then current's left replaces current node.
        if (!current.hasRight()) {
            if (parent == null) {
                root = current.getLeft();
            } else {
                if (parent.isGreaterThan(current)) {
                    /**
                     * if parent value is greater than current value make the current left child a left child of
                     * parent
                     */
                    parent.setLeft(current.getLeft());
                } else if (parent.isLessThan(current)) {
                    /**
                     * if parent value is less than current value make the current left child a right child of parent
                     */
                    parent.setRight(current.getLeft());
                }
            }
        } else if (current.hasRight() && !current.getRight().hasLeft()) {
            // Case 2: If current's right child has no left child, then current's right child replaces current
            current.getRight().setLeft(current.getLeft());

            if (parent == null) {
                root = current.getRight();
            } else {
                int result = parent.compareTo(current);
                if (result > 0) {
                    // if parent value is greater than current value
                    // make the current right child a left child of parent
                    parent.setLeft(current.getRight());
                } else if (result < 0) {
                    // if parent value is less than current value
                    // make the current right child a right child of parent
                    parent.setRight(current.getRight());

                }
            }
        } else { // Case 3: If current's right child has a left child, replace current with current's right child's left-most child

            // find the right's left-most child
            PairNode<K, V> leftMostParent = current.getRight();
            PairNode<K, V> leftMost = current.getRight().getLeft();

            while (leftMost.hasLeft()) {
                leftMostParent = leftMost;
                leftMost = leftMost.getLeft();
            }

            // the parent's left subtree becomes the leftmost's right subtree
            leftMostParent.setLeft(leftMost.getRight());

            // assign leftmost's left and right to current's left and right children
            leftMost.setLeft(current.getLeft());
            leftMost.setRight(current.getRight());

            if (parent == null) {
                root = leftMost;
            } else {
                int result = parent.compareTo(current);
                if (result > 0) {
                    // if parent value is greater than current value
                    // make leftmost the parent's left child
                    parent.setLeft(leftMost);
                } else if (result < 0) {
                    // if parent value is less than current value
                    // make leftmost the parent's right child
                    parent.setRight(leftMost);
                }
            }
        }

        return true;
    }

    /**
     * Removes all items from the tree
     */
    public void clear() {
        clear();
        root = null;
    }

}
