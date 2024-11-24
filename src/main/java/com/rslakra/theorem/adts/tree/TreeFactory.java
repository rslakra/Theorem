package com.rslakra.theorem.adts.tree;

import com.rslakra.theorem.adts.tree.builder.InOrderTreeBuilder;
import com.rslakra.theorem.adts.tree.builder.LevelOrderTreeBuilder;
import com.rslakra.theorem.adts.tree.builder.PostOrderTreeBuilder;
import com.rslakra.theorem.adts.tree.builder.PreOrderTreeBuilder;
import com.rslakra.theorem.adts.tree.parser.InOrderTreeParser;
import com.rslakra.theorem.adts.tree.parser.LevelOrderTreeParser;
import com.rslakra.theorem.adts.tree.parser.PostOrderTreeParser;
import com.rslakra.theorem.adts.tree.parser.PreOrderTreeParser;
import com.rslakra.theorem.adts.tree.traversal.InOrderTraversal;
import com.rslakra.theorem.adts.tree.traversal.LevelOrderTraversal;
import com.rslakra.theorem.adts.tree.traversal.PostOrderTraversal;
import com.rslakra.theorem.adts.tree.traversal.PreOrderTraversal;

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
    public static <E extends Comparable<? super E>> TreeTraversal<E> treeTraverser(Node<E> rootNode,
                                                                                   TraversalMode traversalMode) {
        switch (traversalMode) {
            case LEVEL_ORDER_TRAVERSAL:
                return new LevelOrderTraversal<>(rootNode);

            case PRE_ORDER_TRAVERSAL:
                return new PreOrderTraversal<>(rootNode);

            case POST_ORDER_TRAVERSAL:
                return new PostOrderTraversal<>(rootNode);

            case IN_ORDER_TRAVERSAL:
            default:
                return new InOrderTraversal<>(rootNode);
        }
    }

    /**
     * Returns the <code>TreeBuilder<E></code> object for the provided <code>traversalMode</code> type.
     *
     * @param traversalMode
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> TreeParser<E> treeParser(TraversalMode traversalMode) {
        switch (traversalMode) {
            case IN_ORDER_TRAVERSAL:
                return new InOrderTreeParser<>();

            case POST_ORDER_TRAVERSAL:
                return new PostOrderTreeParser<>();

            case LEVEL_ORDER_TRAVERSAL:
                return new LevelOrderTreeParser<>();

            default:
                return new PreOrderTreeParser<>();
        }
    }

    /**
     * Returns the <code>TreeBuilder<E></code> object for the provided <code>traversalMode</code> type.
     *
     * @param traversalMode
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> TreeBuilder<E> treeBuilder(TraversalMode traversalMode) {
        switch (traversalMode) {
            case IN_ORDER_TRAVERSAL:
                return new InOrderTreeBuilder<>();

            case POST_ORDER_TRAVERSAL:
                return new PostOrderTreeBuilder<>();

            case LEVEL_ORDER_TRAVERSAL:
                return new LevelOrderTreeBuilder<>();

            default:
                return new PreOrderTreeBuilder<>();
        }
    }

}
