package com.rslakra.theorem.algos.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.tree.AbstractTreeTest;
import com.rslakra.theorem.adts.tree.Node;
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
public class FindLowestCommonAncestorTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindLowestCommonAncestorTest.class);

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
    public Iterator<Object[]> inputData() {
        List<Object[]> input = new LinkedList<>();
        input.add(new Object[]{Arrays.asList(4, 3, 5), 3, 5, 4});
        input.add(new Object[]{Arrays.asList(6, 4, 3, 5, 8), 3, 8, 4});
        input.add(new Object[]{Arrays.asList(6, 4, 3, 5, 8), 5, 8, 6});
        input.add(new Object[]{Arrays.asList(10, 6, 4, 8, 16, 14, 20), 11, 20, 16});
        input.add(new Object[]{Arrays.asList(10, 6, 4, 8, 16, 14, 20), 14, 18, 16});
        input.add(new Object[]{Arrays.asList(10, 6, 4, 8, 16, 14, 20), 7, 20, null});
        input.add(new Object[]{Arrays.asList(10, 6, 4, 8, 16, 14, 20), 4, 20, 10});

        return input.iterator();
    }

    /**
     * Test <code>findLowestCommonAncestor()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindLowestCommonAncestor(List<Integer> inputData, Integer source, Integer target,
                                             Integer expected) {
        LOGGER.debug("findLowestCommonAncestor({}, {}, {}, {})", inputData, source, target, expected);
        FindLowestCommonAncestor instance = new FindLowestCommonAncestor();
        LOGGER.debug("tree:{}", instance);
        assertNotNull(instance);
        fillTree(instance, inputData);

        // find in range (3, 6)
        Node<Integer> commonAncestor = instance.findLowestCommonAncestor(instance.getRoot(), source, target);
        LOGGER.debug("commonAncestor:{}", commonAncestor);
        assertNotNull(commonAncestor);
        // assertEquals(4, root2LeafPath.size());
        assertEquals(expected, commonAncestor.getData());
    }

}
