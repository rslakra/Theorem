package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 11/16/23 8:51 PM
 */
public class TrieNodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrieNodeTest.class);

    /**
     * <pre>
     * CEO
     * |-- CTO
     * |   |-- Server
     * |   |-- Mobile
     * |   |    |-- iOS
     * |   |    |   |-- Objective-C
     * |   |    |   |-- Swift
     * |   |    |-- Android
     * |-- CFO
     * </pre>
     *
     * @return
     */
    public static Node<String> buildNodes() {
        Node<String> root = new Node<>("CEO");
        // left and right nodes
        root.setLeft(new Node<>("CTO"));
        root.setRight(new Node<>("CFO"));

        // left's left node
        root.getLeft().setLeft(new Node<>("Server"));
        // left's right node
        root.getLeft().setRight(new Node<>("Mobile"));

        // left's right node's left node
        root.getLeft().getRight().setLeft(new Node<>("iOS"));
        root.getLeft().getRight().setRight(new Node<>("Android"));

        // left's right node's left node's left nodea
        root.getLeft().getRight().getLeft().setLeft(new Node<>("Objective-C"));
        root.getLeft().getRight().getLeft().setRight(new Node<>("Swift"));

        return root;
    }

    @Test
    public void testNode() {
        Node<String> root = new Node<>("Rohtash");
        LOGGER.debug("root:{}", root);
        assertNotNull(root);
        assertNull(root.getParent());
        assertEquals("Rohtash", root.getData());
        assertNull(root.getLeft());
        assertNull(root.getRight());
        TreeUtils.printBinaryTree(root);
    }

    /**
     *
     */
    @Test
    public void testBuildNodes() {
        // ROOT
        Node<String> root = buildNodes();
        assertNotNull(root);
        assertEquals("CEO", root.getData());
        LOGGER.debug("root:{}", root);
        TreeUtils.printBinaryTree(root);
    }
}
