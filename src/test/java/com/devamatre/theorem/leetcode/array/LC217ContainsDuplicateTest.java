package com.devamatre.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 6:39 PM
 */
public class LC217ContainsDuplicateTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LC217ContainsDuplicateTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{1, 2, 3, 1}, true});
        input.add(new Object[]{new int[]{1, 2, 3, 4}, false});
        input.add(new Object[]{new int[]{1, 2, 2, 1, 1, 3}, true});
        input.add(new Object[]{new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 23}, true});
        input.add(new Object[]{new int[]{1, 2}, false});
        input.add(new Object[]{new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true});
        input.add(new Object[]{
            new int[]{-264, 136, 159, -178, 159, 116, -78, -58, -93, 136, 159, -118, 86, 136, 159, -264, -264, -20, -78,
                      -20, -118, 136, 116, 60, -78, -20, 235, -55, -20, -78, -130, -58, -58, 136, 86, 159, -93, -93,
                      136, -252, -187, -20, 98, -252, 136, -118, -59, -264, -59, -20, -118, -55, -187, -20, 136, 60,
                      -252, -252, -93, 159, -178, 98, -93, -264, -130, -93, -55, -59, -178, 60, -52, -130, -59, -58, 60,
                      235, -162, -59, 116, -20, -58, 159, 86, -78, 116, -59, -264, 235, 116, -93, -187, 235, 136, -178,
                      300, -59, 136, -264, 159, -178, -178, -93, -52, -20, 235, -59, 86, -78, -252, -264, -130, -59,
                      -264, 98, 116, -93, 159, -59, -118, 136, -55, -59, -55, 136, -130, 86, 136, 116, -130, -264, 159,
                      -20, 159, -78, 136, 60, 235, -264, 60, 60, -178, 116, -162, 136, -162, 60, -187, 235, -20, -59,
                      -55, -93, -55, -78, -130, -187, -130, 235, -118, 86, -178, -93, 235, -264, -187, 159, 159, 159,
                      -264, -264, 136, -118, -78, -78, -264, -264, 86, -20, -264, 136, -20, -118, -118, 60, 60, 60, 60,
                      -78, -55, 159, -20, -187, -59, -58, -59, 136, -130, 235, -264, -20, 60, -20, -78, 86, -55, 116,
                      -130, -78, -93, -59, 98, -59, -59, -55, -59, -178, -264, 235, -264, -59, -93, -178, -178, -55,
                      -55, 60, -55, -118, -187, 159, -187, -59, -93, 60, 235, 116, -187, -162, 159, -178, -58, -55, 136,
                      -178, -264, -20, 136, -178, 98, -55, -78, 136, -59, -264, -78, -130, 116, -178, -55, 60, 159,
                      -178, 159, -178, -20, -264, -55, 159, 86, -20, -130, 136, -118, -252, -178, 235}, true});

        return input.iterator();
    }

    /**
     * Tests the <code>containsDuplicate()</code> method
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testContainsDuplicate(int[] inputData, boolean expected) {
        LOGGER.debug("testUniqueOccurrences({}, {})", Arrays.toString(inputData), expected);
        LC217ContainsDuplicate instance = new LC217ContainsDuplicate();
        boolean result = instance.containsDuplicate(inputData);
        LOGGER.debug("expected:{}, result:{}", expected, result);
        assertEquals(expected, result);
        assertEquals(expected, instance.containsDuplicate3(inputData));
        assertEquals(expected, instance.containsDuplicate2(inputData));
    }
}
