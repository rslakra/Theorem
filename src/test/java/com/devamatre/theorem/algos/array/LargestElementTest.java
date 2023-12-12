package com.devamatre.theorem.algos.array;

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
 * @created 12/6/23 8:21 PM
 */
public class LargestElementTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LargestElementTest.class);


    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findKthLargestElementData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{2, 5, 4, 1, 9, 6, 8, 3}, 1, 9});
        inputs.add(new Object[]{new int[]{2, 5, 4, 1, 9, 6, 8, 3}, 2, 8});
        inputs.add(new Object[]{new int[]{2, 5, 4, 1, 9, 6, 8, 3}, 3, 6});
        inputs.add(new Object[]{new int[]{2, 5, 4, 1, 9, 6, 8, 3}, 4, 5});
        inputs.add(new Object[]{new int[]{2, 5, 4, 1, 9, 6, 8, 3}, 5, 4});

        return inputs.iterator();
    }

    /**
     * Tests the <code>printPrettyTreeHorizontally</code> method.
     */
    @Test(dataProvider = "findKthLargestElementData")
    public void testFindKthLargestElementBySorting(int[] input, int k, int expected) {
        LOGGER.debug("testFindKthLargestElementBySorting({}, {}, {})", input, k, expected);
        LargestElement instance = new LargestElement();
        int result = instance.findKthLargestElementBySorting(input, k);
        LOGGER.debug("result:{}, input:{}", result, input);
        assertEquals(expected, result);
    }

    /**
     * Tests the <code>printPrettyTreeHorizontally</code> method.
     */
    @Test(dataProvider = "findKthLargestElementData")
    public void testFindKthLargestElementBySortingKElements(int[] input, int k, int expected) {
        LOGGER.debug("testFindKthLargestElementBySortingKElements({}, {}, {})", input, k, expected);
        LargestElement instance = new LargestElement();
        int result = instance.findKthLargestElementBySortingKElements(input, k);
        LOGGER.debug("result:{}, input:{}", result, input);
        assertEquals(expected, result);
    }

    /**
     * Tests the <code>findKthLargestElementByPriorityQueue</code> method.
     */
    @Test(dataProvider = "findKthLargestElementData")
    public void testFindKthLargestElementByPriorityQueue(int[] input, int k, int expected) {
        LOGGER.debug("testFindKthLargestElementByPriorityQueue({}, {}, {})", input, k, expected);
        LargestElement instance = new LargestElement();
        int result = instance.findKthLargestElementByPriorityQueue(input, k);
        LOGGER.debug("result:{}, input:{}", result, input);
        assertEquals(expected, result);
    }

}
