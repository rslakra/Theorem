package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 11/16/23 8:44 PM
 */
public class TreeNodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeNodeTest.class);

    /**
     * <pre>
     * CEO
     * |-- CTO
     * |   |-- Server
     * |   |-- iOS
     * |   |   |-- Objective-C
     * |   |   |-- Swift
     * |   |-- Android
     * |-- CFO
     * </pre>
     * TreeNode
     */
    @Test
    public void testTreeNode() {
        // ROOT
        TreeNode<String> root = new TreeNode("CEO");
        LOGGER.debug("root:{}", root);
        assertNotNull(root);
        assertEquals("CEO", root.getData());
        LOGGER.debug("Edges:{}", TreeNode.maxEdges(root));
        assertEquals(0, TreeNode.maxEdges(root));
        System.out.println();

        // CTO
        TreeNode cto = new TreeNode("CTO");
        assertNotNull(cto);
        root.addChild(cto);
        // Server
        cto.addChild("Server");
        // IOS
        TreeNode iOS = new TreeNode("iOS");
        assertNotNull(iOS);
        cto.addChild(iOS);
        iOS.addChild("Objective-C");
        iOS.addChild("Swift");
        // Android
        cto.addChild("Android");

        // CFO
        TreeNode cfo = new TreeNode("CFO");
        assertNotNull(cfo);
        assertEquals("CFO", cfo.getData());
        root.addChild(cfo);
        LOGGER.debug("Edges:{}", TreeNode.maxEdges(root));
        assertEquals(7, TreeNode.maxEdges(root));
        System.out.println();
    }
}
