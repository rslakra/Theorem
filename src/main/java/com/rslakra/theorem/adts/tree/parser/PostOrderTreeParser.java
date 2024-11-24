package com.rslakra.theorem.adts.tree.parser;

import com.rslakra.theorem.adts.array.ArrayUtils;
import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.TreeFactory;
import com.rslakra.theorem.adts.tree.TreeTraversal;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/26/23 4:58 PM
 */
public class PostOrderTreeParser<E extends Comparable<? super E>> extends AbstractTreeParser<E> {

    /**
     * Handles the preOrder operations.
     */
    public PostOrderTreeParser() {
        super(TraversalMode.POST_ORDER_TRAVERSAL);
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
        TreeTraversal treeTraverser = TreeFactory.treeTraverser(rootNode, getTraversalMode());
        List<E> data = treeTraverser.traverse(includeNullLeafs);
        ArrayUtils.replaceNullWithMinusOne(data);
        return (E[]) ArrayUtils.asIntArray(data);
    }

}
