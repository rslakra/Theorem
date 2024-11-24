package com.rslakra.theorem.adts.sort;

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
 * @created 10/18/23 10:07 AM
 */
public class CountingSortTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountingSortTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> sortData() {
        List<Object[]> inputs = new ArrayList<>();
        // ASC Direction
        inputs.add(new Object[]{new int[]{2, 6, 4}, 6, Sort.Direction.ASC, new int[]{2, 4, 6}});
        inputs.add(new Object[]{new int[]{3, 2, 4, 5, 1}, 5, Sort.Direction.ASC, new int[]{1, 2, 3, 4, 5}});
        inputs.add(new Object[]{new int[]{2, 7, 11, 15}, 15, Sort.Direction.ASC, new int[]{2, 7, 11, 15}});
        inputs.add(new Object[]{new int[]{8, 5, 9, 7, 6}, 9, Sort.Direction.ASC, new int[]{5, 6, 7, 8, 9}});
        inputs.add(new Object[]{
            new int[]{2, 34, 54, 6, 89, 11}, 89, Sort.Direction.ASC, new int[]{2, 6, 11, 34, 54, 89}
        });
        // ASC Direction with duplicates
        inputs.add(
            new Object[]{new int[]{3, 2, 4, 5, 3, 1, 5, 1}, 5, Sort.Direction.ASC, new int[]{1, 1, 2, 3, 3, 4, 5, 5}});
        inputs.add(
            new Object[]{new int[]{2, 7, 2, 15, 2, 11, 15}, 15, Sort.Direction.ASC, new int[]{2, 2, 2, 7, 11, 15, 15}});

        // DESC Direction
        inputs.add(new Object[]{new int[]{2, 6, 4}, 6, Sort.Direction.DESC, new int[]{6, 4, 2}});
        inputs.add(new Object[]{new int[]{3, 2, 4, 5, 1}, 5, Sort.Direction.DESC, new int[]{5, 4, 3, 2, 1}});
        inputs.add(new Object[]{new int[]{2, 7, 11, 15}, 15, Sort.Direction.DESC, new int[]{15, 11, 7, 2}});
        inputs.add(new Object[]{new int[]{8, 5, 9, 7, 6}, 9, Sort.Direction.DESC, new int[]{9, 8, 7, 6, 5}});
        inputs.add(new Object[]{
            new int[]{2, 34, 54, 6, 89, 11}, 89, Sort.Direction.DESC, new int[]{89, 54, 34, 11, 6, 2}
        });

        // DESC Direction with duplicates
        inputs.add(
            new Object[]{new int[]{3, 2, 4, 5, 3, 1, 5, 1}, 5, Sort.Direction.DESC, new int[]{5, 5, 4, 3, 3, 2, 1, 1}});
        inputs.add(
            new Object[]{new int[]{2, 7, 2, 15, 2, 11, 15}, 15, Sort.Direction.DESC,
                         new int[]{15, 15, 11, 7, 2, 2, 2}});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param k
     * @param expectedResults
     */
    @Test(dataProvider = "sortData")
    public void testCountingSort(int[] input, int k, Sort.Direction direction, int[] expectedResults) {
        CountingSort instance = new CountingSort();
        int[] results = instance.sort(input, k, direction);
        LOGGER.debug("input:{}, results:{}", input, results);
        assertEquals(expectedResults, results);
        int[] sortWithMap = instance.sortWithMap(input, k, direction);
        LOGGER.debug("input:{}, sortWithMap:{}", input, sortWithMap);
        assertEquals(expectedResults, sortWithMap);
        assertEquals(results, sortWithMap);
    }

}
