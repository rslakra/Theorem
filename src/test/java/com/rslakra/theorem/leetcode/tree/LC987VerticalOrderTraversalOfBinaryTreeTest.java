package com.rslakra.theorem.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * @created 1/30/24 4:37 PM
 */
public class LC987VerticalOrderTraversalOfBinaryTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC987VerticalOrderTraversalOfBinaryTree.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [3,9,20,null,null,15,7] => [[9],[3,15],[20],[7]]
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}),
                               Arrays.asList(Arrays.asList(9), Arrays.asList(3, 15), Arrays.asList(20),
                                             Arrays.asList(7))});

        // [1,2,3,4,5,6,7] => [[4],[2],[1,5,6],[3],[7]]
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7}),
                               Arrays.asList(Arrays.asList(4), Arrays.asList(2), Arrays.asList(1, 5, 6),
                                             Arrays.asList(3), Arrays.asList(7))});

        // [1,2,3,4,6,5,7] => [[4],[2],[1,5,6],[3],[7]]
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 6, 5, 7}),
                               Arrays.asList(Arrays.asList(4), Arrays.asList(2), Arrays.asList(1, 5, 6),
                                             Arrays.asList(3), Arrays.asList(7))});

        // [0,null,1] => [[0],[1]]
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{0, null, 1}),
                               Arrays.asList(Arrays.asList(0), Arrays.asList(1))});

        // [3,1,4,0,2,2] => [[0],[1],[3,2,2],[4]]
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{3, 1, 4, 0, 2, 2}),
                               Arrays.asList(Arrays.asList(0), Arrays.asList(1), Arrays.asList(3, 2, 2),
                                             Arrays.asList(4))});

        return input.iterator();
    }

    /**
     * Tests the <code>verticalTraversal()</code> method.
     *
     * @param inputData
     */
    @Test(dataProvider = "inputData")
    public void testLongestVerticalTraversal(TreeNode inputData, List<List<Integer>> expected) {
        LOGGER.debug("testLongestVerticalTraversal({})", inputData);
        LC987VerticalOrderTraversalOfBinaryTree instance = new LC987VerticalOrderTraversalOfBinaryTree();
        List<List<Integer>> verticalTraversal = instance.verticalTraversal(inputData);
        LOGGER.debug("verticalTraversal:{}", verticalTraversal);
        assertEquals(expected, verticalTraversal);
    }

}
