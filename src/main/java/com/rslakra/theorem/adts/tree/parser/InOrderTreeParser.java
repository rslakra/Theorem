package com.rslakra.theorem.adts.tree.parser;

import com.rslakra.theorem.adts.array.ArrayUtils;
import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.TreeFactory;
import com.rslakra.theorem.adts.tree.TreeTraversal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/26/23 4:58 PM
 */
public class InOrderTreeParser<E extends Comparable<? super E>> extends AbstractTreeParser<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InOrderTreeParser.class);

    /**
     * Handles the preOrder operations.
     */
    public InOrderTreeParser() {
        super(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("InOrderTreeParser()");
    }

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public E[] parse(Node<E> rootNode, boolean includeNullLeafs) {
        TreeTraversal treeTraverser = TreeFactory.treeTraverser(rootNode, getTraversalMode());
        List<E> inputData = treeTraverser.traverse(includeNullLeafs);
        ArrayUtils.replaceNullWithMinusOne(inputData);
        return (E[]) ArrayUtils.asIntArray(inputData);
    }

}
