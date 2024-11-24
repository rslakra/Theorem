package com.rslakra.theorem.algos.array;

import static org.testng.AssertJUnit.assertEquals;

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
 * @created 2/12/24 11:55 AM
 */
public class FindParentsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindParentsTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{0, 1, 0, 2, 1, 5}, Arrays.asList(0, 1, 5)});
        return inputs.iterator();
    }

    /**
     * Test <code>getHitProbability()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindParents(int[] input, List<Integer> expected) {
        LOGGER.debug("testFindParents({}, {})", input, expected);
        FindParents instance = new FindParents();
        List<Integer> result = instance.findParents(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
