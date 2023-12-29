package com.devamatre.theorem.adts.tree.parser;

import com.devamatre.theorem.adts.array.ArrayUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeFactory;
import com.devamatre.theorem.adts.tree.TreeTraversal;

import java.util.List;

/**
 * The <code>PreOrderTreeParser</code>.
 *
 * <pre>(RootNode -> LeftNode -> RightNode)</pre>
 *
 * @author Rohtash Lakra
 * @created 11/25/23 4:18 PM
 */
public class PreOrderTreeParser<E extends Comparable<? super E>> extends AbstractTreeParser<E> {

    /**
     * Handles the preOrder operations.
     */
    public PreOrderTreeParser() {
        super(TraversalMode.PRE_ORDER_TRAVERSAL);
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
        ArrayUtils.replaceNullWithMinus(data);
        return ArrayUtils.toIntArray(data);
    }

}
