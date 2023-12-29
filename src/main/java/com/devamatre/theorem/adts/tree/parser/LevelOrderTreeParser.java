package com.devamatre.theorem.adts.tree.parser;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 12/13/23 4:16 PM
 */
public class LevelOrderTreeParser<E extends Comparable<? super E>> extends AbstractTreeParser<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LevelOrderTreeParser.class);

    /**
     * Handles the preOrder operations.
     */
    public LevelOrderTreeParser() {
        super(TraversalMode.LEVEL_ORDER_TRAVERSAL);
        LOGGER.debug("LevelOrderTreeParser()");
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
    public E[] parse(Node<E> rootNode, boolean includeNullLeafs) {
        return null;
    }
}
