package com.devamatre.theorem.leetcode.array.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.array.matrix.LC54SpiralMatrix;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/12/23 4:26 PM
 */
public class LC54SpiralMatrixTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> spiralOrderData() {
        List<Object[]> inputs = new ArrayList<>();

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
        inputs.add(new Object[]{
            new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
        });

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
        inputs.add(new Object[]{
            new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
            Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
        });

        return inputs.iterator();
    }

    /**
     * @param input
     * @param result
     */
    @Test(dataProvider = "spiralOrderData")
    public void testSpiralOrder(int[][] input, List<Integer> result) {
        LC54SpiralMatrix instance = new LC54SpiralMatrix();
        assertEquals(result, instance.spiralOrder(input));
    }
}
