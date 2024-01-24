package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 8:15 AM
 */
public abstract class AbstractTreeBuilder<E extends Comparable<? super E>> implements TreeBuilder<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeBuilder.class);

    private TraversalMode traversalMode;
    protected int index;
    protected Map<E, Integer> nodeIndices;

    /**
     * The default constructor
     *
     * @param traversalMode
     */
    public AbstractTreeBuilder(TraversalMode traversalMode) {
        super();
        this.traversalMode = traversalMode;
        this.nodeIndices = new HashMap<>();
        LOGGER.debug("AbstractTreeBuilder({})", traversalMode);
    }

    /**
     * Returns the <code>TraversalMode</code> of the tree parser.
     *
     * @return
     */
    @Override
    public TraversalMode getTraversalMode() {
        return traversalMode;
    }

    /**
     * Validates the <code>traversalMode</code>.
     */
    protected abstract void checkTraversalMode();

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
     * Reset the existing indices and refill the <code>nodeIndices</code> with the <code>inputData</code> values.
     *
     * @param inputData
     */
    protected void fillNodeIndices(List<E> inputData) {
        // reset the node indices
        nodeIndices.clear();
        // fill based on inputData
        for (int i = 0; i < inputData.size(); i++) {
            nodeIndices.put(inputData.get(i), i);
        }
    }

    /**
     * Fills the <code>nodeIndices</code> with the <code>inputData</code> values.
     *
     * @param inputData
     */
    protected void fillNodeIndices(E[] inputData) {
        // reset the node indices
        nodeIndices.clear();
        // fill based on inputData
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
     * Builds the nodes based on the provided <code>inOrderData</code> or <code>preOrderData</code> or
     * <code>postOrderData</code>. This helper method will be used in testing.
     *
     * @param isBinary
     * @param inOrderData
     * @param preOrderData
     * @param postOrderData
     * @return
     */
    public abstract Node<E> buildRecursively(boolean isBinary, List<E> inOrderData, List<E> preOrderData,
                                             List<E> postOrderData);

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> array.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildBinaryTree(E[] inputData) {
        return buildBinaryTree(Arrays.asList(inputData));
    }

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> array.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildHierarchicalTree(E[] inputData) {
        return buildHierarchicalTree(Arrays.asList(inputData));
    }

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> list.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildTree(List<E> inputData) {
        return buildHierarchicalTree(inputData);
    }

    /**
     * Returns the <code>Node<E></code> tree that builds with an elements of <code>inputData</code> array.
     *
     * @param inputData
     * @return
     */
    @Override
    public Node<E> buildTree(E[] inputData) {
        return buildTree(Arrays.asList(inputData));
    }
}
