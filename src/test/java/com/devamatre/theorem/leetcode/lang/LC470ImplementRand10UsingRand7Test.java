package com.devamatre.theorem.leetcode.lang;

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
 * @created 1/31/24 3:28 PM
 */
public class LC470ImplementRand10UsingRand7Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC470ImplementRand10UsingRand7Test.class);

    /**
     * <pre>
     * Example 1:
     *  Input: n = 1
     *  Output: [2]
     *
     * Example 2:
     *  Input: n = 2
     *  Output: [2,8]
     *
     * Example 3:
     *  Input: n = 3
     *  Output: [3,8,10]
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
