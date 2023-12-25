package com.devamatre.theorem.adts.tree.handler;

import com.devamatre.theorem.adts.array.ArrayUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeTraversal;
import com.devamatre.theorem.adts.tree.TreeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/26/23 4:58 PM
 */
public class InOrderHandler<E extends Comparable<? super E>> extends AbstractTreeHandler<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InOrderHandler.class);

    /**
     * Handles the preOrder operations.
     */
    public InOrderHandler() {
        super(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("InOrderHandler()");
    }

    /**
     * @param inStart
     * @param inEnd
     * @return
     */
    private Node<E> buildInOrderWithPreOrder(E[] preOrderData, int inStart, int inEnd) {
        LOGGER.debug("+buildInOrderWithPreOrder({}, {}, {})", preOrderData, inStart, inEnd);
        if (index >= preOrderData.length || inStart > inEnd) {
            LOGGER.debug("-buildInOrderWithPreOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, null);
            return null;
        }

        // read the first index as the root from preOrder data (Root - Left - Right) and increment index.
        Node<E> newNode = new Node<>(preOrderData[index++]);

        // if node has no children, return the node.
        if (inStart == inEnd) {
            LOGGER.debug("-buildInOrderWithPreOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, newNode);
            return newNode;
        }

        // find index of data in <code>inOrderData</code>
        int inIndex = getNodeIndex(newNode.getData());
        // build subtree of the current node
        newNode.setLeft(buildInOrderWithPreOrder(preOrderData, inStart, inIndex - 1));
        newNode.setRight(buildInOrderWithPreOrder(preOrderData, inIndex + 1, inEnd));

        LOGGER.debug("-buildInOrderWithPreOrder(), newNode:{}", newNode);
        return newNode;
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
     * @param inOrder
     * @param preOrder
     * @return
     */
    public Node<E> buildInOrderTreeWithPreOrder(E[] inOrder, E[] preOrder) {
        Node<E> rootNode = null;
        if (TraversalMode.IN_ORDER_TRAVERSAL == getTraversalMode()) {
            setIndex(0); // index in preOrder (Root - Left - Right)
            fillNodeIndices(inOrder);
            rootNode = buildInOrderWithPreOrder(preOrder, 0, preOrder.length - 1);
//            rootNode.setSize(TreeUtils.getCount(rootNode));
        }

        return rootNode;
    }

    /**
     * @param inStart
     * @param inEnd
     * @return
     */
    private Node<E> buildInOrderWithPostOrder(E[] postOrderData, int inStart, int inEnd) {
        LOGGER.debug("+buildInOrderWithPostOrder({}, {}, {})", postOrderData, inStart, inEnd);
        // base case (no child data available)
        if (index >= postOrderData.length || inStart > inEnd) {
            LOGGER.debug("-buildInOrderWithPostOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, null);
            return null;
        }

        // read the last index as the root from postOrder data (Left - Right - Root) and decrement index
        Node<E> newNode = new Node<>(postOrderData[index--]);
        // if node has no children, return it.
        if (inStart == inEnd) {
            LOGGER.debug("-buildInOrderWithPostOrder(), inStart:{}, inEnd:{} newNode:{}", inStart, inEnd, newNode);
            return newNode;
        }

        // find index of node's data in <code>inOrderData</code>
        int inIndex = getNodeIndex(newNode.getData());
        // build right side tree first and then left side tree
        newNode.setRight(buildInOrderWithPostOrder(postOrderData, inIndex + 1, inEnd));
        newNode.setLeft(buildInOrderWithPostOrder(postOrderData, inStart, inIndex - 1));

        LOGGER.debug("-buildInOrderWithPostOrder(), newNode:{}", newNode);
        return newNode;
    }

    /**
     * @param inOrder
     * @param postOrder
     * @return
     */
    public Node<E> buildInOrderTreeWithPostOrder(E[] inOrder, E[] postOrder) {
        Node rootNode = null;
        if (TraversalMode.IN_ORDER_TRAVERSAL == getTraversalMode()) {
            setIndex(inOrder.length - 1); // index in postOrder (Left - Right - Root)
            fillNodeIndices(inOrder);
            rootNode = buildInOrderWithPostOrder(postOrder, 0, inOrder.length - 1);
//            setSize(TreeUtils.getCount(rootNode));
        }

        return rootNode;
    }

    /**
     * @param elements
     * @return
     */
    @Override
    public Node<E> buildBinaryTree(E[] elements) {
        Node rootNode = null;
//        if (TraversalMode.IN_ORDER_TRAVERSAL == getTraversalMode() && BeanUtils.isNotEmpty(elements)) {
//            int maxIndex = ArrayUtils.findMaxIndex((Integer[]) elements);
//            rootNode = buildInOrder(elements, null, elements.length - 1, maxIndex);
//            setSize(TreeUtils.getCount(rootNode));
//        }

        return rootNode;
    }

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param treeType
     * @param includeNullLeafs
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> rootNode, TreeType treeType, boolean includeNullLeafs) {
//        List<E> data = TreeUtils.inOrder(rootNode, includeNullLeafs);
        TreeTraversal treeTraverser = TreeTraversal.treeTraverser(getTraversalMode(), rootNode);
        List<E> data = treeTraverser.traverse(treeType, includeNullLeafs);
        ArrayUtils.replaceNullWithMinus(data);
        return ArrayUtils.toIntArray(data);
    }

}
