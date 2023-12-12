package com.devamatre.theorem.algos.map;

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
public class FindUnionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindUnionTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findUnionData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      input1[] = {3, 6, 9, 2, 9, 4}
         *      input2[] = {7, 3, 9}
         *      output[] = 6 => {2, 3, 4, 6, 7, 9}
         *
         *  Example 2:
         *      input1[] = {2, 6, 8, 3, 8, 0, 7, 4}
         *      input2[] = {3, 6, 9, 2, 9, 4}
         *      output[] = 8 => {0, 2, 3, 4, 6, 7, 8, 9}
         * </pre>
         */
        inputs.add(
            new Object[]{new Integer[]{3, 6, 9, 2, 9, 4}, new Integer[]{7, 3, 9}, Arrays.asList(2, 3, 4, 6, 7, 9)});
        inputs.add(new Object[]{new Integer[]{2, 6, 8, 3, 8, 0, 7, 4}, new Integer[]{3, 6, 9, 2, 9, 4},
                                Arrays.asList(0, 2, 3, 4, 6, 7, 8, 9)});

        return inputs.iterator();
    }

    /**
     * Test <code>findUnion</code> method.
     */
    @Test(dataProvider = "findUnionData")
    public void testFindUnion(Integer[] input1, Integer[] input2, List<Integer> expected) {
        LOGGER.debug("testFindUnion({}, {}, {})", input1, input2, expected);
        FindUnion instance = new FindUnion();
        List<Integer> result = instance.findUnion(input1, input2);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Test <code>findUnionCount</code> method.
     */
    @Test(dataProvider = "findUnionData")
    public void testFindUnionCount(Integer[] input1, Integer[] input2, List<Integer> expected) {
        LOGGER.debug("testFindUnionCount({}, {}, {})", input1, input2, expected);
        FindUnion instance = new FindUnion();
        int result = instance.findUnionCount(input1, input2);
        LOGGER.debug("result:{}", result);
        assertEquals(expected.size(), result);
    }


}
