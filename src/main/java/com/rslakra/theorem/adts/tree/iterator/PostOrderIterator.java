package com.rslakra.theorem.adts.tree.iterator;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeIterator;

import java.util.NoSuchElementException;

/**
 * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class PostOrderIterator<E extends Comparable<? super E>> extends AbstractTreeIterator<E>
    implements TreeIterator<E> {

    /**
     * @param node
     */
    public PostOrderIterator(Node<E> node) {
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

        if (stack.isEmpty()) {
            return;
        }

        rootNode = stack.peek();
        if (rootNode.hasRight()) {
            pushLeft(rootNode.getRight());
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
        if (hasNext()) {
            Node<E> peekNode = stack.peek();
            if (nextNode != peekNode.getRight()) {
                pushLeft(peekNode.getRight());
            }
        }

        return nextNode.getData();
    }

}
