package com.devamatre.theorem.adts.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 3:21 PM
 */
public class MapUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapUtilsTest.class);

    /**
     * Builds an input map for the values.
     *
     * @param values
     * @return
     */
    public static Map<String, Integer> buildInputMap(int[] values) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(String.valueOf((char) ('a' + i)), values[i]);
        }

        return map;
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> sortByKeyData() {
        List<Object[]> input = new ArrayList<>();
        // inputData
        input.add(new Object[]{buildInputMap(new int[]{3, 5, 2}), buildInputMap(new int[]{3, 5, 2})});
        input.add(new Object[]{buildInputMap(new int[]{10, 10, 10}), buildInputMap(new int[]{10, 10, 10})});
        input.add(new Object[]{buildInputMap(new int[]{10, 10, 5}), buildInputMap(new int[]{10, 10, 5})});
        input.add(new Object[]{buildInputMap(new int[]{10, 16, 14, 5}), buildInputMap(new int[]{10, 16, 14, 5})});
        input.add(new Object[]{buildInputMap(new int[]{12, 14, 15, 3}), buildInputMap(new int[]{12, 14, 15, 3})});

        return input.iterator();
    }

    /**
     * Tests the <code>sortByKey</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "sortByKeyData")
    public void testSortByKey(Map<String, Integer> inputData, Map<String, Integer> expected) {
        LOGGER.debug("testSortByKey({}, {})", inputData, expected);
        Map<String, Integer> result = MapUtils.sortByKey(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }


    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> sortByValueData() {
        List<Object[]> input = new ArrayList<>();
        // inputData
        input.add(new Object[]{buildInputMap(new int[]{3, 5, 2}), buildInputMap(new int[]{3, 5, 2})});
        input.add(new Object[]{buildInputMap(new int[]{10, 10, 10}), buildInputMap(new int[]{10, 10, 10})});
        input.add(new Object[]{buildInputMap(new int[]{10, 10, 5}), buildInputMap(new int[]{10, 10, 5})});
        input.add(new Object[]{buildInputMap(new int[]{10, 16, 14, 5}), buildInputMap(new int[]{10, 16, 14, 5})});
        input.add(new Object[]{buildInputMap(new int[]{12, 14, 15, 3}), buildInputMap(new int[]{12, 14, 15, 3})});

        return input.iterator();
    }

    /**
     * Tests the <code>sortByValue</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "sortByValueData")
    public void testSortByValue(Map<String, Integer> inputData, Map<String, Integer> expected) {
        LOGGER.debug("testSortByValue({}, {})", inputData, expected);
        Map<String, Integer> result = MapUtils.sortByValue(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Tests the <code>getCharIndexes</code> method.
     */
    @Test
    public void testGetCharIndexes() {
        LOGGER.debug("+testGetCharIndexes()");
        Map<Integer, Character> charIndexes = MapUtils.getCharIndexes();
        LOGGER.debug("charIndexes:{}", charIndexes);
        LOGGER.debug("-testGetCharIndexes()");
    }
}
