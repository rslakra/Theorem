package com.rslakra.theorem.algos.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/8/23 10:56 AM
 */
public class PatternTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatternTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printRectangleData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{4, 5, '*'});
        inputs.add(new Object[]{4, 5, '-'});
        inputs.add(new Object[]{4, 5, '|'});

        return inputs.iterator();
    }

    /**
     * Test <code>printRectangle()</code> method.
     */
    @Test(dataProvider = "printRectangleData")
    public void testPrintRectangle(int rows, int cols, char cChar) {
        LOGGER.debug("testPrintRectangle({}, {}, {})", rows, cols, cChar);
        Pattern instance = new Pattern();
        instance.printRectangle(rows, cols, cChar);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printHollowRectangleData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{4, 5, '*'});
        inputs.add(new Object[]{4, 5, '-'});
        inputs.add(new Object[]{4, 5, '|'});

        return inputs.iterator();
    }

    /**
     * Test <code>printHollowRectangle()</code> method.
     */
    @Test(dataProvider = "printHollowRectangleData")
    public void testPrintHollowRectangle(int rows, int cols, char cChar) {
        LOGGER.debug("testPrintHollowRectangle({}, {}, {})", rows, cols, cChar);
        Pattern instance = new Pattern();
        instance.printHollowRectangle(rows, cols, cChar);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printHalfPyramidData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5, '*'});
        inputs.add(new Object[]{5, '-'});
        inputs.add(new Object[]{5, '|'});
        inputs.add(new Object[]{5, '1'});

        return inputs.iterator();
    }

    /**
     * Test <code>printHalfPyramid()</code> method.
     */
    @Test(dataProvider = "printHalfPyramidData")
    public void testPrintHalfPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintHalfPyramid({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printHalfPyramid(rows, cChar);
    }

    /**
     * Test <code>printInvertedHalfPyramid()</code> method.
     */
    @Test(dataProvider = "printHalfPyramidData")
    public void testPrintInvertedHalfPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintInvertedHalfPyramid({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printInvertedHalfPyramid(rows, cChar);
    }

    /**
     * Test <code>printInvertedAndRotatedHalfPyramid()</code> method.
     */
    @Test(dataProvider = "printHalfPyramidData")
    public void testPrintInvertedAndRotatedHalfPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintInvertedAndRotatedHalfPyramid({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printInvertedAndRotatedHalfPyramid(rows, cChar);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printPyramidData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{4});
        inputs.add(new Object[]{5});

        return inputs.iterator();
    }

    /**
     * Test <code>printHalfPyramidWithNumbers()</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintHalfPyramidWithNumbers(int rows) {
        LOGGER.debug("testPrintHalfPyramidWithNumbers({})", rows);
        Pattern instance = new Pattern();
        instance.printHalfPyramidWithNumbers(rows);
    }

    /**
     * Test <code>printInvertedHalfPyramidWithNumbers()</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintInvertedHalfPyramidWithNumbers(int rows) {
        LOGGER.debug("testPrintInvertedHalfPyramidWithNumbers({})", rows);
        Pattern instance = new Pattern();
        instance.printInvertedHalfPyramidWithNumbers(rows);
    }

    /**
     * Test <code>printInvertedAndRotatedHalfPyramidWithNumbers()</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintInvertedAndRotatedHalfPyramidWithNumbers(int rows) {
        LOGGER.debug("testPrintInvertedAndRotatedHalfPyramidWithNumbers({})", rows);
        Pattern instance = new Pattern();
        instance.printInvertedAndRotatedHalfPyramidWithNumbers(rows);
    }

    /**
     * Test <code>printFloydsTriangle()</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintFloydsTriangle(int rows) {
        LOGGER.debug("testPrintFloydsTriangle({})", rows);
        Pattern instance = new Pattern();
        instance.printFloydsTriangle(rows);
    }

    /**
     * Test <code>printZeroOneTriangle()</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintZeroOneTriangle(int rows) {
        LOGGER.debug("testPrintZeroOneTriangle({})", rows);
        Pattern instance = new Pattern();
        instance.printZeroOneTriangle(rows);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printButterflyData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5, '*'});
        inputs.add(new Object[]{5, '-'});
        inputs.add(new Object[]{5, '|'});
        inputs.add(new Object[]{5, '#'});
        inputs.add(new Object[]{5, '_'});
        inputs.add(new Object[]{5, '+'});
        inputs.add(new Object[]{5, '='});

        return inputs.iterator();
    }

    /**
     * Test <code>printButterflyPattern()</code> method.
     */
    @Test(dataProvider = "printButterflyData")
    public void testPrintButterflyPattern(int rows, char cChar) {
        LOGGER.debug("testPrintButterflyPattern({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printButterflyPattern(rows, cChar);
    }

    /**
     * Test <code>printSolidRhombusPattern()</code> method.
     */
    @Test(dataProvider = "printButterflyData")
    public void testPrintSolidRhombusPattern(int rows, char cChar) {
        LOGGER.debug("testPrintSolidRhombusPattern({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printSolidRhombusPattern(rows, cChar);
    }


    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printNumberPyramidData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{3});
        inputs.add(new Object[]{4});
        inputs.add(new Object[]{5});

        return inputs.iterator();
    }

    /**
     * Test <code>printNumberPyramid()</code> method.
     */
    @Test(dataProvider = "printNumberPyramidData")
    public void testPrintNumberPyramid(int rows) {
        LOGGER.debug("testPrintNumberPyramid({})", rows);
        Pattern instance = new Pattern();
        instance.printNumberPyramid(rows);
    }

    /**
     * Test <code>printPalindromicPyramid()</code> method.
     */
    @Test(dataProvider = "printNumberPyramidData")
    public void testPrintPalindromicPyramid(int rows) {
        LOGGER.debug("testPrintPalindromicPyramid({})", rows);
        Pattern instance = new Pattern();
        instance.printPalindromicPyramid(rows);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printDiamondPyramidData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5, '*'});
        inputs.add(new Object[]{5, '-'});
        inputs.add(new Object[]{5, '|'});
        inputs.add(new Object[]{5, '#'});
        inputs.add(new Object[]{5, '_'});
        inputs.add(new Object[]{5, '+'});
        inputs.add(new Object[]{5, '='});

        return inputs.iterator();
    }

    /**
     * Test <code>printDiamondPyramid()</code> method.
     */
    @Test(dataProvider = "printDiamondPyramidData")
    public void testPrintDiamondPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintDiamondPyramid({})", rows);
        Pattern instance = new Pattern();
        instance.printDiamondPyramid(rows, cChar);
    }

    /**
     * Test <code>printHollowButterfly()</code> method.
     */
    @Test(dataProvider = "printDiamondPyramidData")
    public void testPrintHollowButterfly(int rows, char cChar) {
        LOGGER.debug("testPrintHollowButterfly({})", rows);
        Pattern instance = new Pattern();
        instance.printHollowButterfly(rows, cChar);
    }

    /**
     * Test <code>printHollowRhombus()</code> method.
     */
    @Test(dataProvider = "printDiamondPyramidData")
    public void testPrintHollowRhombus(int rows, char cChar) {
        LOGGER.debug("testPrintHollowRhombus({})", rows);
        Pattern instance = new Pattern();
        instance.printHollowRhombus(rows, cChar);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printPascalsTriangleData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{3});
        inputs.add(new Object[]{4});
        inputs.add(new Object[]{5});
        inputs.add(new Object[]{6});
        inputs.add(new Object[]{7});

        return inputs.iterator();
    }

    /**
     * Test <code>printPascalsTriangle()</code> method.
     */
    @Test(dataProvider = "printPascalsTriangleData")
    public void testPrintPascalsTriangle(int rows) {
        LOGGER.debug("testPrintPascalsTriangle({})", rows);
        Pattern instance = new Pattern();
        instance.printPascalsTriangle(rows);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> printNumberHalfPyramidData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{4});
        inputs.add(new Object[]{5});
        inputs.add(new Object[]{6});

        return inputs.iterator();
    }

    /**
     * Test <code>printNumberHalfPyramid()</code> method.
     */
    @Test(dataProvider = "printNumberHalfPyramidData")
    public void testPrintNumberHalfPyramid(int rows) {
        LOGGER.debug("testPrintNumberHalfPyramid({})", rows);
        Pattern instance = new Pattern();
        instance.printNumberHalfPyramid(rows);
    }

    /**
     * Test <code>printInvertedNumberHalfPyramid()</code> method.
     */
    @Test(dataProvider = "printNumberHalfPyramidData")
    public void testPrintInvertedNumberHalfPyramid(int rows) {
        LOGGER.debug("testPrintInvertedNumberHalfPyramid({})", rows);
        Pattern instance = new Pattern();
        instance.printInvertedNumberHalfPyramid(rows);
    }


}
