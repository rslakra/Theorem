package com.devamatre.theorem.adts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 12/23/19 4:10 PM
 */
public class NumberUtilsTest {

    // LOGGER
    private static Logger LOGGER = LoggerFactory.getLogger(NumberUtilsTest.class);

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
}
