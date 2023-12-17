package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 12/13/23 8:09 AM
 */
public class NaryTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NaryTreeTest.class);

    /**
     * NaryNode
     * <pre>
     * Lakra
     * |-- Rohtash
     * |   |-- R Singh
     * |   |-- RS Lakra
     * |-- Singh
     * |   |-- RS
     * </pre>
     */
    @Test
    public void testNaryTree() {
        NaryTree<String> tree = new NaryTree<>();
        assertNotNull(tree);
        assertEquals(0, tree.getSize());
        tree.add("Lakra");
        assertEquals(1, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        // rohtash tree
        NaryNode<String> rohtashTree = new NaryNode<>("Rohtash");
        assertNotNull(rohtashTree);
        assertEquals(0, rohtashTree.getChildren().size());
        rohtashTree.addChild("R Singh");
        rohtashTree.addChild("RS Lakra");
        LOGGER.debug("rohtashTree:{}", rohtashTree);
        tree.addChild(rohtashTree);
        assertEquals(4, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        // singh tree
        NaryNode<String> singhTree = new NaryNode<>("Singh");
        assertNotNull(singhTree);
        assertEquals(0, singhTree.getChildren().size());
        singhTree.addChild("RS");
        LOGGER.debug("singhTree:{}", singhTree);
        tree.addChild(singhTree);
        assertEquals(6, tree.getSize());
        LOGGER.debug("tree:{}", tree);
    }
}
