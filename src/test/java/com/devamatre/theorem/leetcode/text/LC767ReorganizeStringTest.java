package com.devamatre.theorem.leetcode.text;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/1/23 5:01 PM
 */
public class LC767ReorganizeStringTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> reorganizeStringData() {
        List<Object[]> inputs = new ArrayList<>();

        //        Example 1:
        //        Input: aab
        //        Output: aba
        inputs.add(new Object[]{"aab", Arrays.asList("aba")});

        //        Example 2:
        //        Input: aaabc
        //        Output: abaca
        inputs.add(new Object[]{"aaabc", Arrays.asList("abaca", "acaba")});

        //        Example 3:
        //        Input: aaabb
        //        Output: ababa
        inputs.add(new Object[]{"aaabb", Arrays.asList("ababa")});

        //        Example 4:
        //        Input: aa
        //        Output: ""
        inputs.add(new Object[]{"aa", Arrays.asList("")});

        //        Example 5:
        //        Input: aaaabc
        //        Output: ""
        inputs.add(new Object[]{"aaaabc", Arrays.asList("")});

        //        Example 6:
        //        Input: aaab
        //        Output: ""
        inputs.add(new Object[]{"aaab", Arrays.asList("")});

        //        Example 7:
        //        Input: abbbbccabbc
        //        Output: bcbcbcbabab
        inputs.add(new Object[]{"abbbbccabbc", Arrays.asList("bcbcbcbabab", "bcbcbababcb")});

        //        Example 7:
        //        Input: aabbcc
        //        Output: abacbc
        inputs.add(new Object[]{"aabbcc", Arrays.asList("abacbc", "acbcab")});

        return inputs.iterator();
    }

    @Test(dataProvider = "reorganizeStringData")
    public void testReorganizeString(String input, List<String> result) {
        LC767ReorganizeString instance = new LC767ReorganizeString();
        assertTrue(result.contains(instance.reorganizeString(input)));
        assertTrue(result.contains(instance.reorganizeStringWithHeap(input)));
    }
}
