package com.devamatre.theorem.algos.map;

import com.devamatre.appsuite.core.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 11/30/23 10:53 AM
 */
public class FindUnion {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindUnion.class);

    /**
     * Given an integer array of size n, find all elements that appear more than n/3 times?
     *
     * <pre>
     *  Example 1:
     *      input1[] = {3, 6, 9, 2, 9, 4}
     *      input2[] = {7, 3, 9}
     *      output[] = 6 => {3, 6, 9, 2, 4, 7}
     *
     *  Example 2:
     *      input1[] = {2, 6, 8, 3, 8, 0, 7, 4}
     *      input2[] = {3, 6, 9, 2, 9, 4}
     *      output[] = 8 => {2, 6, 8, 3, 0, 7, 4, 9}
     * </pre>
     */
    public List<Integer> findUnion(Integer[] input1, Integer[] input2) {
        LOGGER.debug("+findUnion({}, {})", input1, input2);
        Set<Integer> set = new HashSet<>(Sets.asSet(input1));
        set.addAll(Sets.asSet(input2));
        LOGGER.debug("-findUnion(), set:{}", set);
        return new ArrayList<>(set);
    }

    /**
     * @param input1
     * @param input2
     * @return
     */
    public int findUnionCount(Integer[] input1, Integer[] input2) {
        return findUnion(input1, input2).size();
    }

}
