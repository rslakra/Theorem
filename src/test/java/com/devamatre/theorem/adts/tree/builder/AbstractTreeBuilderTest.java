package com.devamatre.theorem.adts.tree.builder;

import com.devamatre.theorem.adts.tree.AbstractTreeTest;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/28/2023 4:25 PM
 */
public abstract class AbstractTreeBuilderTest extends AbstractTreeTest {

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
