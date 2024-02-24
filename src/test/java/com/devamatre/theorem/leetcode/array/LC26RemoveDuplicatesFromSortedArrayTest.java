package com.devamatre.theorem.leetcode.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.linkedlist.LC21MergeTwoSortedListsTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/24/24 5:01 PM
 */
public class LC26RemoveDuplicatesFromSortedArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC21MergeTwoSortedListsTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{1, 1, 2}, 2});
        input.add(new Object[]{new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5});

        return input.iterator();
    }

    /**
     * Tests the <code>removeDuplicates()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testRemoveDuplicates(int[] inputData, int expected) {
        LOGGER.debug("testRemoveDuplicates({}, {})", inputData, expected);
        LC26RemoveDuplicatesFromSortedArray instance = new LC26RemoveDuplicatesFromSortedArray();
        int result = instance.removeDuplicates(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

}
