package com.devamatre.theorem.leetcode.array;

import static org.testng.AssertJUnit.assertEquals;

import com.devamatre.theorem.leetcode.array.LC15ThreeSum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 4:10 PM
 */
public class LC15ThreeSumTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LC15ThreeSumTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}});
        input.add(new Object[]{new int[]{2, 3, 4}, 6, new int[]{1, 3}});
        input.add(new Object[]{new int[]{-1, 0}, -1, new int[]{1, 2}});

        return input.iterator();
    }

    /**
     * Tests the <code>threeSum()</code> method
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testThreeSum(int[] inputData, List<List<Integer>> expected) {
        LOGGER.debug("testThreeSum({}, {}, {})", inputData, expected);
        LC15ThreeSum instance = new LC15ThreeSum();
        List<List<Integer>> result = instance.threeSum(inputData);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
    }
}
