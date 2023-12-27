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

    private Queue<Node<E>> queue = new LinkedList<>();

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
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public List<Node<E>> traverseNodes(Node<E> rootNode, boolean includeNullLeafs) {
        List<Node<E>> levelOrder = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(rootNode);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Node<E> nextNode = queue.remove();
                    // print current nextNode
                    levelOrder.add(nextNode);
                    // add left nextNode if available
                    if (nextNode.hasLeft()) {
                        queue.add(nextNode.getLeft());
                    }
                    // add right nextNode if available
                    if (nextNode.hasRight()) {
                        queue.add(nextNode.getRight());
                    }
                    size--;
                }
            }
        }

        return levelOrder;
    }

}
