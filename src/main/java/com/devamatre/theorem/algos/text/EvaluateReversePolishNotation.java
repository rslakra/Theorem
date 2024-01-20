/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.algos.text;

import java.util.Arrays;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    private static final String OPERATORS = "+-*/";

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each
     * operand may be an integer or another expression. For example:
     * <p>
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     *
     * @param strings
     * @return
     */
    public int evalReversePolishNotation(String[] strings) {
        int result = 0;
        if (strings != null) {
            Stack<String> stack = new Stack<String>();
            for (String item : strings) {
                if (OPERATORS.contains(item)) {
                    int lastOperand = Integer.parseInt(stack.pop());
                    int lastFirstOperand = Integer.parseInt(stack.pop());
                    int index = OPERATORS.indexOf(item);
                    switch (index) {
                        case 0:
                            stack.push(String.valueOf((lastFirstOperand + lastOperand)));
                            break;
                        case 1:
                            stack.push(String.valueOf((lastFirstOperand - lastOperand)));
                            break;
                        case 2:
                            stack.push(String.valueOf((lastFirstOperand * lastOperand)));
                            break;
                        case 3:
                            stack.push(String.valueOf((lastFirstOperand / lastOperand)));
                            break;
                    }
                } else {
                    stack.push(item);
                }
            }

            result = Integer.parseInt(stack.pop());
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        String[] strings = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(Arrays.toString(strings) + " " + obj.evalReversePolishNotation(strings));
        strings = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(Arrays.toString(strings) + " " + obj.evalReversePolishNotation(strings));
    }

}
