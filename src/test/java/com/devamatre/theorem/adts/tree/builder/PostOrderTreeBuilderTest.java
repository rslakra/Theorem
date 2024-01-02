package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import com.devamatre.theorem.adts.tree.TreeFactory;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 4:33 PM
 */
public class PostOrderTreeBuilderTest extends AbstractTreeBuilderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostOrderTreeBuilderTest.class);

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    @Test
    @Override
    public void testGetTraversalMode() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
        assertEquals(TraversalMode.IN_ORDER_TRAVERSAL, treeBuilder.getTraversalMode());
        assertEquals(InOrderTreeBuilder.class, treeBuilder.getClass());
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    @Override
    public void testBuildBinaryTreeWithList() {
        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Node<Integer> rootNode = buildBinaryTree(TraversalMode.POST_ORDER_TRAVERSAL, Arrays.asList(inputData));
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));
        TreeUtils.printBinaryTree(rootNode);
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    @Override
    public void testBuildBinaryTreeWithArray() {
        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Node<Integer> rootNode = buildBinaryTree(TraversalMode.POST_ORDER_TRAVERSAL, Arrays.asList(inputData));
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));
        TreeUtils.printBinaryTree(rootNode);
    }

    /**
     * Tests the <code>buildHierarchicalTree()</code> method.
     */
    @Test
    @Override
    public void testBuildHierarchicalTreeWithList() {

    }

    /**
     * Tests the <code>buildHierarchicalTree()</code> method.
     */
    @Test
    @Override
    public void testBuildHierarchicalTreeWithArray() {

    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    @Override
    public void testBuildTreeWithList() {

    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    @Override
    public void testBuildTreeWithArray() {

    }
}
