package com.devamatre.theorem.adts.tree;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 4:17 PM
 */
public interface TreeHandler<E extends Comparable<? super E>> {

    /**
     * Returns the <code>TraversalMode</code> of the tree handler.
     *
     * @return
     */
    TraversalMode getTraversalMode();

    /**
     * Returns the <code>treeNode</code> builds with an array of <code>E</code> data.
     *
     * @param elements
     * @return
     */
    Node<E> buildTree(E[] elements);

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param treeNode
     * @return
     */
    E[] treeConverter(Node<E> treeNode, boolean includeNullLeafs);

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type.
     *
     * @param treeNode
     * @return
     */
    E[] treeConverter(Node<E> treeNode);

}
