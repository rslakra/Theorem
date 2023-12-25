package com.devamatre.theorem.adts.tree;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 11/16/23 9:16 PM
 */
public enum TraversalMode {

    /**
     * DFS - Visits the current node after visiting all nodes inside the left subtree, but before visiting any node
     * within the right subtree.
     *
     * <pre>(LeftNode -> RootNode -> RightNode)</pre>
     */
    IN_ORDER_TRAVERSAL,

    /**
     * BFS - Visits nodes level-by-level and in left-to-right fashion at the same level.
     * <pre>
     *  Level 1 (RootNode)
     *  Level 2 (LeftNode of RootNode and RightNode of RootNode)
     *  ...
     *  Level N
     * </pre>
     */
    LEVEL_ORDER_TRAVERSAL,

    /**
     * DFS - Visits the current node before visiting any nodes inside left or right subtrees.
     * <pre>(RootNode -> LeftNode -> RightNode)</pre>
     */
    PRE_ORDER_TRAVERSAL,

    /**
     * DFS - Visits the current node after visiting all the nodes of left and right subtrees.
     * <pre>(LeftNode -> RightNode -> RootNode)</pre>
     */
    POST_ORDER_TRAVERSAL,

    /**
     * The Boundary Traversal of a Tree includes:
     * <pre>
     *  left boundary (nodes on left excluding leaf nodes)
     *  leaves (consist of only the leaf nodes)
     *  right boundary (nodes on right excluding leaf nodes)
     * </pre>
     */
    BOUNDARY_TRAVERSAL,

    /**
     * In the Diagonal Traversal of a Tree, all the nodes in a single diagonal will be printed one by one.
     */
    DIAGONAL_TRAVERSAL;

    /**
     * Returns the <code>traversalMode</code>.
     *
     * @param traversalMode
     * @return
     */
    public static TraversalMode ofString(final String traversalMode) {
        return Arrays.stream(values())
            .filter(entry -> entry.name().equalsIgnoreCase(traversalMode))
            .findFirst()
            .orElse(null);
    }

    /**
     * @param traversalMode
     * @return
     */
    public static boolean isLevelOrderTraversal(TraversalMode traversalMode) {
        return (LEVEL_ORDER_TRAVERSAL == traversalMode);
    }
}
