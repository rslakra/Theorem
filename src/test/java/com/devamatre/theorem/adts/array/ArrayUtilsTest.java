package com.devamatre.theorem.adts.array;

import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/08/2023 10:03 PM
 */
public class ArrayUtilsTest {

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrintMatrix() {
        ArrayUtils.printMatrix(new Integer[]{1, 2, 3, 4, 5});
    }

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrint2DMatrix() {
        Integer[][] data = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        ArrayUtils.printMatrix(data);
    }

    /**
     * Tests <code>printMatrix()</code> method.
     */
    @Test
    public void testPrintDiagonally() {
        Integer[][] data = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        ArrayUtils.printDiagonally(data);
    }
}
