package com.rslakra.theorem.algos.map;

import com.rslakra.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 11/30/23 11:05 AM
 */
public class FindItinerary {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindItinerary.class);

    /**
     * Find Itinerary from Tickets?
     * <p>
     * Given an itinerary of from => to locations, find an itinerary from the tickets?
     *
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
     * <p>
     * Mumbai => Delhi => Goa => Chennai => Bangalore
     */
    public String findItinerary(Map<String, String> tickets) {
        String itinerary = null;
        LOGGER.debug("+findItinerary({})", tickets);
        if (BeanUtils.isNotEmpty(tickets)) {
            // find the starting point
            String from = tickets.keySet().stream().filter(key -> !tickets.containsValue(key)).findFirst().orElse(null);
            LOGGER.debug("from:{}", from);
            itinerary = from;
            while (tickets.containsKey(from)) {
                from = tickets.get(from);
                LOGGER.debug("from:{}", from);
                // the last destination, not available so
                if (from != null) {
                    itinerary += " => " + from;
                }
            }
        }

        LOGGER.debug("-findItinerary(), findItinerary:{}", itinerary);
        return itinerary;
    }
}
