package com.devamatre.theorem.algos.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.adts.lang.Maths;
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
 * @since 01/01/2024 4:34 PM
 */
public class CommonFactorsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonFactorsTest.class);

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
     * Tests the <code>isPowerOf2()</code> method.
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
}
