package com.rslakra.theorem.coderbyte;

import static org.testng.AssertJUnit.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * https://javachallengers.com/tree-data-structure-with-java/
 * https://github.com/rajat4255/Tree-constructor/blob/main/main.py
 * https://coderbyte.com/solution/Tree%20Constructor
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 */
public class TreeConstructorTwoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeConstructorTwoTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // build input
        inputs.add(new Object[]{new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}, true});
        inputs.add(new Object[]{new String[]{"(1,2)", "(1,3)"}, false});
        inputs.add(new Object[]{new String[]{"(1,2)", "(2,4)", "(7,2)"}, true});
        inputs.add(new Object[]{new String[]{"(1,2)", "(7,2)"}, true});

        return inputs.iterator();
    }

    /**
     * Test <code>TreeConstructorTwo()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testTreeConstructorTwo(String[] input, boolean expected) {
        LOGGER.debug("testTreeConstructorTwo({}, {})", input, expected);
        boolean result = TreeConstructorTwo.treeConstructor(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
        System.out.println();
        assertEquals(expected, TreeConstructorTwo.treeConstructorWithGraph(input));
    }
}
