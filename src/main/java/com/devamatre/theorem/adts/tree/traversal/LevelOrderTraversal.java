package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;

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
public class LevelOrderTraversal<E extends Comparable<? super E>> extends AbstractTreeTraversal<E> {

    private final Queue<Node<E>> queue = new LinkedList<>();
    // custom null node to handle null as value
    private final Node<E> nullNode = new Node<>(null);

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
        // ignore me
//        while (node != null) {
//            stack.push(node);
//            node = node.getLeft();
//        }
    }

    /**
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    private List<List<Node<E>>> levelOrdersTreeTraversal(Node<E> rootNode, boolean includeNullLeafs) {
        List<List<Node<E>>> levelOrders = new LinkedList<>();
        if (Objects.nonNull(rootNode)) {
            queue.clear();
            queue.add(rootNode);
            queue.add(null);
            List<Node<E>> levelOrder = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node<E> nextNode = queue.remove();
                if (Objects.isNull(nextNode)) {
                    levelOrders.add(levelOrder);
                    levelOrder = new LinkedList<>();
                    // if queue is not empty, add null back to track the next level
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                } else {
                    levelOrder.add(nextNode);
                    // add left nextNode if available
                    if (nextNode.hasLeft()) {
                        queue.add(nextNode.getLeft());
                    }
                    // add right nextNode if available
                    if (nextNode.hasRight()) {
                        queue.add(nextNode.getRight());
                    }
                }
            }
        }

        return levelOrders;
    }

    /**
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    private List<Node<E>> levelOrderTreeTraversal(Node<E> rootNode, boolean includeNullLeafs) {
        final List<Node<E>> levelOrder = new LinkedList<>();
        if (includeNullLeafs) {
            levelOrder.addAll(levelOrderWithQueueSize(rootNode, includeNullLeafs));
        } else {
            List<List<Node<E>>> levelOrders = levelOrdersTreeTraversal(rootNode, includeNullLeafs);
            if (Objects.nonNull(levelOrders)) {
                levelOrders.forEach(entry -> entry.forEach(node -> levelOrder.add(node)));
            }
        }

        return levelOrder;
    }

    /**
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    private List<Node<E>> levelOrderWithQueueSize(Node<E> rootNode, boolean includeNullLeafs) {
        List<Node<E>> levelOrder = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            queue.clear();
            queue.add(rootNode);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Node<E> nextNode = queue.remove();
                    // print current nextNode
                    levelOrder.add(nextNode);
                    if (includeNullLeafs) {
                        // add next node's children if non null
                        if (Objects.nonNull(nextNode)) {
                            queue.add(nextNode.getLeft());
                            queue.add(nextNode.getRight());
                        }
                    } else {
                        // add left nextNode if available
                        if (nextNode.hasLeft()) {
                            queue.add(nextNode.getLeft());
                        }
                        // add right nextNode if available
                        if (nextNode.hasRight()) {
                            queue.add(nextNode.getRight());
                        }
                    }
                    size--;
                }
            }
        }

        return levelOrder;
    }

    /**
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public List<Node<E>> traverseNodes(Node<E> rootNode, boolean includeNullLeafs) {
        return levelOrderTreeTraversal(rootNode, includeNullLeafs);
    }

}
