package com.rslakra.theorem.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 10/4/23 11:41 AM
 */
public class LC394DecodeString {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC394DecodeString.class);

    /**
     * @param cChar
     * @return
     */
    private boolean isNumeric(char cChar) {
        return (cChar >= '0' && cChar <= '9');
    }

    /**
     * @param count
     * @param input
     * @return
     */
    @Deprecated
    private String fillWith(int count, String input) {
        StringBuilder sBuilder = new StringBuilder();
        while (count > 0) {
            sBuilder.append(input);
            count--;
        }

        return sBuilder.toString();
    }

    /**
     * @param input
     * @return
     */
    public String decodeString(String input) {
        LOGGER.debug("+decodeString({})", input);
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> parts = new Stack<>();
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (char cChar : input.toCharArray()) {
            LOGGER.debug("cChar:{}, nums:{}, parts:{}, str:{}", cChar, nums, parts, str);
            if (isNumeric(cChar)) {
                count = count * 10 + (cChar - '0');
            } else if (cChar == '[') {
                parts.push(str);
                str = new StringBuilder();
                nums.push(count);
                count = 0;
            } else if (cChar == ']') {
//                String temp = str.toString();
//                str = new StringBuilder(parts.pop() + fillWith(nums.pop(), temp));
                str = new StringBuilder(parts.pop() + str.toString().repeat(nums.pop()));
            } else {
                str.append(cChar);
            }
        }

        LOGGER.debug("-decodeString(), str:{}", str);
        return str.toString();
    }


    private String dfs(Queue<Character> queue) {
        LOGGER.debug("+dfs({})", queue);
        StringBuilder sBuilder = new StringBuilder();
        int count = 0;
        while (!queue.isEmpty()) {
            LOGGER.debug("queue:{}, sBuilder:{}", queue, sBuilder);
            Character cChar = queue.poll();
            if (isNumeric(cChar)) {
                count = count * 10 + (cChar - '0');
            } else if (cChar == '[') {
                sBuilder.append(dfs(queue).repeat(count));
                count = 0;
            } else {
                if (cChar == ']') {
                    break;
                }

                sBuilder.append(cChar);
            }
        }

        LOGGER.debug("-dfs(), sBuilder:{}", sBuilder);
        return sBuilder.toString();
    }

    /**
     * @param input
     * @return
     */
    public String decodeStringWithQueue(String input) {
        Queue<Character> queue = new ArrayDeque<>();
        for (char cChar : input.toCharArray()) {
            queue.offer(cChar);
        }

        String str = dfs(queue);
        LOGGER.debug("-decodeString(), str:{}", str);
        return str.toString();
    }
}
