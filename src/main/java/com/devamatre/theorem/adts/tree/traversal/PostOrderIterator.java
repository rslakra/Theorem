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
public class PostOrderIterator<E extends Comparable<? super E>> extends AbstractTreeIterator<E> implements TreeIterator<E> {

    /**
     * @param node
     */
    public PostOrderIterator(Node<E> node) {
        super(node);
    }

    /**
     * Pushes the left nodes to stack.
     *
     * @param node
     */
    @Override
    public void pushLeft(Node<E> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        if (stack.isEmpty()) {
            return;
        }

        node = stack.peek();
        if (node.hasRight()) {
            pushLeft(node.getRight());
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
    public Node<E> next() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> popNode = stack.pop();
        if (hasNext()) {
            Node<E> peekNode = stack.peek();
            if (popNode != peekNode.getRight()) {
                pushLeft(peekNode.getRight());
            }
        }

        return popNode;
    }
}
