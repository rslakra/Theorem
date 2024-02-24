package com.devamatre.theorem.leetcode.array;

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
 * @created 1/31/24 3:24 PM
 */
public class LC949LargestTimeForGivenDigitsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC949LargestTimeForGivenDigitsTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: arr = [1,2,3,4]
     *  Output: "23:41"
     *  Explanation:
     *  The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14",
     *  and "23:41". Of these times, "23:41" is the latest.
     *
     * Example 2:
     *  Input: arr = [5,5,5,5]
     *  Output: ""
     *  Explanation: There are no valid 24-hour times as "55:55" is not valid.
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
     * Tests the <code>largestTimeFromDigits()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testLargestTimeFromDigits(int[] inputData, int expected) {
        LOGGER.debug("testLargestTimeFromDigits({}, {}, {})", inputData, expected);
        LC949LargestTimeForGivenDigits instance = new LC949LargestTimeForGivenDigits();
        String result = instance.largestTimeFromDigits(inputData);
        LOGGER.debug("result:{}, expected:{}", result, expected);
        assertEquals(expected, result);
    }

}
