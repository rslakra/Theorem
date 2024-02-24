package com.devamatre.theorem.quiz.gusto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.adts.map.MapUtilsTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 1/30/24 7:03 PM
 */
public class DistributeMoneyEvenlyAsPossibleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributeMoneyEvenlyAsPossible.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // inputData
        input.add(new Object[]{10, MapUtilsTest.buildInputMap(new int[]{3, 5, 2}),
                               MapUtilsTest.buildInputMap(new int[]{3, 5, 2})});
        input.add(new Object[]{40, MapUtilsTest.buildInputMap(new int[]{10, 10, 10, 10}),
                               MapUtilsTest.buildInputMap(new int[]{10, 10, 10, 10})});
        input.add(new Object[]{40, MapUtilsTest.buildInputMap(new int[]{10, 10, 10, 5}),
                               MapUtilsTest.buildInputMap(new int[]{10, 10, 10, 5})});
        input.add(new Object[]{40, MapUtilsTest.buildInputMap(new int[]{10, 16, 14, 5}),
                               MapUtilsTest.buildInputMap(new int[]{10, 13, 12, 5})});
        input.add(new Object[]{40, MapUtilsTest.buildInputMap(new int[]{12, 14, 15, 3}),
                               MapUtilsTest.buildInputMap(new int[]{12, 13, 12, 3})});

        return input.iterator();
    }

    /**
     * Tests the <code>distributeMoneyEvenly()</code> method.
     *
     * @param amount
     * @param limits
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testLongestValidParentheses(int amount, Map<String, Integer> limits, Map<String, Integer> expected) {
        LOGGER.debug("testLongestValidParentheses({}, {}, {})", amount, limits, expected);
        DistributeMoneyEvenlyAsPossible instance = new DistributeMoneyEvenlyAsPossible();
        Map<String, Integer> result = instance.distributeMoneyEvenly(amount, limits);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
