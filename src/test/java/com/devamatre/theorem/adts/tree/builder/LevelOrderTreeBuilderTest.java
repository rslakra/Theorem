package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import com.devamatre.theorem.adts.tree.TreeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/28/2023 4:32 PM
 */
public class LevelOrderTreeBuilderTest extends AbstractTreeBuilderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LevelOrderTreeBuilderTest.class);

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
