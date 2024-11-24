package com.rslakra.theorem.leetcode.lang;

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
 * @created 1/11/24 3:22 PM
 */
public class LC2139MinimumMovesToReachTargetScoreTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC2139MinimumMovesToReachTargetScoreTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, 0, 0});
        input.add(new Object[]{5, 0, 4});
        input.add(new Object[]{10, 4, 4});
        input.add(new Object[]{16, 3, 4});
        input.add(new Object[]{19, 2, 7});
        input.add(new Object[]{656101987, 1, 328050994});
        input.add(new Object[]{999999998, 0, 999999997});

        return input.iterator();
    }

    /**
     * Tests the <code>findPeakElement()</code> method.
     *
     * @param number
     * @param maxDoubles
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testMinMoves(int number, int maxDoubles, int expected) {
        LOGGER.debug("testMinMoves({}, {}, {})", number, maxDoubles, expected);
        LC2139MinimumMovesToReachTargetScore instance = new LC2139MinimumMovesToReachTargetScore();
        int result = instance.minMoves(number, maxDoubles);
        LOGGER.debug("number:{}, maxDoubles:{}, result:{}", number, maxDoubles, result);
        assertEquals(expected, result);
    }
}
