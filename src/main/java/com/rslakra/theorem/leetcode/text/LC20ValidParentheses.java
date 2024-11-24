package com.rslakra.theorem.leetcode.text;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * /**
 * <url>https://leetcode.com/problems/valid-parentheses</url>
 * <p>
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order. Every
 * close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "()"
 * Output: true
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 * Input: s = "()[]{}"
 * Output: true
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "(]"
 * Output: false
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 10/13/23 11:48 AM
 */
public class LC20ValidParentheses {

    /**
     * <url>https://leetcode.com/problems/valid-parentheses</url>
     * LeetCode – Valid Parentheses (Java)
     * <p>
     * <p>
     * Given a input containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input input is
     * valid.
     * <p>
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     * <p>
     * Analysis
     * <p>
     * A typical problem which can be solved by using a stack data structure.
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Memory Complexity: O(N)
     * </pre>
     *
     * @param input
     * @return
     */
    public boolean validParentheses(String input) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char cChar = input.charAt(i);
            if (map.containsKey(cChar)) {
                stack.push(cChar);
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()) == cChar) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * <url>https://leetcode.com/problems/valid-parentheses</url>
     * <pre>
     *  Time Complexity: O(N)
     *  Memory Complexity: O(N)
     * </pre>
     *
     * @param input
     * @return
     */
    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char cChar : input.toCharArray()) {
            if (cChar == '(') {
                stack.push(')');
            } else if (cChar == '{') {
                stack.push('}');
            } else if (cChar == '[') {
                stack.push(']');
            } else {
                if (!stack.isEmpty() && stack.peek() == cChar) {
                    stack.pop();
                } else {
                    // mandatory to return here because of wrong sequence of char
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC20ValidParentheses instance = new LC20ValidParentheses();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        System.out.println(str + " = " + instance.isValid(str));
    }
}
