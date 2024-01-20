package com.devamatre.theorem.adts.tree.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import com.devamatre.theorem.adts.tree.TreeFactory;
import com.devamatre.theorem.adts.tree.TreeTest;
import com.devamatre.theorem.adts.tree.TreeTraversal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(TraversalMode.LEVEL_ORDER_TRAVERSAL);
        LOGGER.debug("treeBuilder:{}", treeBuilder);
        assertNotNull(treeBuilder);
        assertEquals(TraversalMode.LEVEL_ORDER_TRAVERSAL, treeBuilder.getTraversalMode());
        assertEquals(LevelOrderTreeBuilder.class, treeBuilder.getClass());
    }

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    @Test
    @Override
    public void testBuildBinaryTreeWithList() {
        Node<Integer>
            rootNode =
            buildBinaryTree(TraversalMode.LEVEL_ORDER_TRAVERSAL,
                            Arrays.asList(TreeTest.LEVEL_ORDER_DATA_WITH_NEGATIVE));
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        TreeTraversal<Integer> treeTraversal = TreeFactory.treeTraverser(rootNode, TraversalMode.LEVEL_ORDER_TRAVERSAL);
        List<Integer> levelOrder = treeTraversal.traverse(false);
        assertEquals(Arrays.asList(TreeTest.LEVEL_ORDER_DATA), levelOrder);
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
