package com.devamatre.theorem.algos.pattern;

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
        // through root (with root)
        inputs.add(new Object[]{4, 5, '*'});
        inputs.add(new Object[]{4, 5, '-'});
        inputs.add(new Object[]{4, 5, '|'});

        return inputs.iterator();
    }

    /**
     * Test <code>printRectangle</code> method.
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
        // through root (with root)
        inputs.add(new Object[]{4, 5, '*'});
        inputs.add(new Object[]{4, 5, '-'});
        inputs.add(new Object[]{4, 5, '|'});

        return inputs.iterator();
    }

    /**
     * Test <code>printHollowRectangle</code> method.
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
        // through root (with root)
        inputs.add(new Object[]{5, '*'});
        inputs.add(new Object[]{5, '-'});
        inputs.add(new Object[]{5, '|'});
        inputs.add(new Object[]{5, '1'});

        return inputs.iterator();
    }

    /**
     * Test <code>printHalfPyramid</code> method.
     */
    @Test(dataProvider = "printHalfPyramidData")
    public void testPrintHalfPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintHalfPyramid({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printHalfPyramid(rows, cChar);
    }

    /**
     * Test <code>printInvertedHalfPyramid</code> method.
     */
    @Test(dataProvider = "printHalfPyramidData")
    public void testPrintInvertedHalfPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintInvertedHalfPyramid({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printInvertedHalfPyramid(rows, cChar);
    }

    /**
     * Test <code>printInvertedAndRotatedHalfPyramid</code> method.
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
        // through root (with root)
        inputs.add(new Object[]{4});
        inputs.add(new Object[]{5});

        return inputs.iterator();
    }

    /**
     * Test <code>printHalfPyramidWithNumbers</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintHalfPyramidWithNumbers(int rows) {
        LOGGER.debug("testPrintHalfPyramidWithNumbers({})", rows);
        Pattern instance = new Pattern();
        instance.printHalfPyramidWithNumbers(rows);
    }

    /**
     * Test <code>printInvertedHalfPyramidWithNumbers</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintInvertedHalfPyramidWithNumbers(int rows) {
        LOGGER.debug("testPrintInvertedHalfPyramidWithNumbers({})", rows);
        Pattern instance = new Pattern();
        instance.printInvertedHalfPyramidWithNumbers(rows);
    }

    /**
     * Test <code>printInvertedAndRotatedHalfPyramidWithNumbers</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintInvertedAndRotatedHalfPyramidWithNumbers(int rows) {
        LOGGER.debug("testPrintInvertedAndRotatedHalfPyramidWithNumbers({})", rows);
        Pattern instance = new Pattern();
        instance.printInvertedAndRotatedHalfPyramidWithNumbers(rows);
    }

    /**
     * Test <code>printFloydsTriangle</code> method.
     */
    @Test(dataProvider = "printPyramidData")
    public void testPrintFloydsTriangle(int rows) {
        LOGGER.debug("testPrintFloydsTriangle({})", rows);
        Pattern instance = new Pattern();
        instance.printFloydsTriangle(rows);
    }

    /**
     * Test <code>printZeroOneTriangle</code> method.
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
        // through root (with root)
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
     * Test <code>printButterflyPattern</code> method.
     */
    @Test(dataProvider = "printButterflyData")
    public void testPrintButterflyPattern(int rows, char cChar) {
        LOGGER.debug("testPrintButterflyPattern({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printButterflyPattern(rows, cChar);
    }

    /**
     * Test <code>printButterflyPattern</code> method.
     */
    @Test(dataProvider = "printButterflyData")
    public void testPrintSolidRhombusPattern(int rows, char cChar) {
        LOGGER.debug("testPrintSolidRhombusPattern({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printSolidRhombusPattern(rows, cChar);
    }

    /**
     * Test <code>printNumberPyramid</code> method.
     */
    @Test(dataProvider = "printButterflyData")
    public void testPrintNumberPyramid(int rows, char cChar) {
        LOGGER.debug("testPrintNumberPyramid({}, {})", rows, cChar);
        Pattern instance = new Pattern();
        instance.printNumberPyramid(rows, cChar);
    }


}
