package com.devamatre.theorem.adts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
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

}
