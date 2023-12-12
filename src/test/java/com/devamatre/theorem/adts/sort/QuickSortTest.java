package com.devamatre.theorem.adts.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @created 12/11/23 4:34 PM
 */
public class QuickSortTest extends SortTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSortTest.class);

    /**
     * Test <code>sort(input, Sort.Direction.ASC)</code> method.
     */
    @Test(dataProvider = "sortAscData")
    public void testQuickSortAsc(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testQuickSortAsc({}, {})", inputData, expected);
        Sort instance = new QuickSort();
        Integer[] result = instance.sort(inputData, Sort.Direction.ASC);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertArrayEquals(result, expected);
    }

    /**
     * Test <code>sort(input, Sort.Direction.DESC)</code> method.
     */
    @Test(dataProvider = "sortDescData")
    public void testQuickSortDesc(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testQuickSortDesc({}, {})", inputData, expected);
        Sort instance = new QuickSort();
        Integer[] result = instance.sort(inputData, Sort.Direction.DESC);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertArrayEquals(result, expected);
    }

    /**
     * Test <code>sort(input, Sort.Direction.ASC)</code> method.
     */
    @Test(dataProvider = "sortAscData")
    public void testQuickSort(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testQuickSort({}, {})", inputData, expected);
        Sort instance = new QuickSort();
        Integer[] result = instance.sort(inputData);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertArrayEquals(result, expected);
    }

}
