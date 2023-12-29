package com.devamatre.theorem.adts.tree;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 4:17 PM
 */
public interface TreeParser<E extends Comparable<? super E>> {

    /**
     * Returns the <code>TraversalMode</code> of the tree parser.
     *
     * @return
     */
    TraversalMode getTraversalMode();

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    E[] parse(Node<E> rootNode, boolean includeNullLeafs);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type.
     *
     * @param rootNode
     * @return
     */
    E[] parse(Node<E> rootNode);

}
