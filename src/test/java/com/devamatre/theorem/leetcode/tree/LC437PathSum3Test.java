package com.devamatre.theorem.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.tree.LC437PathSum3;
import com.devamatre.theorem.leetcode.tree.TreeNode;
import com.devamatre.theorem.leetcode.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/22/24 6:01 PM
 */
public class LC437PathSum3Test {

    private static Logger LOGGER = LoggerFactory.getLogger(LC437PathSum3Test.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8, 3});
        input.add(
            new Object[]{TreeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22, 3});

        return input.iterator();
    }

    /**
     * Tests the <code>pathSum()</code> method
     *
     * @param root
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testPathSum(TreeNode root, int target, int expected) {
        LOGGER.debug("testPathSum({}, {}, {})", root, target, expected);
        LC437PathSum3 instance = new LC437PathSum3();
        int result = instance.pathSum(root, target);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
    }
}
