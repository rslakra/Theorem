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
 * @created 1/16/24 3:45 PM
 */
public class LC653TwoSumIVInputBSTTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC653TwoSumIVInputBSTTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [5,3,6,2,4,null,7], k = 9
        TreeNode rootNode = TreeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        input.add(new Object[]{rootNode, 9, true});

        // [5,3,6,2,4,null,7], k = 28
        input.add(new Object[]{rootNode, 28, false});

        return input.iterator();
    }

    /**
     * Tests the <code>findTarget()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testCheckSubarraySum(TreeNode inputData, int target, boolean expected) {
        LOGGER.debug("testCheckSubarraySum({}, {}, {})", inputData, target, expected);
        LC653TwoSumIVInputBST instance = new LC653TwoSumIVInputBST();
        boolean result = instance.findTarget(inputData, target);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
    }
}
