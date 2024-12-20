package com.rslakra.theorem.adts.tree.traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.TreeTraversal;
import com.rslakra.theorem.adts.tree.TreeUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 5:15 PM
 */
public class PreOrderTraversalTest extends AbstractTreeTraversalTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreOrderTraversalTest.class);

    /**
     * @return
     */
    @Override
    public TreeTraversal buildTreeTraversal() {
        LOGGER.debug("+buildTreeTraversal()");
        Node<Integer> rootNode = TreeUtils.buildTree(Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8));
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        TreeTraversal<Integer> treeTraversal = new PreOrderTraversal<>(rootNode);
        assertNotNull(treeTraversal);
        LOGGER.debug("treeTraversal:{}", treeTraversal);
        assertEquals(TraversalMode.PRE_ORDER_TRAVERSAL, treeTraversal.getTraversalMode());
        assertEquals(PreOrderTraversal.class, treeTraversal.getClass());
        LOGGER.debug("-buildTreeTraversal(), treeTraversal:{}", treeTraversal);
        return treeTraversal;
    }

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    @Test
    public void testGetTraversalMode() {
        TreeTraversal<Integer> treeTraversal = buildTreeTraversal();
        LOGGER.debug("treeTraversal:{}", treeTraversal);
        assertNotNull(treeTraversal);
        assertEquals(TraversalMode.PRE_ORDER_TRAVERSAL, treeTraversal.getTraversalMode());
    }

    /**
     * Tests the <code>treeNodesTraversal()</code> method.
     */
    @Test
    public void testNodesTraversal() {
        LOGGER.debug("testNodesTraversal()");
        TreeTraversal<Integer> treeTraversal = buildTreeTraversal();
        LOGGER.debug("treeTraversal:{}", treeTraversal);
        assertNotNull(treeTraversal);

        List<Node<Integer>> treeNodesTraversal = treeTraversal.traverseNodes(false);
        LOGGER.debug("treeNodesTraversal:{}", treeNodesTraversal);
        assertNotNull(treeNodesTraversal);
        assertEquals(8, treeNodesTraversal.size());

        // treeTraversal validation
        List<Integer> expectedResults = Arrays.asList(4, 2, 1, 8, 3, 5, 7, 6);
        List<Integer> treeTraversalResults = treeTraversal.traverse(false);
        LOGGER.debug("treeTraversalResults:{}", treeTraversalResults);
        assertNotNull(treeTraversalResults);
        assertEquals(expectedResults.size(), treeTraversalResults.size());
        assertEquals(expectedResults, treeTraversalResults);
    }

    /**
     * Tests the <code>treeNodesTraversal()</code> method.
     */
    @Test
    public void testTreeTraversal() {
        LOGGER.debug("testTreeTraversal()");
        TreeTraversal<Integer> treeTraversal = buildTreeTraversal();
        LOGGER.debug("treeTraversal:{}", treeTraversal);
        assertNotNull(treeTraversal);

        // treeTraversal validation
        List<Integer> expectedResults = Arrays.asList(4, 2, 1, 8, 3, 5, 7, 6);
        List<Integer> treeTraversalResults = treeTraversal.traverse(false);
        LOGGER.debug("treeTraversalResults:{}", treeTraversalResults);
        assertNotNull(treeTraversalResults);
        assertEquals(expectedResults.size(), treeTraversalResults.size());
        assertEquals(expectedResults, treeTraversalResults);
    }

}
