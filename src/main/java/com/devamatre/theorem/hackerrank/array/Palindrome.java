/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.hackerrank.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-01 09:59:54 AM
 * @since 1.0.0
 */
public class Palindrome {

    private Stack<Character> stack;
    private Queue<Character> queue;

    Palindrome() {
        stack = new Stack<Character>();
        queue = new LinkedList<Character>();
    }

    void pushCharacter(char ch) {
        stack.push(ch);
    }

    void enqueueCharacter(char ch) {
        queue.add(ch);
    }

    char popCharacter() {
        return stack.pop();
    }

    char dequeueCharacter() {
        return queue.poll();
    }

    /**
     * @param input
     * @return
     */
    public boolean isPalindrome(char[] input) {
        // Enqueue/Push all chars to their respective data structures:
        for (char sChar : input) {
            pushCharacter(sChar);
            enqueueCharacter(sChar);
        }

        /*
         * Pop/Dequeue the chars at the head of both data structures and compare them
         */
        for (int i = 0; i < input.length / 2; i++) {
            if (popCharacter() != dequeueCharacter()) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param input
     * @return
     */
    public boolean isPalindrome(String input) {
        if (input == null) {
            return true;
        }

        // Convert input String to an array of characters:
        return isPalindrome(input.toCharArray());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Create a Solution object:
        Palindrome obj = new Palindrome();
        // Finally, print whether string s is palindrome or not.
        System.out.println(
            "The word [" + input + "] is " + ((!obj.isPalindrome(input)) ? "not a palindrome." : "a palindrome."));
    }

}
