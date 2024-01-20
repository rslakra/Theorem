package com.devamatre.theorem.algos.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/5/24 6:05 PM
 */
public class StringMutationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringMutationTest.class);

    @DataProvider
    public Iterator<Object[]> strMutationData() {
        List<Object[]> input = new LinkedList<>();
        input.add(new Object[]{"ab", Arrays.asList("a", "b", "ab", "")});
        input.add(new Object[]{"abc", Arrays.asList("a", "b", "c", "ab", "ac", "bc", "abc", "")});
        return input.iterator();
    }

    /**
     * Test <code>findMutations()</code> method.
     */
    @Test(dataProvider = "strMutationData")
    public void testFindMutations(String inputData, List<String> expected) {
        LOGGER.debug("testFindMutations()");
        StringMutation instance = new StringMutation();
        List<String> mutations = instance.findMutations(inputData);
        LOGGER.debug("mutations:{}", mutations);
        assertEquals(expected, mutations);
    }

}
