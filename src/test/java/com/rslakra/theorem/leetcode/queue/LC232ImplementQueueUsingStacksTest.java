package com.rslakra.theorem.leetcode.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.appsuite.core.BeanUtils;
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
 * @created 1/31/24 12:15 PM
 */
public class LC232ImplementQueueUsingStacksTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(LC232ImplementQueueUsingStacksTest.class);

    /**
     * <pre>
     *  Your LC232ImplementQueueUsingStacks object will be instantiated and called as such:
     *  LC232ImplementQueueUsingStacks instance = new LC232ImplementQueueUsingStacks();
     *  instance.push(x);
     *  int param_2 = instance.pop();
     *  int param_3 = instance.top();
     *  boolean param_4 = instance.empty();
     *
     * Example 1:
     *  Input
     *   ["MyQueue", "push", "push", "peek", "pop", "empty"]
     *   [[], [1], [2], [], [], []]
     *  Output
     *   [null, null, null, 1, 1, false]
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{Arrays.asList("MyQueue", "push", "push", "peek", "pop", "empty"),
                               Arrays.asList(Arrays.asList(), Arrays.asList(1), Arrays.asList(2), Arrays.asList(),
                                             Arrays.asList(), Arrays.asList()),
                               Arrays.asList(null, null, null, 1, 1, false)});

        return input.iterator();
    }

    /**
     * Tests the <code>ImplementQueueUsingStacks</code> class.
     *
     * @param operation
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testImplementQueueUsingStacks(List<String> operation, List<List<Integer>> inputData,
                                              List<Integer> expected) {
        LOGGER.debug("testImplementQueueUsingStacks({}, {}, {})", operation, inputData, expected);
        LC232ImplementQueueUsingStacks instance = null;
        // "MyQueue", "push", "push", "peek", "pop", "empty"
        for (int i = 0; i < operation.size(); i++) {
            LOGGER.debug("operation:{}", operation.get(i));
            if (BeanUtils.equals("MyQueue", operation.get(i))) {
                instance = new LC232ImplementQueueUsingStacks();
                assertNotNull(instance);
            } else if (BeanUtils.equals("push", operation.get(i))) {
                instance.push(inputData.get(i).get(0));
            } else if (BeanUtils.equals("peek", operation.get(i))) {
                int result = instance.peek();
                LOGGER.debug("result:{}", result);
                assertEquals(expected.get(i), result);
            } else if (BeanUtils.equals("pop", operation.get(i))) {
                int result = instance.pop();
                LOGGER.debug("result:{}", result);
                assertEquals(expected.get(i), result);
            } else if (BeanUtils.equals("empty", operation.get(i))) {
                boolean result = instance.empty();
                LOGGER.debug("result:{}", result);
                assertEquals(expected.get(i), result);
            }
        }
    }
}
