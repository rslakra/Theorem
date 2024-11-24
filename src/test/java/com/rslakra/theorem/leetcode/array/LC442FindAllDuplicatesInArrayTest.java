package com.rslakra.theorem.leetcode.array;

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
 * @created 1/31/24 4:21 PM
 */
public class LC442FindAllDuplicatesInArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC442FindAllDuplicatesInArrayTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: nums = [4,3,2,7,8,2,3,1]
     *  Output: [2,3]
     *
     * Example 2:
     *  Input: nums = [1,1,2]
     *  Output: [1]
     *
     * Example 3:
     *  Input: nums = [1]
     *  Output: []
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(2, 3)});
        input.add(new Object[]{new int[]{1, 1, 2}, Arrays.asList(1)});
        input.add(new Object[]{new int[]{1}, Arrays.asList()});

        return input.iterator();
    }

    /**
     * Tests the <code>findDuplicates()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testFindDuplicates(int[] inputData, List<Integer> expected) {
        LOGGER.debug("testFindDuplicates({}, {}, {})", inputData, expected);
        LC442FindAllDuplicatesInArray instance = new LC442FindAllDuplicatesInArray();
        List<Integer> result = instance.findDuplicates(inputData);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
        // assertEquals(expected, instance.findDuplicates2(inputData));
        // assertEquals(expected, instance.findDuplicates3(inputData));
    }
}
