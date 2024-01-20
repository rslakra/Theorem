package com.devamatre.theorem.adts.sort;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/2/24 7:21 PM
 */
public class SortsTest {

    @DataProvider
    public Iterator<Object[]> isSortedStrictlyData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{1}, true});
        inputs.add(new Object[]{new int[]{2, 1}, false});
        inputs.add(new Object[]{new int[]{1, 3, 6, 7, 9}, true});
        inputs.add(new Object[]{new int[]{2, 3, 4, 5, 6, 8}, true});
        inputs.add(new Object[]{new int[]{2, 3, 5, 6, 4, 8}, false});

        return inputs.iterator();
    }

    /**
     * Tests <code>isSortedStrictly()</code> method.
     *
     * @param input
     * @param expected
     */
    @Test(dataProvider = "isSortedStrictlyData")
    public void testIsSortedStrictly(int[] input, boolean expected) {
        assertEquals(expected, Sorts.isSortedStrictly(input));
    }

}
