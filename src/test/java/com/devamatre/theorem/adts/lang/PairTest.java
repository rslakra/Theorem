package com.devamatre.theorem.adts.lang;

import static org.testng.Assert.assertEquals;

import com.devamatre.theorem.adts.lang.Pair;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/01/2024 5:37 PM
 */
public class PairTest {

    @Test
    public void testIntPair() {
        Pair<Integer, Integer> pair = Pair.of(1, 2);
        assertEquals(1, pair.getKey());
        assertEquals(2, pair.getValue());
    }

    @Test
    public void testStringPair() {
        Pair<String, String> pair = Pair.of("firstName", "Rohtash");
        assertEquals("firstName", pair.getKey());
        assertEquals("Rohtash", pair.getValue());
    }

    @Test
    public void testPair() {
        Pair<String, Integer> pair = Pair.of("one", 1);
        assertEquals("one", pair.getKey());
        assertEquals(1, pair.getValue());
    }
}
