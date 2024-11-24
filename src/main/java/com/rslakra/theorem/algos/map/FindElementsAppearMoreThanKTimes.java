package com.rslakra.theorem.algos.map;

import com.rslakra.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 11/30/23 10:40 AM
 */
public class FindElementsAppearMoreThanKTimes {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindElementsAppearMoreThanKTimes.class);

    /**
     * Given an integer array of size n, find all elements that appear more than n/3 times?
     *
     * <pre>
     *  Example 1:
     *      input[] = {1, 3, 2, 5, 1, 3, 1, 5, 1}
     *      k = n/3
     *      output = 1
     *
     *  Example 2:
     *      input[] = {1, 2}
     *      k = n/3
     *      output = {1, 2}
     * </pre>
     *
     * @param input
     * @param k
     */
    public List<Integer> findElements(Integer[] input, int k) {
        LOGGER.debug("+findElements({}, {})", input, k);
        List<Integer> findElements = new ArrayList<>();
        if (BeanUtils.isNotEmpty(input)) {
            // find elements frequency
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < input.length; i++) {
                if (map.containsKey(input[i])) {
                    map.put(input[i], map.get(input[i]) + 1);
                } else {
                    map.put(input[i], 1);
                }
            }

            LOGGER.debug("+findElements({}, {})", input, k);
            // find those elements which frequency > k
            for (int key : map.keySet()) {
                if (map.get(key) > k) {
                    findElements.add(key);
                }
            }
        }

        LOGGER.debug("-findElements(), findElements:{}", findElements);
        return findElements;
    }

    /**
     * Given an integer array of size n, find all elements that appear more than n/3 times?
     *
     * <pre>
     *  Example 1:
     *      input[] = {1, 3, 2, 5, 1, 3, 1, 5, 1}
     *      output = 1
     *
     *  Example 2:
     *      input[] = {1, 2}
     *      output = {1, 2}
     * </pre>
     *
     * @param input
     * @param k
     */
    public int findElementsAppearMoreThanNbyKTimes(Integer[] input, int k) {
        return findElements(input, k).size();
    }


}
