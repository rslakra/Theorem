package com.devamatre.theorem.adts.search;

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
 * @created 1/3/24 1:00 PM
 */
public class SearchTest {

    private static Logger LOGGER = LoggerFactory.getLogger(SearchTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> findPivotData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{1, 2, 3, 4, 5}, -1});
        input.add(new Object[]{new int[]{4, 5, 6, 7, 1, 2, 3}, 3});
        input.add(new Object[]{new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0});
        input.add(new Object[]{new int[]{9, 10, 1, 2, 3, 4, 5, 6, 7, 8}, 1});
        input.add(new Object[]{new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 2});
        input.add(new Object[]{new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 3});
        input.add(new Object[]{new int[]{6, 7, 8, 9, 10, 1, 2, 3, 4, 5}, 4});
        input.add(new Object[]{new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3, 4}, 5});

        return input.iterator();
    }

    /**
     * Tests the <code>findPivot()</code> method
     *
     * @param arr
     * @param expected
     */
    @Test(dataProvider = "findPivotData")
    public void test(int[] arr, int expected) {
        Search instance = new Search();
        int result = instance.findPivotInRotatedArray(arr);
        LOGGER.debug("number:{}, result:{}", arr, result);
        assertEquals(expected, result);
    }
}
