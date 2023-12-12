package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TreeIterator;

import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class PreOrderIterator<E extends Comparable<? super E>> extends AbstractTreeIterator<E> implements TreeIterator<E> {

    /**
     * @param node
     */
    public PreOrderIterator(Node<E> node) {
        super(node);
    }

    /**
     * Pushes the left nodes to stack.
     * <p>
     * If there is a left child, we push the child on a stack and return a parent node. If there is no left child, we
     * check for a right child. If there is a right child, we push the right child on a stack and return a parent node.
     * If there is no right child, we move back up the tree (while-loop) until we find a node with a right child.
     *
     * @param node
     */
    @Override
    public void pushLeft(Node<E> node) {
        if (node != null) {
            stack.push(node);
        }
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Node<E> next() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> current = stack.peek();
        if (current != null) {
            if (current.hasLeft()) {
                stack.push(current.getLeft());
            } else {
                Node<E> popNode = stack.pop();
                while (popNode.getRight() == null) {
                    if (stack.isEmpty()) {
                        return current;
                    }
                    popNode = stack.pop();
                }

                stack.push(popNode.getRight());
            }
        }

        return current;
    }
}
