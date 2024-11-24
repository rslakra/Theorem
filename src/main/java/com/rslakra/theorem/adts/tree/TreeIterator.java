package com.rslakra.theorem.adts.tree;

import java.util.Iterator;

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
public interface TreeIterator<E extends Comparable<? super E>> extends Iterator<E> {

    /**
     * Iterates the tree in the in-order traversal (or Breadth First Search)/BFS
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    Iterator<E> inOrderIterator();

    /**
     * Iterates the tree in the pre-order traversal (or Breadth First Search)/BFS
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    Iterator<E> preOrderIterator();

    /**
     * Iterates the tree in the post-order traversal (or Breadth First Search)/BFS
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    Iterator<E> postOrderIterator();

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     * <p>
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    Iterator<E> levelOrderIterator();

}
