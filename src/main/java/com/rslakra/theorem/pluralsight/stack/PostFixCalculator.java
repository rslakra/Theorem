/**
 *
 */
package com.rslakra.theorem.pluralsight.stack;

import com.rslakra.appsuite.core.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 */
public class PostFixCalculator {

    private Stack<Integer> stack;
    private List<String> operators;

    public PostFixCalculator() {
        stack = new Stack<>();
        operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        operators.add("%");
    }

    /**
     * @param token
     * @return
     */
    public boolean isOperator(String token) {
        return operators.contains(token);
    }

    /**
     * @param operator
     * @param leftOperand
     * @param rightOperand
     * @return
     */
    private int evalExpression(final String operator, int leftOperand, int rightOperand) {
        int result = 0;
        switch (operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "/":
                result = leftOperand / rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "%":
                result = leftOperand % rightOperand;
                break;
        }

        return result;
    }

    /**
     * @param leftOperand
     * @param rightOperand
     * @param operator
     * @return
     */
    private String evalExpression(String operator, String leftOperand, String rightOperand) {
        int result = evalExpression(operator, Integer.parseInt(leftOperand), Integer.parseInt(rightOperand));
        return String.valueOf(result);
    }

    /**
     * <pre>
     * for each token in the postfix expression:
     *  if token is an operator:
     *     operand_2 ← pop from the stack
     *     operand_1 ← pop from the stack
     *     result ← evaluate token with operand_1 and operand_2
     *     push result back onto the stack
     *  else if token is an operand:
     *    push token onto the stack
     *  result ← pop from the stack
     * </pre>
     *
     * @param expr
     * @return
     */
    public int postFixEvaluation(String expr) {
        int result = 0;
        if (expr != null) {
            String[] tokens = expr.split(" ");
            for (int i = 0; i < tokens.length; i++) {
                if (TextUtils.isDigits(tokens[i])) {
                    stack.push(Integer.parseInt(tokens[i]));
                } else if (isOperator(tokens[i])) {
                    int right = stack.pop();
                    int left = stack.pop();
                    switch (tokens[i]) {
                        case "+":
                            result = left + right;
                            break;
                        case "-":
                            result = left - right;
                            break;
                        case "/":
                            result = left / right;
                            break;
                        case "*":
                            result = left * right;
                            break;
                        case "%":
                            result = left % right;
                            break;
                        default:
                            System.out.println("Invalid Expression Value:" + tokens[i]);
                            result = 0;
                            break;
                    }
                    stack.push(result);
                }
            }

            result = stack.pop();
        }

        return result;
    }

    /**
     * <pre>
     * for each token in the reversed postfix expression:
     *  if token is an operator:
     *    push token onto the operator stack
     *    pending_operand ← False
     *  else if token is an operand:
     *    operand ← token
     *    if pending_operand is True:
     *      while the operand stack is not empty:
     *        if peek from operand stack is operator:
     *          break;
     *        operand_1 ← pop from the operand stack
     *        operator ← pop from the operator stack
     *        operand ← evaluate operator with operand and operand_1
     *    push operand onto the operand stack
     *    pending_operand ← True
     * result ← pop from the operand stack
     * </pre>
     *
     * @param expr
     * @return
     */
    public int reversedPostFixEvaluation(String expr) {
        int result = 0;
        if (expr != null) {
            final Stack<String> stackOperands = new Stack<>();
            boolean operandPending = false;
            String operand = null;
            String[] tokens = expr.split(" ");
            for (int i = tokens.length - 1; i >= 0; i--) {
                if (isOperator(tokens[i])) {
                    stackOperands.push(tokens[i]);
                    operandPending = false;
                } else if (TextUtils.isDigits(tokens[i])) {
                    operand = tokens[i];
                    if (operandPending) {
                        while (!stackOperands.isEmpty()) {
                            if (isOperator(stackOperands.peek())) {
                                break;
                            }
                            String leftOperand = stackOperands.pop();
                            String operator = stackOperands.pop();
                            operand = evalExpression(operator, operand, leftOperand);
                        }
                    }
                    stackOperands.push(operand);
                    operandPending = true;
                }
            }

            result = Integer.parseInt(stackOperands.pop());
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        PostFixCalculator calculator = new PostFixCalculator();
        String expr = null;
        int result = 0;
        expr = "5 6 7 * + 1 -";
        result = calculator.postFixEvaluation(expr);
        System.out.println(result);
        result = calculator.reversedPostFixEvaluation(expr);
        System.out.println(result);
        System.out.println();

        expr = "15 7 1 1 + - / 3 * 2 1 1 + + -";
        result = calculator.postFixEvaluation(expr);
        System.out.println(result);
        result = calculator.reversedPostFixEvaluation(expr);
        System.out.println(result);
    }

}
