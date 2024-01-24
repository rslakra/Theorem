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
package com.devamatre.theorem.hackerrank.algos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-01 01:15:11 PM
 * @since 1.0.0
 */
public class MigratoryBirds {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    static int migratoryBirds(int n, int[] ar, boolean hardSolution) {
        int mostCommonBirds = 0;
        Map<Integer, Integer> birdTypes = new TreeMap<Integer, Integer>();
        for (int i = 0; i < ar.length; i++) {
            if (birdTypes.containsKey(ar[i])) {
                int value = birdTypes.get(ar[i]);
                value++;
                birdTypes.put(ar[i], value);
            } else {
                birdTypes.put(ar[i], 1);
            }
        }

        birdTypes = sortByValue(birdTypes);
        mostCommonBirds = birdTypes.keySet().toArray(new Integer[0])[0];
        return mostCommonBirds;
    }

    static class ArrayComparator implements Comparator<int[]> {

        /**
         * @param oldValue
         * @param newValue
         * @return
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(int[] newValue, int[] oldValue) {
            return (oldValue[1] == newValue[1] ? 0 : oldValue[1] > newValue[1] ? 1 : -1);
        }
    }

    static int migratoryBirds(int n, int[] ar) {
        int mostCommonBirds = 0;
        int[][] birdTypes = new int[5][2];
        for (int i = 0; i < ar.length; i++) {
            birdTypes[ar[i] - 1][0] = ar[i];
            birdTypes[ar[i] - 1][1] = ++birdTypes[ar[i] - 1][1];
        }

        Arrays.sort(birdTypes, new ArrayComparator());
        mostCommonBirds = birdTypes[0][0];

        return mostCommonBirds;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();

        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }

}
