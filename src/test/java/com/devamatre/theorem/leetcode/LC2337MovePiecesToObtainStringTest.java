package com.devamatre.theorem.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.LC2337MovePiecesToObtainString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/13/23 12:20 PM
 */
public class LC2337MovePiecesToObtainStringTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> canChangeData() {
        List<Object[]> inputs = new ArrayList<>();

// Example 1:
//
// Input: start = "_L__R__R_", target = "L______RR"
// Output: true
// Explanation: We can obtain the string target from start by doing the following moves:
// - Move the first piece one step to the left, start becomes equal to "L___R__R_".
// - Move the last piece one step to the right, start becomes equal to "L___R___R".
//            Since it is possible to get the string target from start, we return true.
        inputs.add(new Object[]{"_L__R__R_", "L______RR", true});

// Example 2:
// Input: start = "R_L_", target = "__LR"
// Output: false
// Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
//            After that, no pieces can move anymore, so it is impossible to obtain the string target from start.
        inputs.add(new Object[]{"R_L_", "__LR", false});

// Example 3:
// Input: start = "_R", target = "R_"
// Output: false
// Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.
        inputs.add(new Object[]{"_R", "R_", false});

        return inputs.iterator();
    }

    /**
     * @param source
     * @param target
     * @param result
     */
    @Test(dataProvider = "canChangeData")
    public void testCanChange(String source, String target, boolean result) {
        LC2337MovePiecesToObtainString instance = new LC2337MovePiecesToObtainString();
        assertEquals(result, instance.canChange(source, target));
    }
}
