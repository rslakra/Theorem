package com.devamatre.theorem.adts;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 01/01/2024 5:37 PM
 */
public class PairTest {

    @Test
    public void testIntPair() {
        Pair<Integer, Integer> pair = new Pair<>(1, 2);
        assertEquals(1, pair.getKey());
        assertEquals(2, pair.getValue());
    }

    @Test
    public void testStringPair() {
        Pair<String, String> pair = new Pair<>("firstName", "Rohtash");
        assertEquals("firstName", pair.getKey());
        assertEquals("Rohtash", pair.getValue());
    }

    @Test
    public void testPair() {
        Pair<String, Integer> pair = new Pair<>("one", 1);
        assertEquals("one", pair.getKey());
        assertEquals(1, pair.getValue());
    }
}
