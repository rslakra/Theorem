package com.devamatre.theorem.algos.tree;

import com.devamatre.theorem.adts.tree.AbstractTreeTest;
import com.devamatre.theorem.adts.tree.BinarySearchTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/30/2023 4:22 PM
 */
public class PrintInRangeTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintInRangeTest.class);

    /**
     * Test <code>findInRange()</code> method.
     *
     * <pre>
     *               10
     *             /   \
     *           /      \
     *         /         \
     *        6          16
     *      /  \        /  \
     *     /    \      /    \
     *    4     8     14    20
     *  /  \        /      /  \
     * 3   5      12     18   21
     *           /  \
     *         11   13
     * </pre>
     */
    @Test
    public void testFindInRange() {
        LOGGER.debug("testFindInRange()");
        PrintInRange instance = new PrintInRange();
        BinarySearchTree<Integer>
            tree =
            buildBinarySearchTree(Arrays.asList(10, 6, 4, 3, 5, 8, 16, 14, 12, 11, 13, 20, 18, 21));
        LOGGER.debug("tree:{}", tree);
        assertNotNull(tree);
        tree.printPrettyTree();

        // find in range (3, 6)

        LOGGER.debug("inOrderTraversal:{}", tree.inOrderTraversal());
        List<Integer> findInRange = instance.findInRange(tree.getRoot(), 3, 6);
        LOGGER.debug("findInRange:{}", findInRange);
        assertNotNull(findInRange);
        assertEquals(4, findInRange.size());
        assertEquals(Arrays.asList(3, 4, 5, 6), findInRange);

        // find in range (15, 22)
        findInRange = instance.findInRange(tree.getRoot(), 15, 20);
        LOGGER.debug("findInRange:{}", findInRange);
        assertNotNull(findInRange);
        assertEquals(3, findInRange.size());
        assertEquals(Arrays.asList(16, 18, 20), findInRange);

        // find in range (8, 16)
        findInRange = instance.findInRange(tree.getRoot(), 8, 16);
        LOGGER.debug("findInRange:{}", findInRange);
        assertNotNull(findInRange);
        assertEquals(7, findInRange.size());
        assertEquals(Arrays.asList(8, 10, 11, 12, 13, 14, 16), findInRange);

        // find in range (22, 25)
        findInRange = instance.findInRange(tree.getRoot(), 22, 25);
        LOGGER.debug("findInRange:{}", findInRange);
        assertNotNull(findInRange);
        assertEquals(0, findInRange.size());
        assertEquals(Arrays.asList(), findInRange);
    }


    /**
     * Test <code>printInRange()</code> method.
     *
     * <pre>
     *               10
     *             /   \
     *           /      \
     *         /         \
     *        6          16
     *      /  \        /  \
     *     /    \      /    \
     *    4     8     14    20
     *  /  \        /      /  \
     * 3   5      12     18   21
     *           /  \
     *         11   13
     * </pre>
     */
    @Test
    public void testPrintInRange() {
        LOGGER.debug("testPrintInRange()");
        PrintInRange instance = new PrintInRange();
        BinarySearchTree<Integer>
            tree =
            buildBinarySearchTree(Arrays.asList(10, 6, 4, 3, 5, 8, 16, 14, 12, 11, 13, 20, 18, 21));
        LOGGER.debug("tree:{}", tree);
        assertNotNull(tree);
        tree.printPrettyTree();

        // find in range (3, 6)
        instance.printInRange(tree.getRoot(), 5, 18);
    }
}
