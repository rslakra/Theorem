package com.devamatre.theorem.algos.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 11/30/23 10:53 AM
 */
public class FindIntersection {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindIntersection.class);

    /**
     * Given an integer array of size n, find all elements that appear more than n/3 times?
     *
     * <pre>
     *  Example 1:
     *      input1[] = {3, 6, 9, 2, 9, 4}
     *      input2[] = {7, 3, 9}
     *      output[] = 6 => {3, 9}
     *
     *  Example 2:
     *      input1[] = {2, 6, 8, 3, 8, 0, 7, 4}
     *      input2[] = {3, 6, 9, 2, 9, 4}
     *      output[] = 8 => {2, 6, 3, 4}
     * </pre>
     */
    public List<Integer> findIntersection(Integer[] input1, Integer[] input2) {
        LOGGER.debug("findIntersection({}, {})", input1, input2);
        Set<Integer> set = new HashSet<>(Arrays.asList(input1));
        set.retainAll(Arrays.asList(input2));
        return new ArrayList<>(set);
    }

    /**
     * @param input1
     * @param input2
     * @return
     */
    public int findIntersectionCount(Integer[] input1, Integer[] input2) {
        return findIntersection(input1, input2).size();
    }

}
