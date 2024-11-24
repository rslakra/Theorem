package com.rslakra.theorem.algos.array;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/14/23 4:00 PM
 */
public class GetMaxAdditionalDinersCountTest {

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getMaxAdditionalDinersCountData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{10, 1, 2, new long[]{2, 6}, 3});
        inputs.add(new Object[]{15, 2, 3, new long[]{11, 6, 14}, 1});
        return inputs.iterator();
    }

    /**
     * Test <code>getMaxAdditionalDinersCount()</code> method.
     */
    @Test(dataProvider = "getMaxAdditionalDinersCountData")
    public void testGetMaxAdditionalDinersCount(long N, long K, int M, long[] S, long expected) {
        GetMaxAdditionalDinersCount instance = new GetMaxAdditionalDinersCount();
        assertEquals(expected, instance.getMaxAdditionalDinersCount(N, K, M, S));
    }
}
