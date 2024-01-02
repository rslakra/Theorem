package com.devamatre.theorem.adts.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        input.add(new Object[]{2, -3, 0.125});
        input.add(new Object[]{5, -16, 6.5536E-12});

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
        assertEquals(Maths.powOptimized(number, exponent), result);
    }

    @Test
    public void testPower() {
        double power = Maths.power(2, 3);
        assertEquals(8, power);
    }

    @Test
    public void testGCD() {
        assertEquals(4, Maths.gcd(8, 12));
        assertEquals(4, Maths.gcdEuclidean(8, 12));
        assertEquals(4, Maths.gcdEuclideanRecursively(8, 12));
    }

}