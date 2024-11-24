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
public class GetWrongAnswersTest {

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getWrongAnswersData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{3, "ABA", "BAB"});
        inputs.add(new Object[]{5, "BBBBB", "AAAAA"});

        return inputs.iterator();
    }

    /**
     * Test <code>getWrongAnswers()</code> method.
     */
    @Test(dataProvider = "getWrongAnswersData")
    public void testGetWrongAnswers(int N, String C, String expected) {
        GetWrongAnswers instance = new GetWrongAnswers();
        assertEquals(expected, instance.getWrongAnswers(N, C));
    }
}
