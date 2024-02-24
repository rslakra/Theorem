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
 * @created 1/24/24 5:28 PM
 */
public class LC27RemoveElementTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC27RemoveElementTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{1}, 1, 0});
        input.add(new Object[]{new int[]{2}, 3, 1});
        input.add(new Object[]{new int[]{3, 3}, 3, 0});
        input.add(new Object[]{new int[]{1, 1, 2}, 1, 1});
        input.add(new Object[]{new int[]{3, 2, 2, 3}, 3, 2});
        input.add(new Object[]{new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5});

        return input.iterator();
    }

    /**
     * Tests the <code>removeElement()</code> method.
     *
     * @param inputData
     * @param target
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testRemoveElement(int[] inputData, int target, int expected) {
        LOGGER.debug("testRemoveElement({}, {})", inputData, expected);
        LC27RemoveElement instance = new LC27RemoveElement();
        int result = instance.removeElement(inputData, target);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
        assertEquals(expected, instance.removeElement2(inputData, target));
    }
}
