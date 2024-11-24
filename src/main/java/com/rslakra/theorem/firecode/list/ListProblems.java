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
package com.rslakra.theorem.firecode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-20 02:50:24 PM
 * @since 1.0.0
 */
public class ListProblems {

    /**
     * Given a List of Strings, write a method removeDuplicates that removes duplicate words from the List and returns
     * an ArrayList of all the unique words. The returned ArrayList should be lexically alphabetically.
     * <p>
     * Input: [Hi, Hello, Hey, Hi, Hello, Hey]
     * <p>
     * Output: [Hello, Hey, Hi]
     *
     * @param input
     * @return
     */
    public static ArrayList<String> removeDuplicates(List<String> input) {
        ArrayList<String> uniqueWords = new ArrayList<>();
        TreeSet<String> uniqueWordsSet = new TreeSet<>();
        uniqueWordsSet.addAll(input);
        uniqueWords.addAll(uniqueWordsSet);

        return uniqueWords;
    }

    /**
     * @param input
     * @return
     */
    public static ArrayList<String> removeDuplicatesOptimized(List<String> input) {
        return new ArrayList<>(new TreeSet<>(input));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> listWords = new ArrayList<>();
        listWords.add("Hi");
        listWords.add("Hey");
        listWords.add("Hello");
        listWords.add("Hi");
        listWords.add("Hey");
        listWords.add("Hello");
        // System.out.println(removeDuplicates(listWords));
        System.out.println(removeDuplicatesOptimized(listWords));
    }

}
