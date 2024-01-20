package com.devamatre.theorem.algos.lang;

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
 * @version 1.0.0
 * @since 01/02/2024 8:14 AM
 */
public class SumTest {

    private static Logger LOGGER = LoggerFactory.getLogger(SumTest.class);

    /**
     * Tests the <code>sumOfNOddNumbers()</code> method
     */
    @Test
    public void testSumOfNOddNumbers() {
        int number = 5;
        int result = Sum.sumOfNOddNumbers(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(25, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> sumOfOddNumbersData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{0, 0});
        input.add(new Object[]{1, 1});
        input.add(new Object[]{2, 1});
        input.add(new Object[]{3, 4});
        input.add(new Object[]{4, 4});
        input.add(new Object[]{5, 9});
        input.add(new Object[]{10, 25});
        input.add(new Object[]{75, 1444});

        return input.iterator();
    }

    /**
     * Tests the <code>sumOfOddNumbers()</code> method
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "sumOfOddNumbersData")
    public void testSumOfOddNumbers(int number, int expected) {
        int result = Sum.sumOfOddNumbers(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
        assertEquals(expected, Sum.sumOfOddNumbersFormula(number));
    }

    /**
     * Tests the <code>sumOfSquareOfNOddNumber()</code> method
     */
    @Test
    public void testSumOfSquareOfNOddNumber() {
        int number = 3;
        int result = Sum.sumOfSquareOfNOddNumber(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(35, result);
    }

    /**
     * Tests the <code>sumOfCubesOfNOddNumber()</code> method
     */
    @Test
    public void testSumOfCubesOfNOddNumber() {
        int number = 3;
        int result = Sum.sumOfCubesOfNOddNumber(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(153, result);
    }

}
