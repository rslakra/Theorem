package com.rslakra.theorem.algos.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rslakra.theorem.adts.PrettyPrinter;
import com.rslakra.theorem.adts.array.ArrayUtils;
import com.rslakra.theorem.adts.array.TablePrettyPrinter;
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
 * @created 1/11/24 4:48 PM
 */
public class MazePathsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MazePathsTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> countPathsData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{2, 2}, 6});
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{2, 1}, 3});
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 2}, 3});
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 1}, 2});
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{0, 2}, 1});
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{2, 0}, 1});

        return inputs.iterator();
    }

    /**
     * Tests the <code>countPaths()</code> method.
     */
    @Test(dataProvider = "countPathsData")
    public void testCountPaths(int[][] inputData, int[] target, int expected) {
        LOGGER.debug("testCountPaths({}, {})", inputData, expected);
        MazePaths instance = new MazePaths();
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        prettyPrinter.prettyPrint(ArrayUtils.asIntList(inputData));
        int result = instance.countPaths(inputData, target);
        LOGGER.debug("inputData:{}, result:{}", inputData, result);
        assertEquals(expected, result);
    }


    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findPathsData() {
        List<Object[]> inputs = new ArrayList<>();
        // last row and last column
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{2, 2},
                                Arrays.asList(Arrays.asList(1, 2, 3, 6, 9), Arrays.asList(1, 2, 5, 6, 9),
                                              Arrays.asList(1, 2, 5, 8, 9), Arrays.asList(1, 4, 5, 6, 9),
                                              Arrays.asList(1, 4, 5, 8, 9), Arrays.asList(1, 4, 7, 8, 9))});
        // 2nd last row and last column
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 2},
                                Arrays.asList(Arrays.asList(1, 2, 3, 6), Arrays.asList(1, 2, 5, 6),
                                              Arrays.asList(1, 4, 5, 6))});
        // last row and 2nd last column
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{2, 1},
                                Arrays.asList(Arrays.asList(1, 2, 5, 8), Arrays.asList(1, 4, 5, 8),
                                              Arrays.asList(1, 4, 7, 8))});

        // center row and center column
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 1},
                                Arrays.asList(Arrays.asList(1, 2, 5), Arrays.asList(1, 4, 5))});

        // 1st row and last column
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{0, 2},
                                Arrays.asList(Arrays.asList(1, 2, 3))});

        // last row and 1st column
        inputs.add(new Object[]{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{2, 0},
                                Arrays.asList(Arrays.asList(1, 4, 7))});

        return inputs.iterator();
    }

    /**
     * Tests the <code>findPaths()</code> method.
     */
    @Test(dataProvider = "findPathsData")
    public void testFindPaths(int[][] inputData, int[] target, List<List<Integer>> expected) {
        LOGGER.debug("testFindPaths({}, {}, {})", inputData, Arrays.toString(target), expected);
        MazePaths instance = new MazePaths();
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        prettyPrinter.prettyPrint(ArrayUtils.asIntList(inputData));
        List<List<Integer>> result = instance.findPaths(inputData, target);
        LOGGER.debug("inputData:{}, result:{}", inputData, result);
        assertEquals(expected, result);
    }

}
