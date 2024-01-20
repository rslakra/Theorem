package com.devamatre.theorem.adts.lang;

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
 * @since 09/09/2023 06:34 PM
 */
public class MathsTest {

    // LOGGER
    private static Logger LOGGER = LoggerFactory.getLogger(MathsTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> countDigitsData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{1, 1});
        input.add(new Object[]{06, 1});
        input.add(new Object[]{16, 2});
        input.add(new Object[]{161, 3});
        input.add(new Object[]{1601, 4});

        return input.iterator();
    }

    /**
     * Tests the <code>countDigits()</code> method
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "countDigitsData")
    public void testCountDigits(long number, int expected) {
        int result = Maths.countDigits(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> isPowerOf2Data() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{1, true});
        input.add(new Object[]{2, true});
        input.add(new Object[]{3, false});
        input.add(new Object[]{4, true});
        input.add(new Object[]{8, true});
        input.add(new Object[]{16, true});
        input.add(new Object[]{17, false});

        return input.iterator();
    }

    /**
     * Tests the <code>isPowerOf2()</code> method
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "isPowerOf2Data")
    public void testIsPowerOf2(int number, boolean expected) {
        boolean result = Maths.isPowerOf2(number);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
        assertEquals(Maths.isPowerOf2Optimized(number), result);
    }

    /**
     * TODO: Handle Negative power
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> powerData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{2, 0, 1});
        input.add(new Object[]{2, 1, 2});
        input.add(new Object[]{2, 2, 4});
        input.add(new Object[]{2, 3, 8});
        input.add(new Object[]{2, 4, 16});
        input.add(new Object[]{3, 2, 9});
        input.add(new Object[]{16, 2, 256});
        input.add(new Object[]{128, 2, 16384});
//        input.add(new Object[]{2, -3, 0.125});
//        input.add(new Object[]{5, -16, 6.5536E-12});

        return input.iterator();
    }

    /**
     * Tests the <code>isPowerOf2()</code> method
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "powerData")
    public void testPower(long number, int exponent, double expected) {
//        LOGGER.debug("number:{}, exponent:{}, result:{}", Maths.toStringPower(number, exponent));
        LOGGER.debug("number:{}, exponent:{}, result:{}", number, exponent, Math.pow(number, exponent));
        double result = Maths.power(number, exponent);
        LOGGER.debug("number:{}, result:{}", number, result);
        assertEquals(expected, result);
        assertEquals(expected, Maths.powerRecursively(number, exponent));
//        assertEquals(expected, Maths.powerLog2Recursively(number, exponent));
        assertEquals(expected, Maths.powOptimized(number, exponent));
    }

    @Test
    public void testPower() {
        double power = Maths.power(2, 3);
        assertEquals(8, power);
    }


    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> gcdData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{8, 12, 4});
        input.add(new Object[]{6, 12, 6});
        input.add(new Object[]{12, 16, 4});
        input.add(new Object[]{15, 18, 3});
        input.add(new Object[]{15, 35, 5});

        return input.iterator();
    }

    @Test(dataProvider = "gcdData")
    public void testGCD(int nominator, int denominator, int expected) {
        assertEquals(expected, Maths.gcd(nominator, denominator));
        assertEquals(expected, Maths.gcdEuclidean(nominator, denominator));
        assertEquals(expected, Maths.gcdEuclideanRecursively(nominator, denominator));
        assertEquals(expected, Maths.gcdRecursively(nominator, denominator));
    }

}
