package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
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
}
