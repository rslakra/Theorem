package com.devamatre.theorem.algos.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 11/30/23 10:54 AM
 */
public class FindItineraryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindItineraryTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      input = {
         *          "Chennai" => "Bangalore"
         *          "Mumbai"  => "Delhi"
         *          "Goa"     => "Chennai"
         *          "Delhi"   => "Goa"
         *      }
         *      output = {Mumbai => Delhi => Goa => Chennai => Bangalore}
         *
         *
         *  Criteria -
         *      1. No loop, you can't come back to the starting point.
         *      2. You can't go to more than 1 place from the starting point.
         * </pre>
         */
        Map<String, String> inputData = new HashMap<>();
        inputData.put("Chennai", "Bangalore");
        inputData.put("Mumbai", "Delhi");
        inputData.put("Goa", "Chennai");
        inputData.put("Delhi", "Goa");
        inputs.add(new Object[]{inputData, "Mumbai => Delhi => Goa => Chennai => Bangalore"});

        return inputs.iterator();
    }

    /**
     * Test <code>findItinerary</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testFindItinerary(Map<String, String> inputData, String expected) {
        LOGGER.debug("testFindItinerary({}, {}, {})", inputData, expected);
        FindItinerary instance = new FindItinerary();
        String result = instance.findItinerary(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

}
