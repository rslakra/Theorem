package com.devamatre.theorem.adts.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 12/11/23 4:34 PM
 */
public class InsertionSortTest extends SortTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertionSortTest.class);

    /**
     * Test <code>sort(input, Sort.Direction.ASC)</code> method.
     */
    @Test(dataProvider = "sortAscData")
    public void testSortAsc(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testSortAsc({}, {})", inputData, expected);
        Sort instance = SortFactory.sortBuilder(SortAlgo.INSERTION_SORT);
        Integer[] result = instance.sort(inputData, Sort.Direction.ASC);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertArrayEquals(result, expected);
    }

    /**
     * Test <code>sort(input, Sort.Direction.DESC)</code> method.
     */
    @Test(dataProvider = "sortDescData")
    public void testSortDesc(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testSortDesc({}, {})", inputData, expected);
        Sort instance = SortFactory.sortBuilder(SortAlgo.INSERTION_SORT);
        Integer[] result = instance.sort(inputData, Sort.Direction.DESC);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertArrayEquals(result, expected);
    }

    /**
     * Test <code>sort(input, Sort.Direction.ASC)</code> method.
     */
    @Test(dataProvider = "sortAscData")
    public void testSort(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testSort({}, {})", inputData, expected);
        Sort instance = SortFactory.sortBuilder(SortAlgo.INSERTION_SORT);
        Integer[] result = instance.sort(inputData);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertArrayEquals(result, expected);
    }

}
