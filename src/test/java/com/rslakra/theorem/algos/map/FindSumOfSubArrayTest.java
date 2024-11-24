package com.rslakra.theorem.algos.map;

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
 * @created 11/30/23 10:54 AM
 */
public class FindSumOfSubArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindSumOfSubArrayTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * Subarray sum equal to k (return number of such sub-arrays which sum is equal to k)
         *
         * <pre>
         *  Example 1:
         *      input[] = {1, 2, 3}
         *      k = 3
         *      output[] = 2 => {{1, 2,} {3}}
         *
         *  Example 2:
         *      input[] = {10, 2, -2, -20, 10}
         *      k = -10
         *      output[] = 3 => {{10, 2, -2} {2, -2, -20, 10}, {-20, 10}}
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{1, 2, 3}, 3, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3))});
        inputs.add(new Object[]{new Integer[]{10, 2, -2, -20, 10}, -10,
                                Arrays.asList(Arrays.asList(10, 2, -2), Arrays.asList(2, -2, -20, 10),
                                              Arrays.asList(-20, 10))});

        return inputs.iterator();
    }

    /**
     * Test <code>sumOfSubArray</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testSumOfSubArray(Integer[] inputData, int k, List<List<Integer>> expected) {
        LOGGER.debug("testFindItinerary({}, {}, {})", inputData, k, expected);
        FindSumOfSubArray instance = new FindSumOfSubArray();
        List<List<Integer>> result = instance.sumOfSubArray(inputData, k);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Test <code>sumOfSubArrayCount</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testSumOfSubArrayCount(Integer[] inputData, int k, List<List<Integer>> expected) {
        LOGGER.debug("testFindItinerary({}, {}, {})", inputData, k, expected);
        FindSumOfSubArray instance = new FindSumOfSubArray();
        int result = instance.sumOfSubArrayCount(inputData, k);
        LOGGER.debug("result:{}", result);
        assertEquals(expected.size(), result);
    }

}
