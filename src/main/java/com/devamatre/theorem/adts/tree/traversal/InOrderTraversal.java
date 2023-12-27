package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
 * <p>
 * Until all nodes are traversed:
 * <pre>
 * Step 1 − Recursively traverse left subtree.
 * Step 2 − Visit root node.
 * Step 3 − Recursively traverse right subtree.
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class InOrderTraversal<E extends Comparable<? super E>> extends AbstractTreeTraversal<E> {

    /**
     * @param rootNode
     */
    public InOrderTraversal(Node<E> rootNode) {
        super(TraversalMode.IN_ORDER_TRAVERSAL, rootNode);
    }

    /**
     * Pushes the left nodes to stack.
     *
     * @param node
     */
    @Override
    public void pushLeft(Node<E> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }

    /**
     * Traverses the <code>treeType</code> tree with the provided <code>includeNullLeafs</code> in the
     * <code>TraversalMode</code> traversal.
     * <p>
     * Returns the list of nodes using <code>in-order</code> traversal recursively.
     *
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Left -> Root -> Right</code>
     * <p>
     * i.e: [4, 2, 5, 1, 6, 3, 7]
     *
     * @param includeNullLeafs
     * @return
     */
    @Override
    public List<Node<E>> traverseNodes(Node<E> rootNode, boolean includeNullLeafs) {
        List<Node<E>> inOrder = new ArrayList<>();
        if (BeanUtils.isNull(rootNode)) {
            if (includeNullLeafs) {
                inOrder.add(null);
            }
        } else {
            // handle binary tree representation
            if (rootNode.isBinary()) {
                inOrder.addAll(traverseNodes(rootNode.getLeft(), includeNullLeafs));
                inOrder.add(rootNode);
                inOrder.addAll(traverseNodes(rootNode.getRight(), includeNullLeafs));
            } else {
                inOrder.add(rootNode);
                for (Node<E> childNode : rootNode.getChildren()) {
                    inOrder.addAll(traverseNodes(childNode, includeNullLeafs));
                }
            }
        }

        return inOrder;
    }

}
