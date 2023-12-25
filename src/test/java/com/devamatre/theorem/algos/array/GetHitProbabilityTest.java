package com.devamatre.theorem.algos.array;

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
public class GetHitProbabilityTest {

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getHitProbabilityData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{3, 2, new int[][]{{0, 0, 1}, {1, 0, 1}}, 0.50000000});
        inputs.add(new Object[]{2, 2, new int[][]{{1, 1}, {1, 1}}, 1.00000000});
        return inputs.iterator();
    }

    /**
     * Test <code>getHitProbability()</code> method.
     */
    @Test(dataProvider = "getHitProbabilityData")
    public void testGetHitProbability(int R, int C, int[][] G, double expected) {
        GetHitProbability instance = new GetHitProbability();
        assertEquals(expected, instance.getHitProbability(R, C, G));
    }
}
