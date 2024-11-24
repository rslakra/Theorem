package com.rslakra.theorem.adts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
 * @created 12/23/19 4:10 PM
 */
public class NumberUtilsTest {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtilsTest.class);

    @Test
    public void testAverage() {
        NumberUtils numberUtils = NumberUtils.INSTANCE;
        LOGGER.debug("numberUtils:{}", numberUtils);
        assertNotNull(numberUtils);
        assertEquals(3, numberUtils.average(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testRandomNumbersAverage() {
        NumberUtils numberUtils = NumberUtils.INSTANCE;
        LOGGER.debug("numberUtils:{}", numberUtils);
        assertNotNull(numberUtils);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> decimalToBinaryData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{1, new int[]{1}});
        input.add(new Object[]{2, new int[]{1, 0}});
        input.add(new Object[]{5, new int[]{1, 0, 1}});
        input.add(new Object[]{10, new int[]{1, 0, 1, 0}});
        input.add(new Object[]{16, new int[]{1, 0, 0, 0, 0}});
        input.add(new Object[]{21, new int[]{1, 0, 1, 0, 1}});
        input.add(new Object[]{43, new int[]{1, 0, 1, 0, 1, 1}});
        input.add(new Object[]{86, new int[]{1, 0, 1, 0, 1, 1, 0}});
        input.add(new Object[]{173, new int[]{1, 0, 1, 0, 1, 1, 0, 1}});

        return input.iterator();
    }

    /**
     * Tests the <code>decimalToBinary()</code> method.
     *
     * @param number
     * @param expected
     */
    @Test(dataProvider = "decimalToBinaryData")
    public void testDecimalToBinary(int number, int[] expected) {
        int[] binary = NumberUtils.decimalToBinary(number);
        LOGGER.debug("number:{}, binary:{}", number, Arrays.toString(binary));
        assertArrayEquals(expected, binary);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> binaryToDecimalData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{1}, 1});
        input.add(new Object[]{new int[]{1, 0}, 2});
        input.add(new Object[]{new int[]{1, 0, 1}, 5});
        input.add(new Object[]{new int[]{1, 0, 1, 0}, 10});
        input.add(new Object[]{new int[]{1, 0, 0, 0, 0}, 16});
        input.add(new Object[]{new int[]{1, 0, 1, 0, 1}, 21});
        input.add(new Object[]{new int[]{1, 0, 1, 0, 1, 1}, 43});
        input.add(new Object[]{new int[]{1, 0, 1, 0, 1, 1, 0}, 86});
        input.add(new Object[]{new int[]{1, 0, 1, 0, 1, 1, 0, 1}, 173});

        return input.iterator();
    }

    /**
     * Tests the <code>binaryToDecimal()</code> method.
     *
     * @param binary
     * @param expected
     */
    @Test(dataProvider = "binaryToDecimalData")
    public void testBinaryToDecimal(int[] binary, int expected) {
        int result = NumberUtils.binaryToDecimal(binary);
        LOGGER.debug("binary:{}, result:{}", Arrays.toString(binary), result);
        assertEquals(expected, result);
    }


}
