package com.devamatre.theorem.adts.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/11/23 4:34 PM
 */
public class SortTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortTest.class);

    /**
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     */
    @DataProvider
    public Iterator<Object[]> sortAscData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      Input: head = [3, 6, 1, 2, 9, 4]
         *      Output: [1, 2, 3, 4, 6, 9]
         *
         *  Example 2:
         *      Input: head = [2, 6, 8, 3, 5, 7, 1]
         *      Output: [1, 2, 3, 5, 6, 7, 8]
         *
         *  Example 3:
         *      Input: head = [1]
         *      Output: [1]
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{3, 6, 1, 2, 9, 4}, new Integer[]{1, 2, 3, 4, 6, 9}});
        inputs.add(new Object[]{new Integer[]{2, 6, 8, 3, 5, 7, 1}, new Integer[]{1, 2, 3, 5, 6, 7, 8}});
        inputs.add(new Object[]{new Integer[]{1}, new Integer[]{1}});

        return inputs.iterator();
    }

    /**
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     */
    @DataProvider
    public Iterator<Object[]> sortDescData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      Input: head = [3, 6, 1, 2, 9, 4]
         *      Output: [9, 6, 4, 3, 2, 1]
         *
         *  Example 2:
         *      Input: head = [2, 6, 8, 3, 5, 7, 1]
         *      Output: [8, 7, 6, 5, 3, 2, 1]
         *
         *  Example 3:
         *      Input: head = [1]
         *      Output: [1]
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{3, 6, 1, 2, 9, 4}, new Integer[]{9, 6, 4, 3, 2, 1}});
        inputs.add(new Object[]{new Integer[]{2, 6, 8, 3, 5, 7, 1}, new Integer[]{8, 7, 6, 5, 3, 2, 1}});
        inputs.add(new Object[]{new Integer[]{1}, new Integer[]{1}});

        return inputs.iterator();
    }

}
