package com.devamatre.theorem.adts.tree.handler;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeType;
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
     * Converts the <code>rootNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param treeType
     * @param includeNullLeafs
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> rootNode, TreeType treeType, boolean includeNullLeafs) {
        return null;
    }
}
