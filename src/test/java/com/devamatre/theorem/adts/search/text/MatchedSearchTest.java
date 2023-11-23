package com.devamatre.theorem.adts.search.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.search.MatchedSearch;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 11/14/23 6:36 PM
 */
public class MatchedSearchTest {

    @Test
    public void testMatchedSearch() {
        String input = "The quick brown fox jumps over the little lazy dog.";
        String pattern = "fox";
        MatchedSearch matchedSearch = new MatchedSearchImpl(0, pattern.length());
        assertNotNull(matchedSearch);
        assertEquals(0, matchedSearch.start());
        assertEquals(3, matchedSearch.length());
    }
}
