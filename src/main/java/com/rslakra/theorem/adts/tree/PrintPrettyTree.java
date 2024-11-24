package com.rslakra.theorem.adts.tree;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 12/17/2018 1:36 PM
 * @since 1.0.0
 */
public interface PrintPrettyTree<E extends Comparable<? super E>> {

    /**
     * Prints the pretty tree of the <code>rootNode</code>.
     *
     * @param rootNode
     */
    public void printPrettyTree(Node<E> rootNode);

    /**
     * Prints the pretty tree of the <code>rootNode</code>.
     *
     * @param rootNode
     */
    public void printBinaryPrettyTree(Node<E> rootNode);
}
