package com.devamatre.theorem.coderbyte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.AssertJUnit.*;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 */
public class StringReductionTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringReductionTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // build input
        inputs.add(new Object[]{"abcabc", 2});
        inputs.add(new Object[]{"cccc", 4});

        return inputs.iterator();
    }

    /**
     * Test <code>StringReduction()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testStringReduction(String input, int expected) {
        LOGGER.debug("testStringReduction({}, {})", input, expected);
        int result = StringReduction.solve2(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
