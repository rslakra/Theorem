package com.devamatre.theorem.algos.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.tree.AbstractTreeTest;
import com.devamatre.theorem.adts.tree.BinarySearchTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/30/2023 4:22 PM
 */
public class FindPathsTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindPathsTest.class);

    /**
     * Build tree from the following subTrees as input.
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
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findPathData() {
        List<Object[]> input = new LinkedList<>();
        input.add(new Object[]{Arrays.asList(4, 3, 5), Arrays.asList(Arrays.asList(4, 3), Arrays.asList(4, 5))});
        input.add(new Object[]{Arrays.asList(6, 4, 3, 5, 8),
                               Arrays.asList(Arrays.asList(6, 4, 3), Arrays.asList(6, 4, 5), Arrays.asList(6, 8))});
        input.add(new Object[]{Arrays.asList(10, 6, 4, 8, 16, 14, 20),
                               Arrays.asList(Arrays.asList(10, 6, 4), Arrays.asList(10, 6, 8),
                                             Arrays.asList(10, 16, 14), Arrays.asList(10, 16, 20))});

        return input.iterator();
    }

    /**
     * Test <code>findAllRoot2LeafPaths</code> method.
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
    @Test(dataProvider = "findPathData")
    public void testFindAllRoot2LeafPaths(List<Integer> inputData, List<List<Integer>> expected) {
        LOGGER.debug("testFindAllRoot2LeafPaths()");
        FindPaths instance = new FindPaths();
        BinarySearchTree<Integer> tree = buildBinarySearchTree(inputData);
        LOGGER.debug("tree:{}", tree);
        assertNotNull(tree);

        // find in range (3, 6)
        LOGGER.debug("inOrderTraversal:{}", tree.inOrderTraversal());
        List<List<Integer>> root2LeafPath = instance.findAllRoot2LeafPaths(tree.getRoot());
        LOGGER.debug("root2LeafPath:{}", root2LeafPath);
        assertNotNull(root2LeafPath);
        //  assertEquals(4, root2LeafPath.size());
        assertEquals(expected, root2LeafPath);
    }

}
