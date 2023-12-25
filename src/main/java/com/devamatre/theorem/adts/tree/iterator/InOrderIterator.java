package com.devamatre.theorem.adts.tree.iterator;

import com.devamatre.theorem.adts.tree.Node;

import java.util.NoSuchElementException;

/**
 * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
 * <p>
 * Until all nodes are traversed:
 * <pre>
 * Step 1 − Recursively traverse left subtree.
 * Step 2 − Visit root node.
 * Step 3 − Recursively traverse right subtree.
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class InOrderIterator<E extends Comparable<? super E>> extends AbstractTreeIterator<E> {

    /**
     * @param rootNode
     */
    public InOrderIterator(Node<E> rootNode) {
        super(rootNode);
    }

    /**
     * Pushes the left nodes to stack.
     *
     * @param rootNode
     */
    @Override
    public void pushLeft(Node<E> rootNode) {
        while (rootNode != null) {
            stack.push(rootNode);
            rootNode = rootNode.getLeft();
        }
    }

    /**
     * Returns the next element in the iteration.
     * <p>
     * If there is a left child, we push the child on a stack and return a parent node. If there is no left child, we
     * check for a right child. If there is a right child, we push the right child on a stack and return a parent node.
     * If there is no right child, we move back up the tree (while-loop) until we find a node with a right child.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> nextNode = stack.pop();
        pushLeft(nextNode.getRight());
        return nextNode.getData();
    }

}
