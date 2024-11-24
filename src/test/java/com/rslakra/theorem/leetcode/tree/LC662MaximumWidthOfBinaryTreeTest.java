package com.rslakra.theorem.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/15/24 3:54 PM
 */
public class LC662MaximumWidthOfBinaryTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC662MaximumWidthOfBinaryTreeTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [1,3,2,5,3,null,9], size = 4
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9}), 4});

        // [1,3,2,5,null,null,9,6,null,7], size = 7
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7}), 7});

        // [1,3,2,5], size = 2
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{1, 3, 2, 5}), 2});

        return input.iterator();
    }

    /**
     * Tests the <code>widthOfBinaryTree()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testWidthOfBinaryTree(TreeNode inputData, int expected) {
        LOGGER.debug("testWidthOfBinaryTree({}, {})", TreeNode.toString(inputData), expected);
        LC662MaximumWidthOfBinaryTree instance = new LC662MaximumWidthOfBinaryTree();
        int result = instance.widthOfBinaryTree(inputData);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
        assertEquals(expected, instance.widthOfBinaryTree2(inputData));
    }
}
