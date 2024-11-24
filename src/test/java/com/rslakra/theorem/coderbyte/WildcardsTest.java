package com.rslakra.theorem.coderbyte;

import static org.testng.AssertJUnit.assertEquals;

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
 * @since 03/11/2021 5:27 PM
 */
public class WildcardsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WildcardsTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // build input
        inputs.add(new Object[]{"$+ 1r", true});
        inputs.add(new Object[]{"++*{5} gheeeee", true});
        inputs.add(new Object[]{"+++++* abcdemmmmmm", false});
        inputs.add(new Object[]{"**+*{2} mmmrrrkbb", true});
        inputs.add(new Object[]{"+++++* abcdehhhhhh", false});
        inputs.add(new Object[]{"$**+*{2} 9mmmrrrkbb", true});

        return inputs.iterator();
    }

    /**
     * Test <code>Wildcards()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testWildcards(String input, boolean expected) {
        LOGGER.debug("testWildcards({}, {})", input, expected);
        boolean result = Wildcards.matchWildcards(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
