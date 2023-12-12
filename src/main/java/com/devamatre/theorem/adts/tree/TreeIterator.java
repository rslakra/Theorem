package com.devamatre.theorem.adts.tree;

import java.util.Iterator;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public interface TreeIterator<E extends Comparable<? super E>> extends Iterator<Node<E>> {

    /**
     * Time Complexity: <code>O(N)</code>
     *
     * @return
     */
    Iterator<Node<E>> inOrderIterator();

    /**
     * Time Complexity: <code>O(N)</code>
     *
     * @return
     */
    Iterator<Node<E>> preOrderIterator();

    /**
     * Time Complexity: <code>O(N)</code>
     *
     * @return
     */
    Iterator<Node<E>> postOrderIterator();

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * Time Complexity: <code>O(N)</code>
     *
     * @return
     */
    Iterator<Node<E>> levelOrderIterator();

}
