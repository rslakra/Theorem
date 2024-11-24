package com.rslakra.theorem.adts.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * To traverse binary trees with depth-first search, perform the following operations at each node:
 * <pre>
 *  If the current node is empty then return.
 *  Execute the following three operations in a certain order:
 *  - N: Visit the current node.
 *  - L: Recursively traverse the current node's left subtree.
 *  - R: Recursively traverse the current node's right subtree.
 * </pre>
 *
 * <url>https://en.wikipedia.org/wiki/Tree_traversal</url>
 *
 * @author Rohtash Lakra
 * @created 12/13/23 2:10 PM
 */
public interface TreeTraversal<E extends Comparable<? super E>> {

    /**
     * Returns the <code>TraversalMode</code> of the tree parser.
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
    List<Node<E>> traverseNodes(boolean includeNullLeafs);

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
    default List<E> traverse(boolean includeNullLeafs) {
        final List<E> treeTraversal = new ArrayList<>();
        final List<Node<E>> treeNodesTraversal = traverseNodes(includeNullLeafs);
        if (treeNodesTraversal != null) {
            treeNodesTraversal.forEach(node -> {
                // if traversal list contains null nodes, then just add null as value.
                if (Objects.isNull(node)) {
                    treeTraversal.add(null);
                } else {
                    treeTraversal.add(node.getData());
                }
            });
        }

        return treeTraversal;
    }

}
