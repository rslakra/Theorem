package com.devamatre.theorem.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.LC394DecodeString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/4/23 11:41 AM
 */
public class LC394DecodeStringTest {


    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> decodeStringData() {
        List<Object[]> inputs = new ArrayList<>();

        // Example 1:
        // Input: s = "3[a]2[bc]"
        // Output: "aaabcbc"
        inputs.add(new Object[]{"3[a]2[bc]", "aaabcbc"});

        // Example 2:
        // Input: s = "3[a2[c]]"
        // Output: "accaccacc"
        inputs.add(new Object[]{"3[a2[c]]", "accaccacc"});

        // Example 3:
        // Input: s = "2[abc]3[cd]ef"
        // Output: "abcabccdcdcdef"
        inputs.add(new Object[]{"2[abc]3[cd]ef", "abcabccdcdcdef"});

        // Example 4:
        // Input: s = "100[leetcode]"
        // Output: "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
        inputs.add(new Object[]{"100[leetcode]",
                                "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param result
     */
    @Test(dataProvider = "decodeStringData")
    public void testDecodeString(String input, String result) {
        LC394DecodeString instance = new LC394DecodeString();
// assertEquals(result, instance.decodeString(input));
        assertEquals(result, instance.decodeStringWithQueue(input));
    }
}
