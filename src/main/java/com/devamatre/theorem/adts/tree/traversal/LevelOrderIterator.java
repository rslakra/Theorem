package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TreeIterator;

import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra
 * @created 10/18/23 1:57 PM
 */
public class LevelOrderIterator extends AbstractTreeIterator implements TreeIterator {

    /**
     * @param node
     */
    public LevelOrderIterator(Node node) {
        super(node);
    }

    /**
     * Pushes the left nodes to stack.
     *
     * @param node
     */
    @Override
    public void pushLeft(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
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
    public Node next() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node current = stack.pop();
        pushLeft(current.getRight());
        return current;
    }
}
