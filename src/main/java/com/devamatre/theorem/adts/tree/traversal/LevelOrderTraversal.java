package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Implements the level-order traversal of the tree.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class LevelOrderTraversal<E extends Comparable<? super E>> extends AbstractTreeTraversal<E>
    implements TreeTraversal<E> {

    /**
     * @param node
     */
    public LevelOrderTraversal(Node<E> node) {
        super(TraversalMode.LEVEL_ORDER_TRAVERSAL, node);
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
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     *
     * @param treeNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public List<Node<E>> treeTraversal(Node<E> treeNode, boolean includeNullLeafs) {
        List<Node<E>> levelOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(treeNode);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Node<E> node = queue.remove();
                    // print current node
                    levelOrder.add(node);
                    // add left node if available
                    if (node.hasLeft()) {
                        queue.add(node.getLeft());
                    }
                    // add right node if available
                    if (node.hasRight()) {
                        queue.add(node.getRight());
                    }
                    size--;
                }
            }
        }

        return levelOrder;
    }

    @Override
    public List<Node<E>> treeNodesTraversal() {
        return super.treeNodesTraversal();
    }
}
