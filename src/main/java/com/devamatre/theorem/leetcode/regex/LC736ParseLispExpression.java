package com.devamatre.theorem.leetcode.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Author: Rohtash Singh Lakra Created: 8/22/20 12:05 PM Version: 1.0.0
 */
public class LC736ParseLispExpression {


    interface Expression {

        int eval();
    }

    class AddExpression implements Expression {

        private int left;
        private int right;

        public AddExpression(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int eval() {
            return (left + right);
        }
    }

    class MultiExpression implements Expression {

        private int left;
        private int right;

        public MultiExpression(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int eval() {
            return (left * right);
        }
    }

    class LetExpression implements Expression {

        private Map<String, Stack<Integer>> values;

        public LetExpression() {
            values = new HashMap<>();
        }

        public void add(String key, Integer value) {
            if (values.containsKey(key)) {
                values.get(key).push(value);
            } else {
                Stack<Integer> stack = new Stack<>();
                stack.push(value);
                values.put(key, stack);
            }
        }

        @Override
        public int eval() {
            return 0;
        }
    }

    private class ExpressionHandler {

        private String operation;
        private Expression expression;

        public ExpressionHandler(String operation, Expression expression) {
            this.operation = operation;
            this.expression = expression;
        }

        public int eval() {
            return expression.eval();
        }
    }


    public int evaluate(final String expression) {
        return 0;
    }

    /**
     * <pre>
     *  <code>(let x 2 (mult x (let x 3 y 4 (add x y))))</code>
     * </pre>
     *
     * @param expression
     * @return
     */
    public List<String> parse(final String expression) {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {

        }

        return tokens;
    }
}
