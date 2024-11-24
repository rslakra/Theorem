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
 * @version 1.0.0
 * @since 01/02/2024 8:14 AM
 */
public class LC2210CountHillsAndValleysInArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC2210CountHillsAndValleysInArrayTest.class);

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
     * Tests the <code>countHillValley()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testCountHillValley(int number, int expected) {
        LC2210CountHillsAndValleysInArray instance = new LC2210CountHillsAndValleysInArray();
        int result = instance.countHillValley(null);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
    }

}
