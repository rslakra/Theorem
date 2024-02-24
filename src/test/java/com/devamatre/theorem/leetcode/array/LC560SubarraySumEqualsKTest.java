package com.devamatre.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.array.LC560SubarraySumEqualsK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 1:42 PM
 */
public class LC560SubarraySumEqualsKTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC560SubarraySumEqualsKTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, 0});
        input.add(new Object[]{1, 1});
        input.add(new Object[]{2, 1});
        input.add(new Object[]{3, 4});
        input.add(new Object[]{4, 4});
        input.add(new Object[]{5, 9});
        input.add(new Object[]{10, 25});
        input.add(new Object[]{75, 1444});

        return input.iterator();
    }

    /**
     * Tests the <code>sumSubarray()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testSumSubarray(int[] inputData, int expected) {
        LC560SubarraySumEqualsK instance = new LC560SubarraySumEqualsK();
        int result = instance.sumSubarray(inputData, 0);
        LOGGER.debug("number:{}, result:{}", inputData, result);
        assertEquals(expected, result);
    }
}
