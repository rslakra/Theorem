package com.devamatre.theorem.adts.tree.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 4:32 PM
 */
public class PreOrderTreeBuilderTest extends AbstractTreeBuilderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreOrderTreeBuilderTest.class);

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
        Node<Integer>
            rootNode =
            buildBinaryTree(TraversalMode.PRE_ORDER_TRAVERSAL, Arrays.asList(TreeTest.PRE_ORDER_DATA_WITH_NEGATIVE));
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        Integer[] expected = new Integer[]{1, 2, 4, 5, 3, 6, 7, 8};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));
        TreeUtils.printBinaryTree(rootNode);
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    @Override
    public void testBuildBinaryTreeWithArray() {

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
