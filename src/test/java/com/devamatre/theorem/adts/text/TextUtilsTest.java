package com.devamatre.theorem.adts.text;

import static com.devamatre.theorem.adts.text.TextUtils.findExists;
import static com.devamatre.theorem.adts.text.TextUtils.findIndexOfFirstOccurrence;
import static com.devamatre.theorem.adts.text.TextUtils.search;
import static com.devamatre.theorem.adts.text.TextUtils.searchOptimized;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/20/21 4:09 PM
 */
public class TextUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextUtilsTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> findExistsData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{"", "", true});
        input.add(new Object[]{"", "lakra", false});
        input.add(new Object[]{"lakra", "", true});
        input.add(new Object[]{"lakra", "lakra", true});
        input.add(new Object[]{"rlakra", "lakra", false});
        input.add(new Object[]{"rohtak", "roh", true});
        input.add(new Object[]{"india", "indica", false});
        input.add(new Object[]{"asadcat", "sad", false});

        return input.iterator();
    }

    /**
     * Tests the <code>areEquals()</code> method.
     *
     * @param input
     * @param text
     * @param expected
     */
    @Test(dataProvider = "findExistsData")
    public void testFindExists(String input, String text, boolean expected) {
        LOGGER.debug("testFindExists({}, {}, {})", input, text, expected);
        boolean result = findExists(0, input, text);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> findIndexOfFirstOccurrenceData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{"", "", 0});
        input.add(new Object[]{"", "lakra", -1});
        input.add(new Object[]{"lakra", "", 0});
        input.add(new Object[]{"lakra", "lakra", 0});
        input.add(new Object[]{"rlakra", "lakra", 1});
        input.add(new Object[]{"rohtak", "roh", 0});
        input.add(new Object[]{"india", "indica", -1});
        input.add(new Object[]{"greatsadcat", "sad", 5});
        input.add(new Object[]{"mississippi", "issip", 4});
        input.add(new Object[]{"mississippi", "issipi", -1});

        return input.iterator();
    }

    /**
     * Tests the <code>findIndexOfFirstOccurrence()</code> method.
     *
     * @param input
     * @param text
     * @param expected
     */
    @Test(dataProvider = "findIndexOfFirstOccurrenceData")
    public void testFindIndexOfFirstOccurrence(String input, String text, int expected) {
        LOGGER.debug("testFindIndexOfFirstOccurrence({}, {}, {})", input, text, expected);
        int result = findIndexOfFirstOccurrence(input, text);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Tests the <code>search()</code> method.
     */
    @Test
    public void testSearchNullOrEmptyValue() {
        assertEquals(-1, search(null, null));
        assertEquals(-1, search("", ""));
        assertEquals(-1, search("lakra", ""));

        assertEquals(-1, searchOptimized(null, null));
        assertEquals(-1, searchOptimized("", ""));
        assertEquals(-1, searchOptimized("lakra", ""));
    }

    /**
     * Tests the <code>search()</code> method.
     */
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
