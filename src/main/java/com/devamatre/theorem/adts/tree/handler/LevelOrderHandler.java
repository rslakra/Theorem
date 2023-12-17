package com.devamatre.theorem.adts.tree.handler;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 12/13/23 4:16 PM
 */
public class LevelOrderHandler<E extends Comparable<? super E>> extends AbstractTreeHandler<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LevelOrderHandler.class);

    /**
     * Handles the preOrder operations.
     */
    public LevelOrderHandler() {
        super(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("LevelOrderHandler()");
    }

    /**
     * Returns the <code>treeNode</code> builds with an array of <code>E</code> data.
     *
     * @param elements
     * @return
     */
    @Override
    public Node<E> buildTree(E[] elements) {
        return null;
    }

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param treeNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> treeNode, boolean includeNullLeafs) {
        return null;
    }

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type.
     *
     * @param treeNode
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> treeNode) {
        return null;
    }


}
