package com.devamatre.theorem.leetcode.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.lang.LC2139MinimumMovesToReachTargetScoreTest;
import com.devamatre.theorem.leetcode.hash.LC146LRUCache;
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
 * @created 1/12/24 10:28 AM
 */
public class LC146LRUCacheTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC2139MinimumMovesToReachTargetScoreTest.class);

    /**
     * <pre>
     * Input
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * Explanation
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // cache is {1=1}
     * lRUCache.put(2, 2); // cache is {1=1, 2=2}
     * lRUCache.get(1);    // return 1
     * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
     * lRUCache.get(2);    // returns -1 (not found)
     * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
     * lRUCache.get(1);    // return -1 (not found)
     * lRUCache.get(3);    // return 3
     * lRUCache.get(4);    // return 4
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // test 1
        input.add(new Object[]{
            // operations
            Arrays.asList("LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"),
            // input data
            Arrays.asList(Arrays.asList(2), Arrays.asList(1, 1), Arrays.asList(2, 2), Arrays.asList(1),
                          Arrays.asList(3, 3), Arrays.asList(2), Arrays.asList(4, 4), Arrays.asList(1),
                          Arrays.asList(3), Arrays.asList(4)),
            // output
            Arrays.asList(null, null, null, 1, null, -1, null, -1, 3, 4)});

        // test 2
        input.add(new Object[]{
            // operations
            Arrays.asList("LRUCache", "put", "get"),
            // input data
            Arrays.asList(Arrays.asList(1), Arrays.asList(2, 1), Arrays.asList(2)),
            // output
            Arrays.asList(null, null, 1)});

        // test 3
        input.add(new Object[]{
            // operations
            Arrays.asList("LRUCache", "put", "put", "put", "put", "get", "get"),
            // input data - [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
            Arrays.asList(Arrays.asList(2), Arrays.asList(2, 1), Arrays.asList(1, 1), Arrays.asList(2, 3),
                          Arrays.asList(4, 1), Arrays.asList(1), Arrays.asList(2)),
            // output
            Arrays.asList(null, null, null, null, null, -1, 3)});

        // test 4
        input.add(new Object[]{
            // operations
            Arrays.asList("LRUCache", "put", "put", "put", "get", "get", "put", "get", "get"),
            // input data - [[2],[2,1],[1,1],[2,3],[2],[2],[4,1],[2]]
            Arrays.asList(Arrays.asList(2), Arrays.asList(2, 1), Arrays.asList(1, 1), Arrays.asList(2, 3),
                          Arrays.asList(2), Arrays.asList(2), Arrays.asList(4, 1), Arrays.asList(1), Arrays.asList(2)),
            // output
            Arrays.asList(null, null, null, null, 3, 3, null, -1, 3)});

        // test 5
        input.add(new Object[]{
            // operations
            Arrays.asList("LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get",
                          "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get",
                          "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put",
                          "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put",
                          "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put",
                          "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get",
                          "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put",
                          "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get",
                          "put", "put", "put", "put", "put", "put", "put"),
            Arrays.asList(Arrays.asList(10), Arrays.asList(10, 13), Arrays.asList(3, 17), Arrays.asList(6, 11),
                          Arrays.asList(10, 5), Arrays.asList(9, 10), Arrays.asList(13), Arrays.asList(2, 19),
                          Arrays.asList(2), Arrays.asList(3), Arrays.asList(5, 25), Arrays.asList(8),
                          Arrays.asList(9, 22), Arrays.asList(5, 5), Arrays.asList(1, 30), Arrays.asList(11),
                          Arrays.asList(9, 12), Arrays.asList(7), Arrays.asList(5), Arrays.asList(8), Arrays.asList(9),
                          Arrays.asList(4, 30), Arrays.asList(9, 3), Arrays.asList(9), Arrays.asList(10),
                          Arrays.asList(10), Arrays.asList(6, 14), Arrays.asList(3, 1), Arrays.asList(3),
                          Arrays.asList(10, 11), Arrays.asList(8), Arrays.asList(2, 14), Arrays.asList(1),
                          Arrays.asList(5), Arrays.asList(4), Arrays.asList(11, 4), Arrays.asList(12, 24),
                          Arrays.asList(5, 18), Arrays.asList(13), Arrays.asList(7, 23), Arrays.asList(8),
                          Arrays.asList(12), Arrays.asList(3, 27), Arrays.asList(2, 12), Arrays.asList(5),
                          Arrays.asList(2, 9), Arrays.asList(13, 4), Arrays.asList(8, 18), Arrays.asList(1, 7),
                          Arrays.asList(6), Arrays.asList(9, 29), Arrays.asList(8, 21), Arrays.asList(5),
                          Arrays.asList(6, 30), Arrays.asList(1, 12), Arrays.asList(10), Arrays.asList(4, 15),
                          Arrays.asList(7, 22), Arrays.asList(11, 26), Arrays.asList(8, 17), Arrays.asList(9, 29),
                          Arrays.asList(5), Arrays.asList(3, 4), Arrays.asList(11, 30), Arrays.asList(12),
                          Arrays.asList(4, 29), Arrays.asList(3), Arrays.asList(9), Arrays.asList(6),
                          Arrays.asList(3, 4), Arrays.asList(1), Arrays.asList(10), Arrays.asList(3, 29),
                          Arrays.asList(10, 28), Arrays.asList(1, 20), Arrays.asList(11, 13), Arrays.asList(3),
                          Arrays.asList(3, 12), Arrays.asList(3, 8), Arrays.asList(10, 9), Arrays.asList(3, 26),
                          Arrays.asList(8), Arrays.asList(7), Arrays.asList(5), Arrays.asList(13, 17),
                          Arrays.asList(2, 27), Arrays.asList(11, 15), Arrays.asList(12), Arrays.asList(9, 19),
                          Arrays.asList(2, 15), Arrays.asList(3, 16), Arrays.asList(1), Arrays.asList(12, 17),
                          Arrays.asList(9, 1), Arrays.asList(6, 19), Arrays.asList(4), Arrays.asList(5),
                          Arrays.asList(5), Arrays.asList(8, 1), Arrays.asList(11, 7), Arrays.asList(5, 2),
                          Arrays.asList(9, 28), Arrays.asList(1), Arrays.asList(2, 2), Arrays.asList(7, 4),
                          Arrays.asList(4, 22), Arrays.asList(7, 24), Arrays.asList(9, 26), Arrays.asList(13, 28),
                          Arrays.asList(11, 26)),
            // output
            Arrays.asList(null, null, null, null, null, null, -1, null, 19, 17, null, -1, null, null, null, -1, null,
                          -1, 5, -1, 12, null, null, 3, 5, 5, null, null, 1, null, -1, null, 30, 5, 30, null, null,
                          null, -1, null, -1, 24, null, null, 18, null, null, null, null, -1, null, null, 18, null,
                          null, -1, null, null, null, null, null, 18, null, null, -1, null, 4, 29, 30, null, 12, -1,
                          null, null, null, null, 29, null, null, null, null, 17, 22, 18, null, null, null, -1, null,
                          null, null, 20, null, null, null, -1, 18, 18, null, null, null, null, 20, null, null, null,
                          null, null, null, null)});

        return input.iterator();
    }

    /**
     * Tests the <code>LRUCache()</code> Object.
     *
     * @param operations
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testLRUCache(List<String> operations, List<List<Integer>> inputData, List<Integer> expected) {
        LOGGER.debug("testLRUCache({}, {}, {})", operations, inputData, expected);
        // "LRUCache", "put", "put", "get"
        LC146LRUCache instance = null;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            List<Integer> input = inputData.get(i);
            LOGGER.debug("i:{}, {}({})", (i + 1), operation, input);
            Integer result = null;
            if ("LRUCache".equals(operation)) {
                instance = new LC146LRUCache(input.get(0));
            } else if ("put".equals(operation)) {
                if (instance == null) {
                    return;
                }
                // key, value pair
                instance.put(input.get(0), input.get(1));
            } else if ("get".equals(operation)) {
                if (instance == null) {
                    return;
                }
                // only key
                result = instance.get(input.get(0));
            }
            LOGGER.debug("instance:{}", instance);

            LOGGER.debug("result:{}", result);
            assertEquals(expected.get(i), result);
        }
    }

}
