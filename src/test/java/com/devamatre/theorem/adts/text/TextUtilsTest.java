package com.devamatre.theorem.adts.text;

import static com.devamatre.theorem.adts.text.TextUtils.search;
import static com.devamatre.theorem.adts.text.TextUtils.searchOptimized;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * @author Rohtash Lakra
 * @created 1/20/21 4:09 PM
 */
public class TextUtilsTest {

    @Test
    public void testSearchNullOrEmptyValue() {
        assertEquals(-1, search(null, null));
        assertEquals(-1, search("", ""));
        assertEquals(-1, search("lakra", ""));

        assertEquals(-1, searchOptimized(null, null));
        assertEquals(-1, searchOptimized("", ""));
        assertEquals(-1, searchOptimized("lakra", ""));
    }

    @Test
    public void testSearchPattern() {
        String text = "The quick brown fox jumps over the little lazy dog.";
        assertEquals(-1, search("hello", null));
        assertEquals(0, search("The", text));
        assertEquals(4, search("quick", text));
        assertEquals(16, search("fox", text));
        assertEquals(26, search("over", text));
        assertEquals(35, search("little", text));
        assertEquals(42, search("lazy", text));

        // little optimization with re-indexing
        assertEquals(-1, searchOptimized("hello", null));
        assertEquals(0, searchOptimized("The", text));
        assertEquals(4, searchOptimized("quick", text));
        assertEquals(16, searchOptimized("fox", text));
        assertEquals(26, searchOptimized("over", text));
        assertEquals(35, searchOptimized("little", text));
        assertEquals(42, searchOptimized("lazy", text));
    }

}
