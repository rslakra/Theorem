package com.rslakra.theorem.algos.recursion;

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
 * @created 1/11/24 10:37 AM
 */
public class NumberRecursionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberRecursion.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> reverseRecursivelyData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{0, 0});
        inputs.add(new Object[]{1, 1});
        inputs.add(new Object[]{9, 9});
        inputs.add(new Object[]{16, 61});
        inputs.add(new Object[]{61, 16});
        inputs.add(new Object[]{161, 161});
        inputs.add(new Object[]{1601, 1061});
        inputs.add(new Object[]{16001, 10061});
        inputs.add(new Object[]{16100, 161});
        inputs.add(new Object[]{1234, 4321});

        return inputs.iterator();
    }

    /**
     * Test <code>sumOfNodesAtKthLevel</code> method.
     */
    @Test(dataProvider = "reverseRecursivelyData")
    public void testReverseRecursively(int input, int expected) {
        LOGGER.debug("testReverseRecursively({}, {})", input, expected);
        NumberRecursion instance = new NumberRecursion();
        int result = instance.reverseRecursively(input);
        LOGGER.debug("expected:{}, result:{}", expected, result);
        assertEquals(expected, result);
    }


    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> countZeroRecursivelyData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{0, 1});
        inputs.add(new Object[]{1, 0});
        inputs.add(new Object[]{16, 0});
        inputs.add(new Object[]{1601, 1});
        inputs.add(new Object[]{16001, 2});
        inputs.add(new Object[]{16100, 2});

        return inputs.iterator();
    }

    /**
     * Test <code>sumOfNodesAtKthLevel</code> method.
     */
    @Test(dataProvider = "countZeroRecursivelyData")
    public void testCountZeroRecursivelyData(int input, int expected) {
        LOGGER.debug("testCountZeroRecursivelyData({}, {})", input, expected);
        NumberRecursion instance = new NumberRecursion();
        int result = instance.countZeroRecursively(input);
        LOGGER.debug("expected:{}, result:{}", expected, result);
        assertEquals(expected, result);
    }
}
