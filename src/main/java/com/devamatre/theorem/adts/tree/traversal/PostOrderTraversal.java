package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class PostOrderTraversal<E extends Comparable<? super E>> extends AbstractTreeTraversal<E> {

    /**
     * @param node
     */
    public PostOrderTraversal(Node<E> node) {
        super(TraversalMode.POST_ORDER_TRAVERSAL, node);
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

        if (stack.isEmpty()) {
            return;
        }

        node = stack.peek();
        if (node.hasRight()) {
            pushLeft(node.getRight());
        }
    }

    /**
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     * <p>
     * Returns the list of nodes using <code>post-order</code> traversal recursively.
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
     * PostOrder Traversal <code>Left -> Right -> Root</code>
     * <p>
     * i.e: [4, 5, 2, 6, 7, 3, 1]
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    public List<Node<E>> traverseNodes(Node<E> rootNode, TreeType treeType, boolean includeNullLeafs) {
        List<Node<E>> postOrder = new ArrayList<>();
        if (BeanUtils.isNull(rootNode)) {
            if (includeNullLeafs) {
                postOrder.add(null);
            }
        } else {
            // handle binary tree representation
            if (TreeType.BINARY == treeType) {
                postOrder.addAll(traverseNodes(rootNode.getLeft(), treeType, includeNullLeafs));
                postOrder.addAll(traverseNodes(rootNode.getRight(), treeType, includeNullLeafs));
                postOrder.add(rootNode);
            } else {
                for (Node<E> childNode : rootNode.getChildren()) {
                    postOrder.addAll(traverseNodes(childNode, treeType, includeNullLeafs));
                    postOrder.add(rootNode);
                }
            }
        }

        return postOrder;
    }

}
