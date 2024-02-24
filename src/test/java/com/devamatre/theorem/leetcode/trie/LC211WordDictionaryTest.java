package com.devamatre.theorem.leetcode.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Aug 22, 2019 5:33:16 PM
 */
public class LC211WordDictionaryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC211WordDictionaryTest.class);

    /**
     * <pre>
     * Example:
     *  Input:
     *   ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     *   [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     *  Output:
     *  [null,null,null,null,false,true,true,true]
     *
     * Explanation
     *  WordDictionary wordDictionary = new WordDictionary();
     *  wordDictionary.addWord("bad");
     *  wordDictionary.addWord("dad");
     *  wordDictionary.addWord("mad");
     *  wordDictionary.search("pad"); // return False
     *  wordDictionary.search("bad"); // return True
     *  wordDictionary.search(".ad"); // return True
     *  wordDictionary.search("b.."); // return True
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        /*
         * Example:
         *  Input:
         *   ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
         *   [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
         *  Output:
         *  [null,null,null,null,false,true,true,true]
         */
        input.add(new Object[]{
            Arrays.asList("WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"),
            Arrays.asList(Arrays.asList(), Arrays.asList("bad"), Arrays.asList("dad"), Arrays.asList("mad"),
                          Arrays.asList("pad"), Arrays.asList("bad"), Arrays.asList(".ad"), Arrays.asList("b..")),
            Arrays.asList(null, null, null, null, false, true, true, true)});

        return input.iterator();
    }

    /**
     * Tests the <code>LC211WordDictionary</code> class.
     *
     * @param operation
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testWordDictionary(List<String> operation, List<List<String>> inputData, List<Object> expected) {
        LOGGER.debug("testWordDictionary({}, {}, {})", operation, inputData, expected);
        LC211WordDictionary instance = null;
        // ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        for (int i = 0; i < operation.size(); i++) {
            LOGGER.debug("operation:{}", operation.get(i));
            if (Objects.equals("WordDictionary", operation.get(i))) {
                instance = new LC211WordDictionary();
                assertNotNull(instance);
            } else if (Objects.equals("addWord", operation.get(i))) {
                instance.addWord(inputData.get(i).get(0));
            } else if (Objects.equals("search", operation.get(i))) {
                boolean result = instance.search(inputData.get(i).get(0));
                LOGGER.debug("result:{}", result);
                assertEquals(expected.get(i), result);
            }
        }
    }
}
