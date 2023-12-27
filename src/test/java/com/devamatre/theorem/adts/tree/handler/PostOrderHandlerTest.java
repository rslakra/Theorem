package com.devamatre.theorem.adts.tree.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.appsuite.core.BeanUtils;
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
public class PostOrderHandlerTest extends AbstractTreeHandlerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostOrderHandlerTest.class);

    /**
     * Returns the <code>TreeHandler</code> object.
     *
     * @return
     */
    @Override
    public TreeHandler buildTreeHandler() {
        LOGGER.debug("+buildTreeHandler()");
        TreeHandler<Integer> treeHandler = new PostOrderHandler<>();
        assertNotNull(treeHandler);
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertEquals(TraversalMode.POST_ORDER_TRAVERSAL, treeHandler.getTraversalMode());
        assertEquals(PostOrderHandler.class, treeHandler.getClass());
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
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    public void testBuildTree() {
        LOGGER.debug("testBuildTree()");
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Node<Integer> rootNode = treeHandler.buildTree(inputData);
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));
        TreeUtils.printBinaryTree(rootNode);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafs() {
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Node<Integer> rootNode = treeHandler.buildTree(inputData);
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));

        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode, false);
        assertNotNull(excludeNullLeafs);
        LOGGER.debug("excludeNullLeafs:{}", BeanUtils.toString(excludeNullLeafs));
        assertEquals(expected.length, excludeNullLeafs.length);

        expected = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Integer[] includeNullLeafs = treeHandler.treeConverter(rootNode, true);
        assertNotNull(includeNullLeafs);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertEquals(expected.length, includeNullLeafs.length);
    }


    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverter() {
        TreeHandler<Integer> treeHandler = buildTreeHandler();
        LOGGER.debug("treeHandler:{}", treeHandler);
        assertNotNull(treeHandler);

        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Node<Integer> rootNode = treeHandler.buildTree(inputData);
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));

        Integer[] excludeNullLeafs = treeHandler.treeConverter(rootNode, false);
        assertNotNull(excludeNullLeafs);
        LOGGER.debug("excludeNullLeafs:{}", BeanUtils.toString(excludeNullLeafs));
        assertEquals(expected.length, excludeNullLeafs.length);
    }

}
