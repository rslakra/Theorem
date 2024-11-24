package com.rslakra.theorem.leetcode.array.matrix;

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
 * @created 1/31/24 3:58 PM
 */
public class LC1559DetectCyclesIn2DGridTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC1559DetectCyclesIn2DGridTest.class);

    /**
     * <url>https://leetcode.com/problems/detect-cycles-in-2d-grid</url>
     * <pre>
     * Example 1:
     *
     *
     *
     * Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
     * Output: true
     * Explanation: There are two valid cycles shown in different colors in the image below:
     *
     * Example 2:
     *
     *
     *
     * Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
     * Output: true
     * Explanation: There is only one valid cycle highlighted in the image below:
     *
     * Example 3:
     *
     *
     *
     * Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
     * Output: false
     *
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}});
        input.add(new Object[]{new int[]{3, 2, 4}, 6, new int[]{1, 2}});
        input.add(new Object[]{new int[]{-1, 0}, -1, new int[]{0, 1}});

        return input.iterator();
    }

    /**
     * Tests the <code>containsCycle()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testContainsCycle(char[][] inputData, int expected) {
        LOGGER.debug("testContainsCycle({}, {})", inputData, expected);
        LC1559DetectCyclesIn2DGrid instance = new LC1559DetectCyclesIn2DGrid();
        boolean result = instance.containsCycle(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
