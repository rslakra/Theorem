package com.rslakra.theorem.adts.tree.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeIterator;
import com.rslakra.theorem.adts.tree.TreeUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 5:15 PM
 */
public class PreOrderIteratorTest extends AbstractTreeIteratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreOrderIteratorTest.class);

    /**
     * @return
     */
    @Override
    public TreeIterator buildTreeIterator() {
        LOGGER.debug("+buildTreeIterator()");
        Node<Integer> rootNode = TreeUtils.buildTree(Arrays.asList(4, 2, 5, 1, 3, 7, 6, 8));
        LOGGER.debug("rootNode:{}", rootNode);
        TreeUtils.printBinaryTree(rootNode);
        TreeIterator<Integer> treeIterator = new PreOrderIterator<>(rootNode);
        assertNotNull(treeIterator);
        LOGGER.debug("treeIterator:{}", treeIterator);
        assertEquals(PreOrderIterator.class, treeIterator.getClass());
        LOGGER.debug("-buildTreeIterator(), treeIterator:{}", treeIterator);
        return treeIterator;
    }

    /**
     * Tests the <code>treeNodesTraversal()</code> method.
     */
    @Test
    public void testTreeIterator() {
        LOGGER.debug("testTreeIterator()");
        TreeIterator<Integer> treeIterator = buildTreeIterator();
        LOGGER.debug("treeIterator:{}", treeIterator);
        assertNotNull(treeIterator);

        logTreeIterator(treeIterator);
    }

}
