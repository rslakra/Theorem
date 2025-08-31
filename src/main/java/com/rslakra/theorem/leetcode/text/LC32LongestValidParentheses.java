package com.rslakra.theorem.leetcode.text;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed)
 * parentheses substring .
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()" Output: 2 Explanation: The longest valid parentheses substring is "()". Example 2:
 * <p>
 * Input: s = ")()())" Output: 4 Explanation: The longest valid parentheses substring is "()()". Example 3:
 * <p>
 * Input: s = "" Output: 0
 *
 * @author Rohtash Lakra
 * @created 1/25/24 5:13 PM
 */
public class LC32LongestValidParentheses {

    static class Pair {

        int index;
        char cChar;

        Pair(int index, char cChar) {
            this.index = index;
            this.cChar = cChar;
        }

        public String toString() {
            return "<index=" + index + ", cChar=" + cChar + ">";
        }
    }

    /**
     * <url>https://leetcode.com/problems/longest-valid-parentheses</url>
     *
     * @param str
     * @return
     */
    public int longestValidParentheses(String str) {
        if (str == null) {
            return 0;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char cChar = str.charAt(i);
            if (cChar == '(') {
                stack.push(cChar);
            } else {
                if (!stack.isEmpty() && cChar == ')') {
                    stack.push(cChar);
                }
            }
        }
        System.out.println("stack: " + stack);

        // a)!1@([(2)]x(yz)))()
        // (()())()
        StringBuilder sBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            sBuilder.insert(0, stack.pop());
        }
        System.out.println("sBuilder:" + sBuilder + ", size:" + sBuilder.length());

        Stack<Pair> pairs = new Stack();
        for (int i = 0; i < sBuilder.length(); i++) {
            System.out.println("sBuilder[" + i + "]:" + sBuilder.charAt(i));
            if (sBuilder.charAt(i) == '(') {
                pairs.push(new Pair(i, sBuilder.charAt(i)));
            } else if (sBuilder.charAt(i) == ')') {
                if (pairs.isEmpty()) {
                    pairs.push(new Pair(i, sBuilder.charAt(i)));
                } else {
                    Pair pair = pairs.peek();
                    System.out.println("pair:" + pair);
                    if (pair.cChar == '(') {
                        pairs.pop();
                    }
                }
            }
        }
        System.out.println("pairs:" + pairs);

        while (!pairs.isEmpty()) {
            Pair pair = pairs.pop();
            sBuilder.delete(pair.index, pair.index + 1);
        }
        System.out.println("sBuilder:" + sBuilder);

        return sBuilder.length();
    }

    /**
     * <url>https://leetcode.com/problems/longest-valid-parentheses</url>
     *
     * @param str
     * @return
     */
    public int longestValidParentheses2(String str) {
        if (str == null) {
            return 0;
        }

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sBuilder.append(str.charAt(i));
            } else if (str.charAt(i) == ')' && sBuilder.length() > 0) {
                sBuilder.append(str.charAt(i));
            }
        }

        Stack<Pair> stack = new Stack();
        for (int i = 0; i < sBuilder.length(); i++) {
            if (sBuilder.charAt(i) == '(') {
                stack.push(new Pair(i, sBuilder.charAt(i)));
            } else if (sBuilder.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    stack.push(new Pair(i, sBuilder.charAt(i)));
                } else {
                    Pair pair = stack.peek();
                    if (pair.cChar == '(') {
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            sBuilder.deleteCharAt(pair.index);
        }

        return sBuilder.length();
    }


    /**
     * <url>https://leetcode.com/problems/longest-valid-parentheses</url>
     *
     * @param str
     * @return
     */
    public int longestValidParentheses3(String str) {
        if (str == null) {
            return 0;
        }

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sBuilder.append(str.charAt(i));
            } else if (str.charAt(i) == ')' && sBuilder.length() > 0) {
                sBuilder.append(str.charAt(i));
            }
        }

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < sBuilder.length(); i++) {
            if (sBuilder.charAt(i) == '(') {
                stack.push(i);
            } else if (sBuilder.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    if (sBuilder.charAt(stack.peek()) == '(') {
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            sBuilder.deleteCharAt(stack.pop());
        }

        return sBuilder.length();
    }
}
