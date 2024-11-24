package com.rslakra.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rslakra.theorem.leetcode.lang.LC470ImplementRand10UsingRand7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:38 PM
 */
public class LC128LongestConsecutiveSequenceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC128LongestConsecutiveSequenceTest.class);

    /**
     * <url>https://leetcode.com/problems/longest-consecutive-sequence</url>
     * <pre>
     * Example 1:
     *  Input: nums = [100,4,200,1,3,2]
     *  Output: 4
     *  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
     *  Therefore its length is 4.
     *
     * Example 2:
     *  Input: nums = [0,3,7,2,5,8,4,6,0,1]
     *  Output: 9
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
     * Tests the <code>rand10()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testRand10() {
        LOGGER.debug("testRand10()");
        LC470ImplementRand10UsingRand7 instance = new LC470ImplementRand10UsingRand7();
        int result = instance.rand10();
        LOGGER.debug("result:{}, expected:{}", result);
        assertEquals(result, instance.rand10Optimized());
    }
}
