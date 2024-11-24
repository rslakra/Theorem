package com.rslakra.theorem.adts.tree.traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.TreeFactory;
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
public class LevelOrderTraversalTest extends AbstractTreeTraversalTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LevelOrderTraversalTest.class);
    private static final List<Integer> TREE_INPUT_DATA = Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8);

    /**
     * @return
     */
    @Override
    public TreeTraversal buildTreeTraversal() {
        LOGGER.debug("+buildTreeTraversal()");
        Node<Integer> rootNode = TreeUtils.buildTree(TREE_INPUT_DATA);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        TreeTraversal<Integer> treeTraversal = TreeFactory.treeTraverser(rootNode, TraversalMode.LEVEL_ORDER_TRAVERSAL);
        assertNotNull(treeTraversal);
        LOGGER.debug("treeTraversal:{}", treeTraversal);
        assertEquals(TraversalMode.LEVEL_ORDER_TRAVERSAL, treeTraversal.getTraversalMode());
        assertEquals(LevelOrderTraversal.class, treeTraversal.getClass());
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
        assertEquals(TraversalMode.LEVEL_ORDER_TRAVERSAL, treeTraversal.getTraversalMode());
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
        List<Integer> treeTraversalResults = treeTraversal.traverse(false);
        LOGGER.debug("treeTraversalResults:{}", treeTraversalResults);
        assertNotNull(treeTraversalResults);
        assertEquals(TREE_INPUT_DATA.size(), treeTraversalResults.size());
        assertEquals(TREE_INPUT_DATA, treeTraversalResults);
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
        List<Integer> treeTraversalResults = treeTraversal.traverse(false);
        LOGGER.debug("treeTraversalResults:{}", treeTraversalResults);
        assertNotNull(treeTraversalResults);
        assertEquals(TREE_INPUT_DATA.size(), treeTraversalResults.size());
        assertEquals(TREE_INPUT_DATA, treeTraversalResults);
    }

    /**
     * Tests the <code>treeNodesTraversal()</code> method.
     */
    @Test
    public void testTreeTraversalWithNullLeafs() {
        LOGGER.debug("testTreeTraversal()");
        TreeTraversal<Integer> treeTraversal = buildTreeTraversal();
        LOGGER.debug("treeTraversal:{}", treeTraversal);
        assertNotNull(treeTraversal);

        // treeTraversal validation
        List<Integer>
            expectedResult =
            Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8, null, null, null, null, null, null, null, null, null);
        List<Integer> treeTraversalResults = treeTraversal.traverse(true);
        LOGGER.debug("treeTraversalResults:{}", treeTraversalResults);
        assertNotNull(treeTraversalResults);
        assertEquals(expectedResult.size(), treeTraversalResults.size());
        assertEquals(expectedResult, treeTraversalResults);
    }

}
