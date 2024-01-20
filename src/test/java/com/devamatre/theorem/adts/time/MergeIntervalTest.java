package com.devamatre.theorem.adts.time;

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
 * @created 1/2/24 3:42 PM
 */
public class MergeIntervalTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeIntervalTest.class);

    /**
     * Input Data
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> mergeIntervalsData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(new Interval<>(2, 5), new Interval<>(3, 6)), new Interval<>(2, 6)});
        inputs.add(new Object[]{Arrays.asList(new Interval<>(1, 4), new Interval<>(3, 5)), new Interval<>(1, 5)});
        inputs.add(new Object[]{
            Arrays.asList(new Interval<>(6, 8), new Interval<>(3, 5), new Interval<>(4, 5), new Interval<>(3, 4)),
            new Interval<>(3, 5)});

        return inputs.iterator();
    }

    /**
     * Tests the <code>mergeIntervals()</code> method.
     */
    @Test(dataProvider = "mergeIntervalsData")
    public void testMergeIntervals(List<Interval<Integer>> input, Interval<Integer> expected) {
        LOGGER.debug("testMergeIntervals({}, {})", input, expected);
        List<Interval<Integer>> result = MergeInterval.mergeIntervals(input);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertEquals(expected, result.get(0));
    }


}
