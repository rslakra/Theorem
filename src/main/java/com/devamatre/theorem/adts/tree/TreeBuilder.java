package com.devamatre.theorem.adts.tree;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/19/23 9:48 AM
 */
public interface TreeBuilder<E extends Comparable<? super E>> {

    /**
     * Returns the <code>TraversalMode</code> of the tree parser.
     *
     * @return
     */
    TraversalMode getTraversalMode();

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    Node<E> buildBinaryTree(List<E> inputData);

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> array.
     *
     * @param inputData
     * @return
     */
    Node<E> buildBinaryTree(E[] inputData);

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    Node<E> buildHierarchicalTree(List<E> inputData);

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> array.
     *
     * @param inputData
     * @return
     */
    Node<E> buildHierarchicalTree(E[] inputData);

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    Node<E> buildTree(List<E> inputData);

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> array.
     *
     * @param inputData
     * @return
     */
    Node<E> buildTree(E[] inputData);

}
