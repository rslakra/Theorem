package com.devamatre.theorem.leetcode.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.lang.LC1342StepCountToReduceNumberToZero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 1:11 PM
 */
public class LC1342StepCountToReduceNumberToZeroTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC1342StepCountToReduceNumberToZeroTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, 0});
        input.add(new Object[]{5, 4});
        input.add(new Object[]{14, 6});
        input.add(new Object[]{16, 5});
        input.add(new Object[]{123, 12});

        return input.iterator();
    }

    /**
     * Tests the <code>findPeakElement()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testNumberOfSteps(int number, int expected) {
        LOGGER.debug("testNumberOfSteps({}, {})", number, expected);
        LC1342StepCountToReduceNumberToZero instance = new LC1342StepCountToReduceNumberToZero();
        int result = instance.numberOfSteps(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
    }

}
