package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.array.ArrayUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 8:15 AM
 */
public class InOrderTreeBuilder<E extends Comparable<? super E>> extends AbstractTreeBuilder<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InOrderTreeBuilder.class);

    /**
     * Handles the preOrder operation.
     */
    public InOrderTreeBuilder() {
        super(TraversalMode.IN_ORDER_TRAVERSAL);
    }

    /**
     * Validates the <code>traversalMode</code>.
     */
    @Override
    protected void checkTraversalMode() {
        if (!TraversalMode.isInOrderTraversal(getTraversalMode())) {
            throw new RuntimeException("Invalid traversalMode!");
        }
    }

    /**
     * @param isBinary
     * @param preOrderData
     * @param inStart
     * @param inEnd
     * @return
     */
    private Node<E> buildRecursivelyWithPreOrder(boolean isBinary, List<E> preOrderData, int inStart, int inEnd) {
        LOGGER.debug("+buildRecursivelyWithPreOrder({}, {}, {})", preOrderData, inStart, inEnd);
        if (index >= preOrderData.size() || inStart > inEnd) {
            LOGGER.debug("-buildRecursivelyWithPreOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, null);
            return null;
        }

        // read the first index as the root from preOrder data (Root - Left - Right) and increment index.
        Node<E> newNode = new Node<>(isBinary, preOrderData.get(index));
        index++;

        // if node has no children, return the node.
        if (inStart == inEnd) {
            LOGGER.debug("-buildRecursivelyWithPreOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, newNode);
            return newNode;
        }

        // find index of data in <code>inOrderData</code>
        int inIndex = getNodeIndex(newNode.getData());
        if (isBinary) {
            // build subtree of the current node
            newNode.setLeft(buildRecursivelyWithPreOrder(isBinary, preOrderData, inStart, inIndex - 1));
            newNode.setRight(buildRecursivelyWithPreOrder(isBinary, preOrderData, inIndex + 1, inEnd));
        } else {
            newNode.addNode(buildRecursivelyWithPreOrder(isBinary, preOrderData, inIndex + 1, inEnd));
        }

        LOGGER.debug("-buildRecursivelyWithPreOrder(), newNode:{}", newNode);
        return newNode;
    }

    /**
     * @param isBinary
     * @param postOrderData
     * @param inStart
     * @param inEnd
     * @return
     */
    private Node<E> buildRecursivelyWithPostOrder(boolean isBinary, List<E> postOrderData, int inStart, int inEnd) {
        LOGGER.debug("+buildRecursivelyWithPostOrder({}, {}, {}, {})", isBinary, postOrderData, inStart, inEnd);
        // base case (no child data available)
        if (index >= postOrderData.size() || inStart > inEnd) {
            LOGGER.debug("-buildRecursivelyWithPostOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, null);
            return null;
        }

        // read the last index as the root from postOrder data (Left - Right - Root) and decrement index
        Node<E> newNode = new Node<>(isBinary, postOrderData.get(index));
        index--;
        // if node has no children, return it.
        if (inStart == inEnd) {
            LOGGER.debug("-buildRecursivelyWithPostOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, newNode);
            return newNode;
        }

        // find index of node's data in <code>inOrderData</code>
        int inIndex = getNodeIndex(newNode.getData());
        if (isBinary) {
            // build right side tree first and then left side tree
            newNode.setRight(buildRecursivelyWithPostOrder(isBinary, postOrderData, inIndex + 1, inEnd));
            newNode.setLeft(buildRecursivelyWithPostOrder(isBinary, postOrderData, inStart, inIndex - 1));
        } else {
            newNode.addNode(buildRecursivelyWithPostOrder(isBinary, postOrderData, inStart, inIndex - 1));
        }

        LOGGER.debug("-buildRecursivelyWithPostOrder(), newNode:{}", newNode);
        return newNode;
    }

    /**
     * @param isBinary
     * @param inOrderData
     * @param inStart
     * @param inEnd
     * @return
     */
    private Node<E> buildRecursivelyWithInOrder(boolean isBinary, List<E> inOrderData, int inStart, int inEnd) {
        LOGGER.debug("+buildRecursivelyWithPostOrder({}, {}, {}, {})", isBinary, inOrderData, inStart, inEnd);
        // base case (no child data available)
        if (index >= inOrderData.size() || inStart > inEnd) {
            LOGGER.debug("-buildRecursivelyWithInOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, null);
            return null;
        }

        // read the last index as the root from postOrder data (Left - Right - Root) and decrement index
        Node<E> newNode = new Node<>(isBinary, inOrderData.get(index));
        index--;
        // if node has no children, return it.
        if (inStart == inEnd) {
            LOGGER.debug("-buildRecursivelyWithInOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, newNode);
            return newNode;
        }

        // find index of node's data in <code>inOrderData</code>
        int inIndex = getNodeIndex(newNode.getData());
        // build right side tree first and then left side tree
        newNode.setRight(buildRecursivelyWithPostOrder(isBinary, inOrderData, inIndex + 1, inEnd));
        newNode.setLeft(buildRecursivelyWithPostOrder(isBinary, inOrderData, inStart, inIndex - 1));

        LOGGER.debug("-buildRecursivelyWithInOrder(), newNode:{}", newNode);
        return newNode;
    }

    /**
     * Builds the nodes based on the provided <code>inOrderData</code> or <code>preOrderData</code> or <code>postOrderData</code>.
     * This helper method will be used in testing.
     *
     * @param isBinary
     * @param inOrderData
     * @param preOrderData
     * @param postOrderData
     * @return
     */
    @Override
    public Node<E> buildRecursively(boolean isBinary, List<E> inOrderData, List<E> preOrderData, List<E> postOrderData) {
        Node<E> rootNode = null;
        checkTraversalMode();
        if (Objects.nonNull(inOrderData)) {
            fillNodeIndices(inOrderData);
            if (Objects.nonNull(preOrderData)) {
                setIndex(0); // index in preOrder (Root - Left - Right)
                rootNode = buildRecursivelyWithPreOrder(isBinary, preOrderData, 0, preOrderData.size() - 1);
            } else if (Objects.nonNull(postOrderData)) {
                setIndex(inOrderData.size() - 1); // index in postOrder (Left - Right - Root)
                rootNode = buildRecursivelyWithPostOrder(isBinary, postOrderData, 0, postOrderData.size() - 1);
            } else if (BeanUtils.isTypeOf(inOrderData, Integer[].class)) {
                setIndex(0); // index in preOrder (Root - Left - Right)
                int maxIndex = ArrayUtils.findMaxValueIndex((List<Integer>) inOrderData);
                rootNode = buildRecursivelyWithInOrder(isBinary, inOrderData, maxIndex, inOrderData.size() - 1);
            }

            // update the size of the root node.
//            assert rootNode.getSize() == TreeUtils.countNodes(rootNode);
//            if (Objects.nonNull(rootNode)) {
//                rootNode.setSize(TreeUtils.countNodes(rootNode));
//            }

        }

        return rootNode;
    }

    /**
     * Find the index of the <code>nodeData</code> in the <code>inOrder</code> data between <code>start</code> and
     * <code>end</code> indices.
     *
     * @param inOrder
     * @param start
     * @param end
     * @param nodeData
     * @return
     */
    private int findInOrderIndex(E[] inOrder, int start, int end, E nodeData) {
        LOGGER.debug("+findInOrderIndex({}, {}, {}, {})", inOrder, start, end, nodeData);
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == nodeData) {
                LOGGER.debug("-findInOrderIndex(), start:{}, end:{}, i:{}", start, end, i);
                return i;
            }
        }

        LOGGER.debug("-findInOrderIndex(), newNode:-1");
        return -1;
    }

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildBinaryTree(List<E> inputData) {
        Node rootNode = null;
        checkTraversalMode();
        if (BeanUtils.isNotEmpty(inputData)) {
            int maxIndex = ArrayUtils.findMaxValueIndex((List<Integer>) inputData);
            rootNode = buildRecursively(true, inputData, null, null);
//            rootNode.setSize(TreeUtils.countNodes(rootNode));
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
        return null;
    }

}
