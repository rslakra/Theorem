package com.devamatre.theorem.adts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/31/2023 5:10 PM
 */
public class BitUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitUtilsTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> getBitData() {
        List<Object[]> input = new LinkedList<>();
        /**
         * <pre>
         *  Number (5) = |0|1|0|1|
         *  Positions  = |3|2|1|0|
         * </pre>
         */
        input.add(new Object[]{5, 0, 1});
        input.add(new Object[]{5, 1, 0});
        input.add(new Object[]{5, 2, 4});
        input.add(new Object[]{5, 3, 0});

        return input.iterator();
    }

    /**
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "getBitData")
    public void testGetBit(Integer number, Integer position, Integer expected) {
        LOGGER.debug("testGetBit({}, {}, {})", number, position, expected);
        Integer result = BitUtils.getBit(number, position);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> isSetBitData() {
        List<Object[]> input = new LinkedList<>();
        /**
         * <pre>
         *  Number (5) = |0|1|0|1|
         *  Positions  = |3|2|1|0|
         * </pre>
         */
        input.add(new Object[]{5, 0, true});
        input.add(new Object[]{5, 1, false});
        input.add(new Object[]{5, 2, true});
        input.add(new Object[]{5, 3, false});

        return input.iterator();
    }

    /**
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "isSetBitData")
    public void testIsSetBit(Integer number, Integer position, boolean expected) {
        LOGGER.debug("testIsSetBit({}, {}, {})", number, position, expected);
        boolean result = BitUtils.isSetBit(number, position);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> setBitData() {
        List<Object[]> input = new LinkedList<>();
        /**
         * <pre>
         *  Number (5) = |0|1|0|1|
         *  Positions  = |3|2|1|0|
         * </pre>
         */
        input.add(new Object[]{0, 0, 1});
        input.add(new Object[]{0, 1, 2});
        input.add(new Object[]{0, 2, 4});
        input.add(new Object[]{0, 3, 8});
        input.add(new Object[]{5, 1, 7});

        return input.iterator();
    }

    /**
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "setBitData")
    public void testSetBit(Integer number, Integer position, Integer expected) {
        LOGGER.debug("testSetBit({}, {}, {})", number, position, expected);
        Integer result = BitUtils.setBit(number, position);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> clearBitData() {
        List<Object[]> input = new LinkedList<>();
        /**
         * <pre>
         *  Number (5) = |0|1|0|1|
         *  Positions  = |3|2|1|0|
         * </pre>
         */
        input.add(new Object[]{5, 0, 4});
        input.add(new Object[]{5, 1, 5});
        input.add(new Object[]{5, 2, 1});
        input.add(new Object[]{5, 3, 5});

        return input.iterator();
    }

    /**
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "clearBitData")
    public void testClearBit(Integer number, Integer position, Integer expected) {
        LOGGER.debug("testClearBit({}, {}, {})", number, position, expected);
        Integer result = BitUtils.clearBit(number, position);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> updateBitData() {
        List<Object[]> input = new LinkedList<>();
        /**
         * <pre>
         *  Number (5) = |0|1|0|1|
         *  Positions  = |3|2|1|0|
         * </pre>
         */
        input.add(new Object[]{5, 0, 0, 4});
        input.add(new Object[]{5, 1, 1, 7});
        input.add(new Object[]{5, 2, 0, 1});
        input.add(new Object[]{5, 3, 1, 13});

        return input.iterator();
    }

    /**
     * Tests <code>updateBit()</code> method.
     *
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "updateBitData")
    public void testUpdateBit(Integer number, Integer position, Integer operation, Integer expected) {
        LOGGER.debug("testUpdateBit({}, {}, {}, {})", number, position, operation, expected);
        Integer result = BitUtils.updateBit(number, position, operation);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> toggleBitAtPositionData() {
        List<Object[]> input = new LinkedList<>();
        /**
         * <pre>
         *  Number (5) = |0|1|0|1|
         *  Positions  = |3|2|1|0|
         * </pre>
         */
        input.add(new Object[]{5, 0, 4});
        input.add(new Object[]{5, 1, 7});
        input.add(new Object[]{5, 2, 1});
        input.add(new Object[]{5, 3, 13});

        return input.iterator();
    }

    /**
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "toggleBitAtPositionData")
    public void testToggleBitAtPosition(Integer number, Integer position, Integer expected) {
        LOGGER.debug("testSetBit({}, {}, {})", number, position, expected);
        Integer result = BitUtils.toggleBitAtPosition(number, position);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> doOperationData() {
        List<Object[]> input = new LinkedList<>();
        input.add(new Object[]{"&", 5, 3, 1});
        input.add(new Object[]{"|", 5, 3, 7});
        input.add(new Object[]{"<<", 5, 2, 20});
        input.add(new Object[]{">>", 5, 2, 1});

        return input.iterator();
    }

    /**
     * @param number
     * @param position
     * @param expected
     */
    @Test(dataProvider = "doOperationData")
    public void testDoOperation(String operatioin, Integer number, Integer position, Integer expected) {
        LOGGER.debug("testSetBit({}, {}, {}, {})", operatioin, number, position, expected);
        Integer result = BitUtils.doOperation(operatioin, number, position);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

    @Test
    public void testBitUtils() {
        int a = 1;
        int b = 2;
        int c = 3;

        LOGGER.debug("a&b:{}", BitUtils.andOf(a, b));
        LOGGER.debug("a&c:{}", BitUtils.andOf(a, c));
        LOGGER.debug("b&c:{}", BitUtils.andOf(b, c));
        System.out.println();

        LOGGER.debug("a|b:{}", BitUtils.orOf(a, b));
        LOGGER.debug("a|c:{}", BitUtils.orOf(a, c));
        LOGGER.debug("b|c:{}", BitUtils.orOf(b, c));
        System.out.println();

        LOGGER.debug("a<<b:{}", BitUtils.leftShift(a, b));
        LOGGER.debug("a<<c:{}", BitUtils.leftShift(a, c));
        LOGGER.debug("b<<c:{}", BitUtils.leftShift(b, c));
        System.out.println();

        LOGGER.debug("a>>b:{}", BitUtils.rightShift(a, b));
        LOGGER.debug("a>>c:{}", BitUtils.rightShift(a, c));
        LOGGER.debug("b>>c:{}", BitUtils.rightShift(b, c));
        System.out.println();

        int d = 2;
        d |= a;
        LOGGER.debug("d |= a:{}", d);
        d |= b;
        LOGGER.debug("d |= b:{}", d);
        d |= c;
        LOGGER.debug("d |= c:{}", d);
        System.out.println();
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> countSetBitsData() {
        List<Object[]> input = new LinkedList<>();
        input.add(new Object[]{2, 1});
        input.add(new Object[]{3, 2});
        input.add(new Object[]{5, 2});
        input.add(new Object[]{7, 3});
        input.add(new Object[]{8, 1});
        input.add(new Object[]{11, 3});
        input.add(new Object[]{15, 4});
        input.add(new Object[]{16, 1});

        return input.iterator();
    }

    /**
     * @param number
     * @param expected
     */
    @Test(dataProvider = "countSetBitsData")
    public void testCountSetBits(Integer number, Integer expected) {
        LOGGER.debug("testCountSetBits({}, {})", number, expected);
        Integer result = BitUtils.countSetBits(number);
        LOGGER.debug("result: {}", result);
        assertEquals(expected, result);
    }

}
