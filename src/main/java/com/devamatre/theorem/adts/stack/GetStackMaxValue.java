/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.devamatre.theorem.adts.stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-08 05:28:10 PM
 * @since 1.0.0
 */
public class GetStackMaxValue {

    private ListStack<Integer> listStack = new ListStack<>();
    private ListStack<Integer> maxStack = new ListStack<>();

    /**
     * @param item
     * @return
     */
    public void push(Integer item) {
        if (maxStack.isEmpty() || item >= maxStack.peek()) {
            maxStack.push(item);
        }
        listStack.push(item);
    }

    /**
     * @return
     */
    public Integer pop() {
        if (listStack.peek() == maxStack.peek()) {
            maxStack.pop();
        }
        return listStack.pop();
    }

    /**
     * @return
     */
    public Integer maxValue() {
        return maxStack.peek();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return listStack.toString();
    }

    /**
     *
     */
    public void printStack() {
        System.out.println(listStack.toString());
        System.out.println(maxStack.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        GetStackMaxValue maxStack = new GetStackMaxValue();
        maxStack.push(10);
        maxStack.push(4);
        maxStack.push(10);
        maxStack.push(1);
        maxStack.push(40);
        maxStack.push(21);
        maxStack.push(16);
        maxStack.push(30);
        maxStack.push(55);
        maxStack.printStack();

        System.out.println();
        System.out.println("Max Value:" + maxStack.maxValue());

        // remove element
        System.out.println();
        maxStack.pop();
        maxStack.pop();
        maxStack.pop();
        maxStack.pop();
        maxStack.pop();
        maxStack.pop();
        maxStack.pop();
        maxStack.printStack();
        System.out.println("Max Value:" + maxStack.maxValue());

    }

}
