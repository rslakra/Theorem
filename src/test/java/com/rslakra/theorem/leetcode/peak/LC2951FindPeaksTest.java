package com.rslakra.theorem.leetcode.peak;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 11:46 AM
 */
public class LC2951FindPeaksTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC2951FindPeaksTest.class);

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
     * Tests the <code>findPeaks()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void test(int number, int expected) {
        LC2951FindPeaks instance = new LC2951FindPeaks();
        List<Integer> result = instance.findPeaks(null);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
    }

}
