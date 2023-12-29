package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import com.devamatre.theorem.adts.tree.TreeFactory;
import com.devamatre.theorem.adts.tree.TreeTest;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/28/2023 4:31 PM
 */
public class InOrderTreeBuilderTest extends AbstractTreeBuilderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(InOrderTreeBuilderTest.class);

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
    public void testBuildBinaryTreeWithPreOrder() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
        InOrderTreeBuilder inOrderTreeBuilder = (InOrderTreeBuilder) treeBuilder;
        Node<Integer> rootNode = inOrderTreeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA), Arrays.asList(TreeTest.PRE_ORDER_DATA), null);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(TreeTest.IN_ORDER_DATA.length, TreeUtils.countNodes(rootNode));
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    public void testBuildBinaryTreeWithPostOrder() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
        InOrderTreeBuilder inOrderTreeBuilder = (InOrderTreeBuilder) treeBuilder;
        Node<Integer> rootNode = inOrderTreeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA), null, Arrays.asList(TreeTest.POST_ORDER_DATA));
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(TreeTest.IN_ORDER_DATA.length, TreeUtils.countNodes(rootNode));
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    @Override
    public void testBuildBinaryTreeWithList() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
        InOrderTreeBuilder inOrderTreeBuilder = (InOrderTreeBuilder) treeBuilder;
        Node<Integer> rootNode = inOrderTreeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA), Arrays.asList(TreeTest.PRE_ORDER_DATA), null);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        assertNotNull(rootNode);
        assertEquals(TreeTest.IN_ORDER_DATA.length, TreeUtils.countNodes(rootNode));
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    @Override
    public void testBuildBinaryTreeWithArray() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
    }

    /**
     * Tests the <code>buildHierarchicalTree()</code> method.
     */
    @Test
    @Override
    public void testBuildHierarchicalTreeWithList() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
    }

    /**
     * Tests the <code>buildHierarchicalTree()</code> method.
     */
    @Test
    @Override
    public void testBuildHierarchicalTreeWithArray() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    @Override
    public void testBuildTreeWithList() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    @Override
    public void testBuildTreeWithArray() {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
    }
}
