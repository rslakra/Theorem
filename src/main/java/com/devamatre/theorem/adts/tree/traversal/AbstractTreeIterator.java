package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TreeIterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 10/18/23 1:57 PM
 */
public abstract class AbstractTreeIterator implements TreeIterator {

    // node to be iterated.
    protected Node node;

    // stack
    protected Stack<Node> stack = new Stack<>();

    /**
     * @param node
     */
    protected AbstractTreeIterator(Node node) {
        this.node = node;
        if (node != null) {
            pushLeft(node);
        }
    }

    /**
     * @return
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /**
     * We shall leave the method remove() unimplemented. Since a binary tree has a nonlinear structure, removing a node
     * might cause the major tree rearrangement, which will lead to incorrect output from next():
     *
     * @see java.util.Iterator#remove()
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return
     */
    protected boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes the left nodes to stack.
     *
     * @param node
     */
    public abstract void pushLeft(Node node);

    /**
     * @return
     */
    @Override
    public Iterator<Node> inOrderIterator() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node> preOrderIterator() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node> postOrderIterator() {
        return null;
    }

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * @return
     */
    @Override
    public Iterator<Node> levelOrderIterator() {
        return null;
    }
}
