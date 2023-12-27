package com.devamatre.theorem.adts.tree.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 12/6/23 4:44 PM
 */
public class PrintPrettyTreeHorizontallyTest extends PrintPrettyTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintPrettyTreeHorizontallyTest.class);

    /**
     * Tests the <code>printPrettyTreeHorizontally</code> method.
     */
    @Test
    public void testPrintPrettyTreeHorizontally() {
        final Node<Integer> root = new Node<Integer>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));

        int maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

//        LOGGER.debug("\n{}", TreeUtils.printPrettyTree(root));
        StringBuilder printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().setLeft(new Node<>(4));
        maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);
    }


}
