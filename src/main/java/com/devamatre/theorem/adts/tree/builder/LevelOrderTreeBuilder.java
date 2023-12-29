package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
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
        checkTraversalMode();
        return null;
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
