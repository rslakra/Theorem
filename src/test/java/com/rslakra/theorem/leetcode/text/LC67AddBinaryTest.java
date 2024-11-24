package com.rslakra.theorem.leetcode.text;

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
 * @created 2/7/24 5:26 PM
 */
public class LC67AddBinaryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC67AddBinaryTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // test 1
        input.add(new Object[]{"11", "1", "100"});
        input.add(new Object[]{"1010", "1011", "10101"});
        input.add(new Object[]{"0", "0", "0"});

        return input.iterator();
    }

    /**
     * Tests the <code>addBinary()</code> method.
     *
     * @param a
     * @param b
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testAddBinary(String a, String b, String expected) {
        LOGGER.debug("testAddBinary({}, {}, {})", a, b, expected);
        LC67AddBinary instance = new LC67AddBinary();
        String result = instance.addBinary(a, b);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
