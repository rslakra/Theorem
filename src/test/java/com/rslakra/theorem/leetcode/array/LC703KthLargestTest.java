package com.rslakra.theorem.leetcode.array;

import com.rslakra.theorem.adts.array.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 04/19/2024 2:47 PM
 */
public class LC703KthLargestTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC703KthLargestTest.class);

    /**
     * <pre>
     *  Example 1:
     *
     *  Input
     *   ["KthLargest", "add", "add", "add", "add", "add"]
     *   [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     *
     *   Output
     *   [null, 4, 5, 5, 8, 8]
     *
     * Explanation
     *  KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
     *  kthLargest.add(3);   // return 4
     *  kthLargest.add(5);   // return 5
     *  kthLargest.add(10);  // return 5
     *  kthLargest.add(9);   // return 8
     *  kthLargest.add(4);   // return 8
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{
                Arrays.asList("KthLargest", "add", "add", "add", "add", "add"),
                Arrays.asList(Arrays.asList(3, 4, 5, 8, 2), Arrays.asList(3), Arrays.asList(5), Arrays.asList(10), Arrays.asList(9), Arrays.asList(4)),
                Arrays.asList(null, 4, 5, 5, 8, 8)
        });

        return input.iterator();
    }

    /**
     * Tests the <code>KthLargest()</code> class.
     *
     * @param actions
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testKthLargest(List<String> actions, List<List<Integer>> inputData, List<Integer> expected) {
        LOGGER.debug("testKthLargest({}, {}, {})", actions, inputData, expected);
        LC703KthLargest instance = null;
        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i);
            if ("KthLargest".equals(action)) {
                List<Integer> data = new ArrayList<>(inputData.get(i));
                int k = data.remove(0);
                int[] nums = ArrayUtils.toIntArray(data);
                instance = new LC703KthLargest(k, nums);
            } else if ("add".equals(action)) {
                int result = instance.add(inputData.get(i).get(0));
                LOGGER.debug("i:{}, result:{}, expected:{}", i, result, expected.get(i));
                assertEquals(expected.get(i).intValue(), result);
            }
        }
    }
}
