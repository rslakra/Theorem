package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.appsuite.core.BeanUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 11/24/23 1:43 PM
 */
public class TreeTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeTest.class);

    /**
     * Build Tree with strings.
     */
    @Test
    public void testBuildStringTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        fillTreeWithPresidents(tree);
        assertNotNull(tree);
        assertEquals(9, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        assertTrue(tree.contain("Jackson"));
    }

    /**
     * Test build tree.
     */
    @Test
    @Override
    public void testBuildTree() {
        Tree<Integer> tree = new Tree<>();
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);
        TreeUtils.printPrettyTree(tree.root);
    }

    /**
     * Test build tree.
     */
    @Test
    public void testBuildPreOrderTree() {
        Tree<Integer> tree = new Tree<>();
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);

        Integer[] inputData = new Integer[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7, -1, -1, 8};
        // build preOrder tree
        tree.buildPreOrderTree(inputData);
        LOGGER.debug("tree:{}", tree);
        TreeUtils.printBinaryTree(tree.root);

        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.root), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
    }

    /**
     * Test build tree.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    @Override
    public void testAddNode() {
        Tree<Integer> tree = new Tree<>();
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        assertEquals(1, tree.getSize());
        TreeUtils.printBinaryTree(tree.root);
        assertTreePreOrder(tree, new Integer[]{1});
    }

}
