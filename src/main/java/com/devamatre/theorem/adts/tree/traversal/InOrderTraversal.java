package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the in-order traversal of the tree.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class InOrderTraversal<E extends Comparable<? super E>> extends AbstractTreeTraversal<E>
    implements TreeTraversal<E> {

    /**
     * @param node
     */
    public InOrderTraversal(Node<E> node) {
        super(TraversalMode.IN_ORDER_TRAVERSAL, node);
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
     * Returns the list of nodes using <code>in-order</code> traversal recursively.
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
     * @param treeNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public List<Node<E>> treeTraversal(Node<E> treeNode, boolean includeNullLeafs) {
        List<Node<E>> inOrder = new ArrayList<>();
        if (BeanUtils.isNull(treeNode)) {
            if (includeNullLeafs) {
                inOrder.add(null);
            }
        } else {
            inOrder.addAll(treeTraversal(treeNode.getLeft(), includeNullLeafs));
            inOrder.add(treeNode);
            inOrder.addAll(treeTraversal(treeNode.getRight(), includeNullLeafs));
        }

        return inOrder;
    }

}
