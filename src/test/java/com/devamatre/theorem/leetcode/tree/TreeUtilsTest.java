package com.devamatre.theorem.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.tree.TreeNode;
import com.devamatre.theorem.leetcode.tree.TreeUtils;
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
 * @created 1/22/24 7:07 PM
 */
public class TreeUtilsTest {

    private static Logger LOGGER = LoggerFactory.getLogger(TreeUtilsTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}),
                               Arrays.asList(10, 5, 3, 3, -2, 2, 1, -3, 11)});
        input.add(new Object[]{TreeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}),
                               Arrays.asList(5, 4, 11, 7, 2, 8, 13, 4, 5, 1)});

        return input.iterator();
    }

    /**
     * Tests the <code>inOrderTraversal()</code> method
     */
    @Test(dataProvider = "inputData")
    public void testBuildTree(TreeNode rootNode, List<Integer> expected) {
        LOGGER.debug("testBuildTree({}, {})", rootNode, expected);
        List<TreeNode> preOrder = TreeUtils.preOrderTraversal(rootNode);
        LOGGER.debug("preOrder:{}", preOrder);
        LOGGER.debug("preOrder:{}", TreeUtils.asList(preOrder));
        assertEquals(expected, TreeUtils.asList(preOrder));
    }
}
