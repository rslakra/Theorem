package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/16/23 9:22 PM
 */
public class IntBinaryTreeTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntBinaryTreeTest.class);

    /**
     * @param inputData
     * @return
     */
    private IntBinaryTree buildIntBinaryTree(List<Integer> inputData) {
        final IntBinaryTree tree = new IntBinaryTree();
        fillTree(tree, inputData);
        return tree;
    }

    @Test
    public void testIntBinaryTree() {
        IntBinaryTree binaryTree = buildIntBinaryTree(Arrays.asList(50, 21, 4, 32, 3, 16, 60, 55, 75));
        assertNotNull(binaryTree);
        LOGGER.debug("binaryTree: {}", binaryTree);
        System.out.println();

        Node<Integer> nodeFound = binaryTree.findNode(16);
        assertNotNull(nodeFound);
        LOGGER.debug("nodeFound: {}", nodeFound);
        System.out.println();

        LOGGER.debug("PreOrder Traversal");
        binaryTree.preOrderTraversal();
        System.out.println();

        LOGGER.debug("InOrder Traversal");
        binaryTree.inOrderTraversal();
        System.out.println();

        LOGGER.debug("PostOrder Traversal");
        binaryTree.postOrderTraversal();
        System.out.println();

        LOGGER.debug("Level Order Traversal");
        binaryTree.levelOrderTraversal();
        System.out.println();

        LOGGER.debug("Tree TopView Traversal");
        binaryTree.treeViewTraversal();
        System.out.println();

        LOGGER.debug("Tree BottomView Traversal");
        binaryTree.treeBottomViewTraversal();
        System.out.println();

        LOGGER.debug("Tree LeftView Traversal");
        binaryTree.treeLeftViewTraversal();
        System.out.println();

        LOGGER.debug("Tree RightView Traversal");
        binaryTree.treeRightViewTraversal();
        System.out.println();
    }

    @Test
    public void testIntegerBinaryTree() {
        IntBinaryTree tree = buildIntBinaryTree(Arrays.asList(50, 76, 21, 4, 16, 3, 32, 100, 64, 52, 102));
        LOGGER.debug("tree:{}", tree);
        assertNotNull(tree);
        assertEquals(11, tree.getSize());
        System.out.println();

        // Add Nodes
        tree.addNode(50);
        assertEquals(12, tree.getSize());
        System.out.println();

        // add duplicates
        tree.addNode(21);
        tree.addNode(4);
        tree.addNode(16);
        tree.addNode(3);
        tree.addNode(32);
        assertEquals(17, tree.getSize());
        LOGGER.debug("tree:{}", tree);
        System.out.println();

        // Find values that exists
        Integer[] findNumbers = new Integer[]{32, 21, 16};
        for (Integer findWhat : findNumbers) {
            LOGGER.debug("Finding {} ...", findWhat);
            Node foundNode = tree.findNode(findWhat);
            LOGGER.debug("foundNode:{}", foundNode);
            assertNotNull(foundNode);
            assertEquals(findWhat, foundNode.getData());
        }

        System.out.println();
        // Find value that doesn't exist
        Integer findWhat = 80;
        LOGGER.debug("Finding {} ...", findWhat);
        Node notFound = tree.findNode(findWhat);
        LOGGER.debug("notFound:{}", notFound);
        assertNull(notFound);

        // Delete node.
        // tree.removeNode(50);
        LOGGER.debug("tree:{}", tree);
        System.out.println();

        // validate preOrderTraversal
        LOGGER.debug("preOrderTraversal ...");
        List<Integer> preOrderTraversal = tree.preOrderTraversal();
        LOGGER.debug("preOrderTraversal:{}", preOrderTraversal);
        assertNotNull(preOrderTraversal);
        assertEquals("[50, 50, 21, 21, 4, 4, 3, 3, 16, 16, 32, 32, 76, 64, 52, 100, 102]",
                     preOrderTraversal.toString());
        System.out.println();

        LOGGER.debug("preOrderIterator ...");
        Iterator<Integer> preOrderItr = tree.preOrderIterator();
        assertIteratorWithTraversal(preOrderItr, preOrderTraversal);
        System.out.println();

        // validate inOrderTraversal
        LOGGER.debug("inOrderTraversal ...");
        List<Integer> inOrderTraversal = tree.inOrderTraversal();
        LOGGER.debug("inOrderTraversal:{}", inOrderTraversal);

        LOGGER.debug("inOrderIterator ...");
        Iterator<Integer> inOrderItr = tree.inOrderIterator();
        assertIteratorWithTraversal(inOrderItr, inOrderTraversal);
        System.out.println();

        // validate inOrderTraversal
        LOGGER.debug("postOrderTraversal ...");
        List<Integer> postOrderTraversal = tree.postOrderTraversal();
        LOGGER.debug("postOrderTraversal:{}", postOrderTraversal);

        LOGGER.debug("postOrderIterator ...");
        Iterator<Integer> postOrderItr = tree.postOrderIterator();
        assertIteratorWithTraversal(postOrderItr, postOrderTraversal);
    }
}
