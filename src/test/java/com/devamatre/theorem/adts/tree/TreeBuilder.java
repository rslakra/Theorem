package com.devamatre.theorem.adts.tree;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/19/23 9:48 AM
 */
public interface TreeBuilder<E extends Comparable<? super E>> {

    /**
     * Builds the tree with the <code>inputData</code>.
     *
     * @param inputData
     * @return
     */
    public Node<E> buildTree(List<E> inputData);

    /**
     * Builds the tree with the <code>inputData</code>.
     *
     * @param inputData
     * @return
     */
    public Node<E> buildBinaryTree(List<E> inputData);

    /**
     *
     * @param inputData
     * @return
     */
    public Node<E> buildHierarchicalTree(List<E> inputData);

}
