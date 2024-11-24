package com.rslakra.theorem.adts.tree.iterator;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeIterator;

import java.util.NoSuchElementException;

/**
 * Implements the level-order iterator of the tree.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class LevelOrderIterator<E extends Comparable<? super E>> extends AbstractTreeIterator<E>
    implements TreeIterator<E> {

    /**
     * @param node
     */
    public LevelOrderIterator(Node<E> node) {
        super(node);
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
     * @throws NoSuchElementException if the iteration has no more elements
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
