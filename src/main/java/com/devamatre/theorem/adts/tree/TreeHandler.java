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
    Node<E> buildBinaryTree(E[] elements);

    /**
     * Returns the <code>treeNode</code> builds with an array of <code>E</code> data.
     *
     * @param elements
     * @return
     */
    Node<E> buildTree(E[] elements);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param treeType
     * @param includeNullLeafs
     * @return
     */
    E[] treeConverter(Node<E> rootNode, TreeType treeType, boolean includeNullLeafs);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type.
     *
     * @param rootNode
     * @param treeType
     * @return
     */
    E[] treeConverter(Node<E> rootNode, TreeType treeType);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    E[] treeConverter(Node<E> rootNode, boolean includeNullLeafs);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type.
     *
     * @param rootNode
     * @return
     */
    E[] treeConverter(Node<E> rootNode);

}
