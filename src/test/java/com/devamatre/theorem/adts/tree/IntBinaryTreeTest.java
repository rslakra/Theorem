package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.appsuite.core.BeanUtils;
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
public class IntBinaryTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntBinaryTreeTest.class);

    /**
     * @param list
     * @return
     */
    static IntBinaryTree buildIntBinaryTree(List<Integer> list) {
        final IntBinaryTree binaryTree = new IntBinaryTree();
        if (BeanUtils.isNotEmpty(list)) {
            list.forEach(value -> binaryTree.insertNode(value));
        }

        return binaryTree;
    }

    @Test
    public void testIntBinaryTree() {
        IntBinaryTree binaryTree = buildIntBinaryTree(Arrays.asList(50, 21, 4, 32, 3, 16, 60, 55, 75));
        assertNotNull(binaryTree);
        LOGGER.debug("binaryTree: {}", binaryTree);
        System.out.println();

        Node<Integer> nodeFound = binaryTree.searchNode(16);
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
        IntBinaryTree bst = buildIntBinaryTree(Arrays.asList(50, 76, 21, 4, 16, 3, 32, 100, 64, 52, 102));

        // Add Nodes
        bst.addNode(50);
        // bst.addNode(76);

        bst.addNode(21);
        bst.addNode(4);
        bst.addNode(16);
        bst.addNode(3);
        bst.addNode(32);

        // bst.addNode(100);
        // bst.addNode(64);
        // bst.addNode(52);
        // bst.addNode(102);
        System.out.println(bst);

        // Find PairNode
        System.out.println("Finding ... 32");
        Node found = bst.findNode(32);
        System.out.println("Found:" + found);

        System.out.println("Finding ... 64");
        found = bst.findNode(64);
        System.out.println("Found:" + found);

        System.out.println("Finding ... 80");
        found = bst.findNode(80);
        System.out.println("Found:" + found);

        // Delete PairNode.
        // bst.removeNode(50);
        System.out.println(bst);

        System.out.println("PreOrder:" + bst.preOrderTraversal(true));
        System.out.println("\nPreOrderIterator Results:");
        Iterator<Node> itr = bst.preOrderIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nInOrderIterator Results:");
        itr = bst.inOrderIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nPostOrderIterator Results:");
        itr = bst.postOrderIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
