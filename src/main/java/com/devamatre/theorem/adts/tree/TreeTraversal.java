package com.devamatre.theorem.adts.tree;

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
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     *
     * @return
     */
    List<Node<E>> treeNodesTraversal();

    /**
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    default List<E> treeTraversal() {
        final List<E> treeTraversal = new ArrayList<>();
        final List<Node<E>> treeNodesTraversal = treeNodesTraversal();
        if (treeNodesTraversal != null) {
            treeNodesTraversal.forEach(node -> treeTraversal.add(node.getData()));
        }

        return treeTraversal;
    }

}
