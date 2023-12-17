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
public class NaryNodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NaryNodeTest.class);

    /**
     * NaryNode
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
     */
    @Test
    public void testTreeNode() {
        // ROOT
        NaryNode<String> root = new NaryNode("CEO");
        LOGGER.debug("root:{}", root);
        assertNotNull(root);
        assertEquals("CEO", root.getData());
        LOGGER.debug("Edges:{}", NaryNode.maxEdges(root));
        assertEquals(0, NaryNode.maxEdges(root));
        System.out.println();

        // CTO
        NaryNode cto = new NaryNode("CTO");
        assertNotNull(cto);
        root.addChild(cto);
        // Server
        cto.addChild("Server");
        // IOS
        NaryNode iOS = new NaryNode("iOS");
        assertNotNull(iOS);
        cto.addChild(iOS);
        iOS.addChild("Objective-C");
        iOS.addChild("Swift");
        // Android
        cto.addChild("Android");

        // CFO
        NaryNode cfo = new NaryNode("CFO");
        assertNotNull(cfo);
        assertEquals("CFO", cfo.getData());
        root.addChild(cfo);
        LOGGER.debug("Edges:{}", NaryNode.maxEdges(root));
        assertEquals(7, NaryNode.maxEdges(root));
        System.out.println();
    }
}
