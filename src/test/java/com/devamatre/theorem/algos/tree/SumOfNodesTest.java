package com.devamatre.theorem.algos.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.tree.AbstractTreeTest;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/28/23 10:55 AM
 */
public class SumOfNodesTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumOfNodesTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> sumOfNodesAtKthLevelData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 1, 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 2, 5});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 3, 22});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 4, 17});

        return inputs.iterator();
    }

    /**
     * Test <code>sumOfNodesAtKthLevel</code> method.
     */
    @Test(dataProvider = "sumOfNodesAtKthLevelData")
    public void testSumOfNodesAtKthLevel(List<Integer> inputData, int level, int expected) {
        LOGGER.debug("testSumOfNodesAtKthLevel({}, {}, {})", inputData, level, expected);
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        // crate instance.
        SumOfNodes instance = new SumOfNodes();
        int sumOfNodes = instance.sumOfNodesAtKthLevel(rootNode, level);
        LOGGER.debug("expected:{}, sumOfNodes:{}", expected, sumOfNodes);
        assertEquals(expected, sumOfNodes);
    }

}
