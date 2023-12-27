package com.devamatre.theorem.adts.tree.handler;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeHandler;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 5:15 PM
 */
public class InOrderHandlerTest extends AbstractTreeHandlerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InOrderHandlerTest.class);

    /**
     * @return
     */
    @Override
    public TreeHandler buildTreeHandler() {
        LOGGER.debug("+buildTreeHandler()");
        TreeHandler<Integer> treeHandler = new InOrderHandler<>();
        assertNotNull(treeHandler);
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertEquals(TraversalMode.IN_ORDER_TRAVERSAL, treeHandler.getTraversalMode());
        assertEquals(InOrderHandler.class, treeHandler.getClass());
        LOGGER.debug("-buildTreeHandler(), treeHandler:{}", treeHandler);
        return treeHandler;
    }

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    @Test
    public void testGetTraversalMode() {
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPreOrder()</code> method.
     */
    @Test
    public void testBuildInOrderTreeWithPreOrder() {
        LOGGER.debug("testBuildInOrderTreeWithPreOrder()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        InOrderHandler<Integer> inOrderHandler = (InOrderHandler<Integer>) treeHandler;
        Integer[] inOrderData = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
        Integer[] preOrderData = new Integer[]{1, 2, 4, 5, 3, 6, 7, 8};
        Node<Integer> rootNode = inOrderHandler.buildInOrderTreeWithPreOrder(inOrderData, preOrderData);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(inOrderData.length, TreeUtils.countNodes(rootNode));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(inOrderData.length, excludeNullLeafs.length);
        assertArrayEquals(inOrderData, excludeNullLeafs);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPreOrder()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafsInOrderTreeWithPreOrder() {
        LOGGER.debug("testTreeConverterIncludeNullLeafsInOrderTreeWithPreOrder()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        InOrderHandler<Integer> inOrderHandler = (InOrderHandler<Integer>) treeHandler;
        Integer[] inOrderData = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
        Integer[] preOrderData = new Integer[]{1, 2, 4, 5, 3, 6, 7, 8};
        Node<Integer> rootNode = inOrderHandler.buildInOrderTreeWithPreOrder(inOrderData, preOrderData);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(inOrderData.length, TreeUtils.countNodes(rootNode));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(inOrderData.length, excludeNullLeafs.length);
        assertArrayEquals(inOrderData, excludeNullLeafs);

        Integer[] expected = new Integer[]{-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 7, -1, 6, -1, 8, -1};
        Integer[] includeNullLeafs = treeHandler.treeConverter(rootNode, true);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertNotNull(includeNullLeafs);
        assertEquals(expected.length, includeNullLeafs.length);
        assertArrayEquals(expected, includeNullLeafs);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPostOrder()</code> method.
     */
    @Test
    public void testBuildInOrderTreeWithPostOrder() {
        LOGGER.debug("testBuildInOrderTreeWithPostOrder()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        InOrderHandler<Integer> inOrderHandler = (InOrderHandler<Integer>) treeHandler;
        Integer[] inOrderData = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
        Integer[] postOrderData = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        Node<Integer> rootNode = inOrderHandler.buildInOrderTreeWithPostOrder(inOrderData, postOrderData);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(inOrderData.length, TreeUtils.countNodes(rootNode));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(inOrderData.length, excludeNullLeafs.length);
        assertArrayEquals(inOrderData, excludeNullLeafs);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPreOrder()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafsInOrderTreeWithPostOrder() {
        LOGGER.debug("testTreeConverterIncludeNullLeafsInOrderTreeWithPostOrder()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        InOrderHandler<Integer> inOrderHandler = (InOrderHandler<Integer>) treeHandler;
        Integer[] inOrderData = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
        Integer[] postOrderData = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        Node<Integer> rootNode = inOrderHandler.buildInOrderTreeWithPostOrder(inOrderData, postOrderData);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(inOrderData.length, TreeUtils.countNodes(rootNode));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode, false);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(inOrderData.length, excludeNullLeafs.length);
        assertArrayEquals(inOrderData, excludeNullLeafs);

        Integer[] expected = new Integer[]{-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 7, -1, 6, -1, 8, -1};
        Integer[] includeNullLeafs = treeHandler.treeConverter(rootNode, true);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertNotNull(includeNullLeafs);
        assertEquals(expected.length, includeNullLeafs.length);
        assertArrayEquals(expected, includeNullLeafs);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafs() {
        LOGGER.debug("testTreeConverterIncludeNullLeafs()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        InOrderHandler<Integer> inOrderHandler = (InOrderHandler<Integer>) treeHandler;
        Integer[] inOrderData = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
        Integer[] preOrderData = new Integer[]{1, 2, 4, 5, 3, 6, 7, 8};
        Node<Integer> rootNode = inOrderHandler.buildInOrderTreeWithPreOrder(inOrderData, preOrderData);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(inOrderData.length, TreeUtils.countNodes(rootNode));

        Integer[] expected = new Integer[]{-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 7, -1, 6, -1, 8, -1};
        Integer[] includeNullLeafs = treeHandler.treeConverter(rootNode, true);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertNotNull(includeNullLeafs);
        assertEquals(expected.length, includeNullLeafs.length);
        assertArrayEquals(expected, includeNullLeafs);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverter() {
        LOGGER.debug("testTreeConverter()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        InOrderHandler<Integer> inOrderHandler = (InOrderHandler<Integer>) treeHandler;
        Integer[] inOrderData = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
        Integer[] preOrderData = new Integer[]{1, 2, 4, 5, 3, 6, 7, 8};
        Node<Integer> rootNode = inOrderHandler.buildInOrderTreeWithPreOrder(inOrderData, preOrderData);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(inOrderData.length, TreeUtils.countNodes(rootNode));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(inOrderData.length, excludeNullLeafs.length);
        assertArrayEquals(inOrderData, excludeNullLeafs);
    }

}
