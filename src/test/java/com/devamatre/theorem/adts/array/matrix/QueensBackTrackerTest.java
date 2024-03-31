package com.devamatre.theorem.adts.array.matrix;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/28/24 3:34 PM
 */
public class QueensBackTrackerTest {

    @Test
    public void testQueensBackTracking() {
        final List<int[]> inputData = new ArrayList<>();
        inputData.add(new int[]{0, 4, 7, 5, 2, 6, 1, 3});
        inputData.add(new int[]{0, 2, 4, 1, 7, 14, 11, 15, 12, 16, 5, 17, 6, 3, 10, 8, 13, 9});
        final QueensBackTracker backTracker = new QueensBackTracker();
        inputData.stream().forEach(input -> {
            System.out.println(Arrays.toString(backTracker.solve(input.length)));
        });
    }
}
