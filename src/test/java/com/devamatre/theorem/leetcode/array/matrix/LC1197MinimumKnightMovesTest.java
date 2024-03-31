package com.devamatre.theorem.leetcode.array.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/12/23 4:26 PM
 */
public class LC1197MinimumKnightMovesTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();

        // Example 1:
        // Input:
        //  matrix = [[1,2,3,4,5,6],[7,8,9,10,11,12],[13,14,15,16,17,18],[19,20,21,22,23,24,25],[26,27,28,29,30,31,32]]
        //  sourceX = 0, sourceY = 0, targetX = 2, targetY = 1
        // Output: 1
        // Explanation: [0, 0] → [2, 1]
        inputs.add(new Object[]{new int[5][5], 0, 0, 2, 1, 1});

        // Example 2:
        // Input:
        //  matrix = [[1,2,3,4,5,6],[7,8,9,10,11,12],[13,14,15,16,17,18],[19,20,21,22,23,24,25],[26,27,28,29,30,31,32]]
        //  sourceX = 0, sourceY = 0, targetX = 5, targetY = 5
        // Output: 4
        // Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
        inputs.add(new Object[]{new int[6][6], 0, 0, 5, 5, 4});

        // Example 3:
        // Input:
        //  matrix = [[1,2,3,4,5,6],[7,8,9,10,11,12],[13,14,15,16,17,18],[19,20,21,22,23,24,25],[26,27,28,29,30,31,32]]
        //  sourceX = 0, sourceY = 0, targetX = 5, targetY = 5
        // Output: 4
        // Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
        inputs.add(new Object[]{new int[5][6], 3, 2, 2, 5, 2});

        return inputs.iterator();
    }

    /**
     * @param grid
     * @param sourceX
     * @param sourceY
     * @param targetX
     * @param targetY
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testSpiralOrder(int[][] grid, int sourceX, int sourceY, int targetX, int targetY, int expected) {
        LC1197MinimumKnightMoves instance = new LC1197MinimumKnightMoves();
        int result = instance.findMinimumKnightMoves(grid, sourceX, sourceY, targetX, targetY);
        assertEquals(expected, result);
    }
}
