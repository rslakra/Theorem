package com.devamatre.theorem.leetcode.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.text.LC140WordBreak2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/22/24 1:39 PM
 */
public class LC140WordBreak2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC140WordBreak2Test.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // test 1
        input.add(new Object[]{"catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"),
                               Arrays.asList("cats and dog", "cat sand dog")});
        input.add(new Object[]{"pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"),
                               Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple")});
        input.add(new Object[]{"catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), Arrays.asList()});

        return input.iterator();
    }

    /**
     * Tests the <code>wordBreak()</code> method.
     *
     * @param inputData
     * @param wordDict
     * @param expected
     */
    // @Test(dataProvider = "inputData")
    public void testCloseStrings(String inputData, List<String> wordDict, List<String> expected) {
        LOGGER.debug("testCloseStrings({}, {}, {})", inputData, wordDict, expected);
        LC140WordBreak2 instance = new LC140WordBreak2();
        List<String> result = instance.wordBreak(inputData, wordDict);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

}
