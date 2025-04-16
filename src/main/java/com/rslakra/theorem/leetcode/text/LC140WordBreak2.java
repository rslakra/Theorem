package com.rslakra.theorem.leetcode.text;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Rohtash Lakra
 * Created: 4/11/20 9:46 AM
 * Version: 1.0.0
 */
public class LC140WordBreak2 {

    /**
     * <url>https://leetcode.com/problems/word-break-ii</url>
     *
     * @param input
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String input, List<String> wordDict) {
        List<String> wordBreak = new ArrayList<>();
        for (int i = 1; i < input.length(); i++) {
            String word = input.substring(0, i);
            if (wordDict.contains(word)) {
                wordBreak.add(word);
            }
        }

        return wordBreak;
    }

}
