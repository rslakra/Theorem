package com.rslakra.theorem.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rohtash Singh Lakra
 * @created 09/25/2017 08:09:43 AM
 */
public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        if (expression != null && expression.length() > 1) {
            for (int i = 0; i < expression.length(); i++) {
                char cChar = expression.charAt(i);
                switch (cChar) {
                    case '[':
                        stack.add(']');
                        break;
                    case '{':
                        stack.add('}');
                        break;
                    case '(':
                        stack.add(')');
                        break;
                    default:
                        if (stack.isEmpty() || stack.peek() != cChar) {
                            return false;
                        }
                        stack.pop();
                        break;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
        in.close();
    }
}
