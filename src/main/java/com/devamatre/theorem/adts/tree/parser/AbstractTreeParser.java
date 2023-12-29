package com.devamatre.theorem.adts.tree.parser;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeParser;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 4:26 PM
 */
public abstract class AbstractTreeParser<E extends Comparable<? super E>> implements TreeParser<E> {

    private TraversalMode traversalMode;

    /**
     * The default constructor
     *
     * @param traversalMode
     */
    public AbstractTreeParser(TraversalMode traversalMode) {
        super();
        this.traversalMode = traversalMode;
    }

    /**
     * Returns the <code>TraversalMode</code> of the tree parser.
     *
     * @return
     */
    @Override
    public TraversalMode getTraversalMode() {
        return traversalMode;
    }

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public abstract E[] parse(Node<E> rootNode, boolean includeNullLeafs);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type.
     *
     * @param rootNode
     * @return
     */
    @Override
    public E[] parse(Node<E> rootNode) {
        return parse(rootNode, false);
    }

}
