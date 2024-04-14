package com.devamatre.theorem.leetcode.design;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/02/2024 8:14 AM
 */
public class LC1146SnapshotArrayTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC1146SnapshotArrayTest.class);

    /**
     * <pre>
     * Input: ["SnapshotArray","set","snap","set","get"]
     * [[3],[0,5],[],[0,6],[0,0]]
     * Output: [null,null,0,null,5]
     *
     * Explanation:
     * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
     * snapshotArr.set(0,5);  // Set array[0] = 5
     * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
     * snapshotArr.set(0,6);
     * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{
            Arrays.asList("SnapshotArray", "set", "snap", "set", "get"),
            Arrays.asList(Arrays.asList(3), Arrays.asList(0, 5), null, Arrays.asList(0, 6), Arrays.asList(0, 0)),
            Arrays.asList(null, null, 0, null, 5)
        });

        return input.iterator();
    }

    /**
     * Tests the <code>LC1146SnapshotArray</code> class.
     *
     * @param actions
     * @param inputs
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testSnapshotArray(List<String> actions, List<List<Integer>> inputs, List<Integer> expected) {
        LOGGER.debug("testSnapshotArray({}, {}, {})", actions, inputs, expected);
        LC1146SnapshotArray instance = null;
        for (int i = 0; i < actions.size(); i++) {
            List<Integer> inputData = inputs.get(i);
            LOGGER.debug("inputData:{}", inputData);
            // "SnapshotArray", "set", "snap", "set", "get"
            switch (actions.get(i)) {
                case "SnapshotArray":
                    instance = new LC1146SnapshotArray(inputData.get(0));
                    break;

                case "set":
                    instance.set(inputData.get(0), inputData.get(1));
                    break;

                case "snap":
                    instance.snap();
                    break;

                case "get":
                    int result = 0;
                    if (inputs.size() > 1) {
                        result = instance.get(inputData.get(0), inputData.get(1));
                    } else {
                        result = instance.get(inputData.get(0));
                    }
                    Optional<Integer> expectedOptional = Optional.of(expected.get(i));
                    LOGGER.debug("result:{}, expectedOptional:{}", result, expectedOptional);
                    assertEquals(expectedOptional.get(), result);
                    break;

                default:
                    LOGGER.debug("Invalid action:{}", actions.get(i));
                    break;
            }
        }
    }

}
