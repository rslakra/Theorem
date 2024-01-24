package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.lang.Maths;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 8:15 AM
 */
public class PostOrderTreeBuilder<E extends Comparable<? super E>> extends AbstractTreeBuilder<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostOrderTreeBuilder.class);

    /**
     * Handles the postOrder operation.
     */
    public PostOrderTreeBuilder() {
        super(TraversalMode.POST_ORDER_TRAVERSAL);
    }

    /**
     * Validates the <code>traversalMode</code>.
     */
    @Override
    protected void checkTraversalMode() {
        if (!TraversalMode.isPostOrderTraversal(getTraversalMode())) {
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
        checkTraversalMode();
        index--;
        if (index < 0 || index >= postOrderData.size()) { // check index is valid or not
            return null;
        } else if (BeanUtils.isEmpty(postOrderData.get(index))) { // is null/empty data
            return null;
        } else if (Maths.isEmptyOrMinusOne(postOrderData.get(index))) { // is null/empty/-1 data
            return null;
        }

        Node<E> newNode = new Node<>(isBinary, postOrderData.get(index));
        if (isBinary) {
            newNode.setRight(buildRecursively(isBinary, null, null, postOrderData));
            newNode.setLeft(buildRecursively(isBinary, null, null, postOrderData));
        } else {
            newNode.addNode(buildRecursively(isBinary, null, null, postOrderData));
        }

        return newNode;
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
            setIndex(inputData.size());
            rootNode = buildRecursively(true, null, null, inputData);
//            assert rootNode.getSize() == TreeUtils.countNodes(rootNode);
//            assert inputData.size() == TreeUtils.countNodes(rootNode);
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
        Node rootNode = null;
        checkTraversalMode();
        if (BeanUtils.isNotEmpty(inputData)) {
            setIndex(inputData.size());
            rootNode = buildRecursively(false, null, null, inputData);
            assert rootNode.getSize() == TreeUtils.countNodes(rootNode);
//            rootNode.setSize(TreeUtils.countNodes(rootNode));
        }

        return rootNode;
    }

}
