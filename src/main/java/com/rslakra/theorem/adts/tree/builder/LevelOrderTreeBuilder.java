package com.rslakra.theorem.adts.tree.builder;

import com.rslakra.appsuite.core.BeanUtils;
import com.rslakra.theorem.adts.lang.Maths;
import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.data.NodeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 8:15 AM
 */
public class LevelOrderTreeBuilder<E extends Comparable<? super E>> extends AbstractTreeBuilder<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LevelOrderTreeBuilder.class);

    /**
     * Handles the levelOrder operation.
     */
    public LevelOrderTreeBuilder() {
        super(TraversalMode.LEVEL_ORDER_TRAVERSAL);
    }

    /**
     * Validates the <code>traversalMode</code>.
     */
    @Override
    protected void checkTraversalMode() {
        if (!TraversalMode.isLevelOrderTraversal(getTraversalMode())) {
            throw new RuntimeException("Invalid traversalMode!");
        }
    }

    /**
     * Builds the nodes based on the provided <code>inOrderData</code> or <code>preOrderData</code> or
     * <code>postOrderData</code>. This helper method will be used in testing.
     *
     * @param isBinary
     * @param inOrderData
     * @param preOrderData
     * @param postOrderData
     * @return
     */
    @Override
    public Node<E> buildRecursively(boolean isBinary, List<E> inOrderData, List<E> preOrderData,
                                    List<E> postOrderData) {
        return null;
    }

    /**
     * @param inputData
     * @return
     */
    public Node<E> buildNextNode(List<E> inputData) {
        index++;
        if (index < 0 || index >= inputData.size()) { // check index is valid or not
            return null;
        } else { // is null/empty/-1 data
            E nodeValue = inputData.get(index);
            if (!Maths.isEmptyOrMinusOne(nodeValue)) {
                return new Node<>(nodeValue);
            }
        }

        return null;
    }

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildBinaryTree(List<E> inputData) {
        Node<E> rootNode = null;
        checkTraversalMode();
        if (BeanUtils.isNotEmpty(inputData)) {
            setIndex(-1);
            Queue<NodeInfo<E>> queue = new LinkedList<>();
            queue.add(new NodeInfo<>(buildNextNode(inputData), 0));
            while (!queue.isEmpty()) {
                NodeInfo<E> nodeInfo = queue.remove();
                // current root node
                Node<E> nextNode = nodeInfo.getNode();
                if (Objects.isNull(rootNode)) {
                    rootNode = nextNode;
                }

                // build left and right nodes
                if (Objects.nonNull(nextNode)) {
                    nextNode.setLeft(buildNextNode(inputData));
                    nextNode.setRight(buildNextNode(inputData));
                    queue.add(new NodeInfo<>(nextNode.getLeft(), nodeInfo.getLevel() + 1));
                    queue.add(new NodeInfo<>(nextNode.getRight(), nodeInfo.getLevel() + 1));
                }
            }
        }

        return rootNode;
    }

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildHierarchicalTree(List<E> inputData) {
        checkTraversalMode();
        return null;
    }

}
