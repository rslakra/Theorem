package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import com.devamatre.theorem.adts.tree.TreeFactory;
import com.devamatre.theorem.adts.tree.TreeUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/28/2023 4:25 PM
 */
public abstract class AbstractTreeBuilderTest {

    /**
     * Builds the binary tree of the
     *
     * @param traversalMode
     * @param inputData
     * @return
     */
    public Node<Integer> buildBinaryTree(TraversalMode traversalMode, List<Integer> inputData) {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(traversalMode);
        assertNotNull(treeBuilder);
        Node<Integer> rootNode = treeBuilder.buildBinaryTree(inputData);
        assertNotNull(rootNode);
//        assertEquals(inputData.size(), rootNode.getSize());
        TreeUtils.printPrettyTree(rootNode);
        return rootNode;
    }

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    public abstract void testGetTraversalMode();

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    public abstract void testBuildBinaryTreeWithList();

    /**
     * Tests the <code>buildBinaryTree()</code> method.
     */
    public abstract void testBuildBinaryTreeWithArray();

    /**
     * Tests the <code>buildHierarchicalTree()</code> method.
     */
    public abstract void testBuildHierarchicalTreeWithList();

    /**
     * Tests the <code>buildHierarchicalTree()</code> method.
     */
    public abstract void testBuildHierarchicalTreeWithArray();

    /**
     * Tests the <code>buildTree()</code> method.
     */
    public abstract void testBuildTreeWithList();

    /**
     * Tests the <code>buildTree()</code> method.
     */
    public abstract void testBuildTreeWithArray();

}
