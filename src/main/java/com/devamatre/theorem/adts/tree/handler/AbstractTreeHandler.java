package com.devamatre.theorem.adts.tree.handler;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 4:26 PM
 */
public abstract class AbstractTreeHandler<E extends Comparable<? super E>> implements TreeHandler<E> {

    private TraversalMode traversalMode;
    protected int index;
    protected Map<E, Integer> nodeIndices;

    /**
     * The default constructor
     *
     * @param traversalMode
     */
    public AbstractTreeHandler(TraversalMode traversalMode) {
        super();
        this.traversalMode = traversalMode;
        this.nodeIndices = new HashMap<>();
    }

    /**
     * Returns the <code>TraversalMode</code> of the tree handler.
     *
     * @return
     */
    @Override
    public TraversalMode getTraversalMode() {
        return traversalMode;
    }

    /**
     * Returns the <code>index</code>.
     *
     * @return
     */
    protected final int getIndex() {
        return index;
    }

    /**
     * The <code>index</code> to be set.
     *
     * @param index
     */
    protected final void setIndex(int index) {
        this.index = index;
    }

    /**
     * Fills the <code>nodeIndices</code> with the <code>inputData</code> values.
     *
     * @param inputData
     */
    protected void fillNodeIndices(E[] inputData) {
        for (int i = 0; i < inputData.length; i++) {
            nodeIndices.put(inputData[i], i);
        }
    }

    /**
     * Returns the index of the <code>nodeData</code>.
     *
     * @param nodeData
     * @return
     */
    protected int getNodeIndex(E nodeData) {
        return nodeIndices.getOrDefault(nodeData, -1);
    }

    /**
     * Returns the <code>treeNode</code> builds with an array of <code>E</code> data.
     *
     * @param elements
     * @return
     */
    @Override
    public Node<E> buildBinaryTree(E[] elements) {
        return null;
    }

    /**
     * Returns the <code>treeNode</code> builds with an array of <code>E</code> data.
     *
     * @param elements
     * @return
     */
    @Override
    public Node<E> buildTree(E[] elements) {
        return buildBinaryTree(elements);
    }

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public abstract E[] treeConverter(Node<E> rootNode, boolean includeNullLeafs);

    /**
     * Converts the <code>rootNode</code> into an array of <code>E</code> type.
     *
     * @param rootNode
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> rootNode) {
        return treeConverter(rootNode, false);
    }

}
