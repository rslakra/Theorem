package com.rslakra.theorem.leetcode.peak;

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
 * @created 1/3/24 11:45 AM
 */
public class LC162FindPeakElementTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC162FindPeakElementTest.class);

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
     * Tests the <code>findPeakElement()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void test(int number, int expected) {
        LC162FindPeakElement instance = new LC162FindPeakElement();
        int result = instance.findPeakElement(null);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
    }
}
