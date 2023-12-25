package com.devamatre.theorem.adts.tree;

import com.devamatre.theorem.adts.tree.traversal.InOrderTraversal;
import com.devamatre.theorem.adts.tree.traversal.LevelOrderTraversal;
import com.devamatre.theorem.adts.tree.traversal.PostOrderTraversal;
import com.devamatre.theorem.adts.tree.traversal.PreOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/13/23 2:10 PM
 */
public interface TreeTraversal<E extends Comparable<? super E>> {

    /**
     * Returns the <code>TraversalMode</code> of the tree handler.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    TraversalMode getTraversalMode();

    /**
     * Traverses the <code>treeType</code> tree with the provided <code>includeNullLeafs</code> in the
     * <code>TraversalMode</code> traversal.
     *
     * @return
     */
    List<Node<E>> traverseNodes(TreeType treeType, boolean includeNullLeafs);

    /**
     * Traverses the <code>treeType</code> tree with the provided <code>includeNullLeafs</code> in the
     * <code>TraversalMode</code> traversal.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    default List<E> traverse(TreeType treeType, boolean includeNullLeafs) {
        final List<E> treeTraversal = new ArrayList<>();
        final List<Node<E>> treeNodesTraversal = traverseNodes(treeType, includeNullLeafs);
        if (treeNodesTraversal != null) {
            treeNodesTraversal.forEach(node -> treeTraversal.add(node.getData()));
        }

        return treeTraversal;
    }

    /**
     * Returns the <code>TreeTraversal<E></code> object for the provided <code>traversalMode</code> type.
     *
     * @param traversalMode
     * @param rootNode
     * @param <E>
     * @return
     */
    static <E extends Comparable<? super E>> TreeTraversal<E> treeTraverser(TraversalMode traversalMode,
                                                                            Node<E> rootNode) {
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
