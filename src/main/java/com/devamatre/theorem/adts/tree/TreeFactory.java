package com.devamatre.theorem.adts.tree;

import com.devamatre.theorem.adts.tree.traversal.InOrderTraversal;
import com.devamatre.theorem.adts.tree.traversal.LevelOrderTraversal;
import com.devamatre.theorem.adts.tree.traversal.PostOrderTraversal;
import com.devamatre.theorem.adts.tree.traversal.PreOrderTraversal;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/27/2023 8:59 AM
 */
public enum TreeFactory {
    INSTANCE;

    /**
     * Returns the <code>TreeTraversal<E></code> object for the provided <code>traversalMode</code> type.
     *
     * @param rootNode
     * @param traversalMode
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> TreeTraversal<E> treeTraverser(Node<E> rootNode, TraversalMode traversalMode) {
        switch (traversalMode) {
            case PRE_ORDER_TRAVERSAL:
                return new PreOrderTraversal<>(rootNode);

            case POST_ORDER_TRAVERSAL:
                return new PostOrderTraversal<>(rootNode);

            case LEVEL_ORDER_TRAVERSAL:
                return new LevelOrderTraversal<>(rootNode);

            default:
                return new InOrderTraversal<>(rootNode);
        }
    }

}
