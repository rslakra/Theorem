package com.devamatre.theorem.leetcode.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.appsuite.core.BeanUtils;
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
 * @created 1/31/24 12:13 PM
 */
public class LC225ImplementStackUsingQueuesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC225ImplementStackUsingQueuesTest.class);

    /**
     * <pre>
     *  Your LC225ImplementStackUsingQueues object will be instantiated and called as such:
     *  LC225ImplementStackUsingQueues instance = new LC225ImplementStackUsingQueues();
     *  instance.push(x);
     *  int param_2 = instance.pop();
     *  int param_3 = instance.top();
     *  boolean param_4 = instance.empty();
     *
     * Example 1:
     * Input
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * Output
     * [null, null, null, 2, 2, false]
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{Arrays.asList("MyStack", "push", "push", "top", "pop", "empty"),
                               Arrays.asList(Arrays.asList(), Arrays.asList(1), Arrays.asList(2), Arrays.asList(),
                                             Arrays.asList(), Arrays.asList()),
                               Arrays.asList(null, null, null, 2, 2, false)});

        return input.iterator();
    }

    /**
     * Tests the <code>ImplementStackUsingQueues</code> class.
     *
     * @param operation
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testImplementStackUsingQueues(List<String> operation, List<List<Integer>> inputData,
                                              List<Integer> expected) {
        LOGGER.debug("testImplementStackUsingQueues({}, {}, {})", operation, inputData, expected);
        LC225ImplementStackUsingQueues instance = null;
        // "MyStack", "push", "push", "top", "pop", "empty"
        for (int i = 0; i < operation.size(); i++) {
            LOGGER.debug("operation:{}", operation.get(i));
            if (BeanUtils.equals("MyStack", operation.get(i))) {
                instance = new LC225ImplementStackUsingQueues();
                assertNotNull(instance);
            } else if (BeanUtils.equals("push", operation.get(i))) {
                instance.push(inputData.get(i).get(0));
            } else if (BeanUtils.equals("top", operation.get(i))) {
                int result = instance.top();
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
