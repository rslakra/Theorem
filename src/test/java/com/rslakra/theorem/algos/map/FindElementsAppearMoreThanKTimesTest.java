package com.rslakra.theorem.algos.map;

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
 * @created 11/30/23 10:44 AM
 */
public class FindElementsAppearMoreThanKTimesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindElementsAppearMoreThanKTimesTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      input[] = {1, 3, 2, 5, 1, 3, 1, 5, 1}
         *      k = n/3
         *      output = 1
         *
         *  Example 2:
         *      input[] = {1, 2}
         *      k = n/3
         *      output = {1, 2}
         * </pre>
         */
        // through root (with root)
        inputs.add(new Object[]{new Integer[]{1, 3, 2, 5, 1, 3, 1, 5, 1}, Arrays.asList(1)});
        inputs.add(new Object[]{new Integer[]{1, 2}, Arrays.asList(1, 2)});

        return inputs.iterator();
    }

    /**
     * Test <code>findElements</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindElements(Integer[] inputData, List<Integer> expected) {
        LOGGER.debug("testFindElements({}, {})", inputData, expected);
        FindElementsAppearMoreThanKTimes instance = new FindElementsAppearMoreThanKTimes();
        List<Integer> result = instance.findElements(inputData, inputData.length / 3);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Test <code>findElementsAppearMoreThanNbyKTimes</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindElementsAppearMoreThanNbyKTimes(Integer[] inputData, List<Integer> expected) {
        LOGGER.debug("testFindElementsAppearMoreThanNbyKTimes({}, {})", inputData, expected);
        FindElementsAppearMoreThanKTimes instance = new FindElementsAppearMoreThanKTimes();
        int result = instance.findElementsAppearMoreThanNbyKTimes(inputData, inputData.length / 3);
        LOGGER.debug("result:{}", result);
        assertEquals(expected.size(), result);
    }

}
