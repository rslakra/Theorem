package com.rslakra.theorem.adts.tree.iterator;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeIterator;

import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

/**
 * Iterator is the API interface. A class which implements Iterator should implement three methods
 * <p>
 * boolean hasNext() - Returns true if the iteration has more elements. Object next() - Returns the next element in the
 * iteration. void remove() - (optional operation) Removes from the underlying collection the last element returned by
 * next().
 * <p>
 * We implement a pre-order traversal by adding a new method iterator to the BSTree class. This method returns an
 * iterator over the nodes of a binary tree in pre-order.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public abstract class AbstractTreeIterator<E extends Comparable<? super E>> implements TreeIterator<E> {

    // node to be iterated.
    protected Node<E> rootNode;

    // stack
    protected Stack<Node<E>> stack = new Stack<>();

    /**
     * @param rootNode
     */
    protected AbstractTreeIterator(Node<E> rootNode) {
        this.rootNode = rootNode;
        if (rootNode != null) {
            pushLeft(rootNode);
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
     * @param rootNode
     */
    public abstract void pushLeft(Node<E> rootNode);

    /**
     * @return
     */
    @Override
    public Iterator<E> inOrderIterator() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> preOrderIterator() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> postOrderIterator() {
        return null;
    }

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * @return
     */
    @Override
    public Iterator<E> levelOrderIterator() {
        return null;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return Objects.toString(rootNode);
    }
}
