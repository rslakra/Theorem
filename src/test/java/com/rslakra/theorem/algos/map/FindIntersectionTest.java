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
 * @created 11/30/23 10:54 AM
 */
public class FindIntersectionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindIntersectionTest.class);

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
         *      input1[] = {3, 6, 9, 2, 9, 4}
         *      input2[] = {7, 3, 9}
         *      output[] = 6 => {3, 9}
         *
         *  Example 2:
         *      input1[] = {2, 6, 8, 3, 8, 0, 7, 4}
         *      input2[] = {3, 6, 9, 2, 9, 4}
         *      output[] = 8 => {2, 6, 3, 4}
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{3, 6, 9, 2, 9, 4}, new Integer[]{3, 6, 9, 2, 9, 4}, Arrays.asList(3, 9)});
        inputs.add(new Object[]{new Integer[]{2, 6, 8, 3, 8, 0, 7, 4}, new Integer[]{3, 6, 9, 2, 9, 4},
                                Arrays.asList(2, 6, 3, 4)});

        return inputs.iterator();
    }

    /**
     * Test <code>findIntersection</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindIntersection(Integer[] input1, Integer[] input2, List<Integer> expected) {
        LOGGER.debug("testFindIntersection({}, {}, {})", input1, input2, expected);
        FindIntersection instance = new FindIntersection();
        List<Integer> result = instance.findIntersection(input1, input2);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Test <code>findIntersectionCount</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindIntersectionCount(Integer[] input1, Integer[] input2, List<Integer> expected) {
        LOGGER.debug("testFindIntersectionCount({}, {}, {})", input1, input2, expected);
        FindIntersection instance = new FindIntersection();
        int result = instance.findIntersectionCount(input1, input2);
        LOGGER.debug("result:{}", result);
        assertEquals(expected.size(), result);
    }


}
