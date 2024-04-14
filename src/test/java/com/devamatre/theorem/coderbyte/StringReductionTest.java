package com.devamatre.theorem.coderbyte;

import static org.testng.AssertJUnit.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * https://justprogrammng.blogspot.com/2012/06/interviewstreet-challenge-string.html
 * https://stackoverflow.com/questions/8033553/length-of-smallest-string-with-three-letter-alphabet-achievable-by-replacing-two
 * https://github.com/eraydmrcoglu/coderbyte-java-solutions/blob/main/Medium/StringReduction.java
 * </pre>
 *
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
        inputs.add(new Object[]{"cccca", 1});
        inputs.add(new Object[]{"abcac", 1});
        inputs.add(new Object[]{"abcab", 1});
        inputs.add(new Object[]{"abcaa", 2});

        return inputs.iterator();
    }

    /**
     * Test <code>StringReduction()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testStringReduction(String input, int expected) {
        LOGGER.debug("testStringReduction({}, {})", input, expected);
        // Time Complexity: O(n * k) - k is the reduced string of x chars
        int result = StringReduction.solve1(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);

        // Time Complexity: O(n * k) - k is the reduced string of x chars
        assertEquals(expected, StringReduction.solve2(input));

        // Time Complexity: O(n)
        assertEquals(expected, StringReduction.solve3(input));
    }
}
