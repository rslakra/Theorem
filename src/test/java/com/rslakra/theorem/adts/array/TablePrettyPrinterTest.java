package com.rslakra.theorem.adts.array;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rslakra.theorem.adts.PrettyPrinter;
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
 * @created 1/14/24 5:17 PM
 */
public class TablePrettyPrinterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TablePrettyPrinterTest.class);

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> prettyPrinterListOfStringData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(Arrays.asList("First Name", "Last Name", "Date of Birth", "Notes"),
                                              Arrays.asList("Rohtash", "Lakra", "Jan 6, 1975"),
                                              Arrays.asList("Rohtash", "Singh", "Jan 29, 1970", "Alias"),
                                              Arrays.asList("Singh", null, null, "(Yes/No)"))});

        return inputs.iterator();
    }

    /**
     * Tests the <code>printPretty()</code> method.
     */
    @Test(dataProvider = "prettyPrinterListOfStringData")
    public void testPrettyPrinterListOfString(List<List<String>> inputData) {
        LOGGER.debug("inputData:{}", inputData);
        PrettyPrinter<String> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        assertNotNull(prettyPrinter);
        prettyPrinter.prettyPrint(inputData);
        assertTrue(true);
    }


    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> prettyPrinterArrayOfStringData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new String[][]{new String[]{"First Name", "Last Name", "Date of Birth", "Notes"},
                                               new String[]{"Rohtash", "Lakra", "Jan 6, 1975"}, null,
                                               new String[]{"Rohtash", "Singh", "Jan 29, 1970", "Alias"},
                                               new String[]{"Singh", null, null, "(Yes/No)"},}});

        return inputs.iterator();
    }

    /**
     * Tests the <code>printPretty()</code> method.
     */
    @Test(dataProvider = "prettyPrinterArrayOfStringData")
    public void testPrettyPrinterArrayOfString(String[][] inputData) {
        LOGGER.debug("inputData:{}", inputData);
        PrettyPrinter<String> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        assertNotNull(prettyPrinter);
        prettyPrinter.prettyPrint(inputData);
        assertTrue(true);
    }


    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> prettyPrinterListOfIntegerData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{
            Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8, 9), Arrays.asList(10, 11, 12, 13),
                          Arrays.asList(14, null, null, 15, 16))});
        return inputs.iterator();
    }

    /**
     * Tests the <code>printPretty()</code> method.
     */
    @Test(dataProvider = "prettyPrinterListOfIntegerData")
    public void testPrettyPrinterListOfInteger(List<List<Integer>> inputData) {
        LOGGER.debug("inputData:{}", inputData);
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        assertNotNull(prettyPrinter);
        prettyPrinter.prettyPrint(inputData);
        assertTrue(true);
    }


    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> prettyPrinterArrayOfIntegerData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{
            new Integer[][]{new Integer[]{1, 2, 3, 4}, new Integer[]{5, 6, 7, 8}, null, new Integer[]{9, 10, 11, 12},
                            new Integer[]{13, null, null, 14},}});

        return inputs.iterator();
    }

    /**
     * Tests the <code>printPretty()</code> method.
     */
    @Test(dataProvider = "prettyPrinterArrayOfIntegerData")
    public void testPrettyPrinterArrayOfString(Integer[][] inputData) {
        LOGGER.debug("inputData:{}", inputData);
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        assertNotNull(prettyPrinter);
        prettyPrinter.prettyPrint(inputData);
        assertTrue(true);
    }
}
