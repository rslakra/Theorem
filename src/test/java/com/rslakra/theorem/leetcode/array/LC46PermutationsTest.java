package com.rslakra.theorem.leetcode.array;

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
 * @created 1/31/24 3:14 PM
 */
public class LC46PermutationsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC46PermutationsTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: nums = [1,2,3]
     *  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * Example 2:
     *  Input: nums = [0,1]
     *  Output: [[0,1],[1,0]]
     *
     * Example 3:
     *  Input: nums = [1]
     *  Output: [[1]]
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
     * Tests the <code>permute()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testPermute(int[] inputData, List<List<Integer>> expected) {
        LOGGER.debug("testPermute({}, {}, {})", inputData, expected);
        LC46Permutations instance = new LC46Permutations();
        List<List<Integer>> result = instance.permute(inputData);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
        assertEquals(expected, instance.permute2(inputData));
    }
}
