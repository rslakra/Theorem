package com.devamatre.theorem.leetcode.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.lang.LC2169CountOperationsToObtainZero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 1:56 PM
 */
public class LC2169CountOperationsToObtainZeroTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LC2169CountOperationsToObtainZeroTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, 0, 0});
        input.add(new Object[]{2, 3, 3});
        input.add(new Object[]{1, 1, 1});
        input.add(new Object[]{16, 3, 8});
        input.add(new Object[]{1601, 16, 116});

        return input.iterator();
    }

    /**
     * Tests the <code>findPeakElement()</code> method
     *
     * @param num1
     * @param num2
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testCountOperations(int num1, int num2, int expected) {
        LOGGER.debug("testCountOperations({}, {}, {})", num1, num2, expected);
        LC2169CountOperationsToObtainZero instance = new LC2169CountOperationsToObtainZero();
        int result = instance.countOperations(num1, num2);
        LOGGER.debug("num1:{}, num2:{}, result:{}", num1, num2, result);
        assertEquals(expected, result);
    }

}
