package com.devamatre.theorem.adts.tree.traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeTraversal;
import com.devamatre.theorem.adts.tree.TreeType;
import com.devamatre.theorem.adts.tree.TreeUtils;
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

    /**
     * @return
     */
    @Override
    public TreeTraversal buildTreeTraversal() {
        LOGGER.debug("+buildTreeTraversal()");
        Node<Integer> rootNode = TreeUtils.buildTree(Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8));
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        TreeTraversal<Integer> treeTraversal = new LevelOrderTraversal<>(rootNode);
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

        List<Node<Integer>> treeNodesTraversal = treeTraversal.traverseNodes(TreeType.NARY, false);
        LOGGER.debug("treeNodesTraversal:{}", treeNodesTraversal);
        assertNotNull(treeNodesTraversal);
        assertEquals(8, treeNodesTraversal.size());

        // treeTraversal validation
        List<Integer> expectedResults = Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8);
        List<Integer> treeTraversalResults = treeTraversal.traverse(TreeType.NARY, false);
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
        List<Integer> expectedResults = Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8);
        List<Integer> treeTraversalResults = treeTraversal.traverse(TreeType.NARY, false);
        LOGGER.debug("treeTraversalResults:{}", treeTraversalResults);
        assertNotNull(treeTraversalResults);
        assertEquals(expectedResults.size(), treeTraversalResults.size());
        assertEquals(expectedResults, treeTraversalResults);
    }

}
