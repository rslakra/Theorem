package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 10:36:00 PM
 * @since 1.0.0
 */
public class PreOrderTraversal<E extends Comparable<? super E>> extends AbstractTreeTraversal<E> {

    /**
     * @param node
     */
    public PreOrderTraversal(Node<E> node) {
        super(TraversalMode.PRE_ORDER_TRAVERSAL, node);
    }

    /**
     * Pushes the left nodes to stack.
     * <p>
     * If there is a left child, we push the child on a stack and return a parent node. If there is no left child, we
     * check for a right child. If there is a right child, we push the right child on a stack and return a parent node.
     * If there is no right child, we move back up the tree (while-loop) until we find a node with a right child.
     *
     * @param node
     */
    @Override
    public void pushLeft(Node<E> node) {
        if (node != null) {
            stack.push(node);
        }
    }

    /**
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     * <p>
     * Returns the list of nodes using <code>pre-order</code> traversal recursively.
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
     * InOrder Traversal <code>Root -> Left -> Right</code>
     * <p>
     * i.e: [1, 2, 4, 5, 3, 6, 7]
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    public List<Node<E>> traverseNodes(Node<E> rootNode, boolean includeNullLeafs) {
        List<Node<E>> preOrder = new ArrayList<>();
        if (BeanUtils.isNull(rootNode)) {
            if (includeNullLeafs) {
                preOrder.add(null);
            }
        } else {
            if (rootNode.isBinary()) {
                for (int i = 0; i < rootNode.getCount(); i++) {
                    preOrder.add(rootNode);
                }
                preOrder.addAll(traverseNodes(rootNode.getLeft(), includeNullLeafs));
                preOrder.addAll(traverseNodes(rootNode.getRight(), includeNullLeafs));
            } else {
                preOrder.add(rootNode);
                for (Node<E> childNode : rootNode.getChildren()) {
                    preOrder.addAll(traverseNodes(childNode, includeNullLeafs));
                }
            }
        }

        return preOrder;
    }

}
