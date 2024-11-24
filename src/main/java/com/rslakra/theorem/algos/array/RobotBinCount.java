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
package com.rslakra.theorem.algos.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-28 09:20:13 PM
 * @since 1.0.0
 */
public class RobotBinCount {

    /**
     * How many times will a robot need to retrieve bins if it is given an array of bin ID's and it can only hold N bins
     * at a time? When the robot is already holding N bins, it will return the least recently retrieved bin and store
     * the new bin.
     *
     * @param array
     * @param size
     * @return
     */
    public static int binCount(int[] array, int size) {
        int count = 0;
        if (array != null) {
            final List<Integer> cache = new LinkedList<Integer>();
            for (int i = 0; i < array.length; i++) {
                if (cache.contains(array[i])) {
                    cache.remove(Integer.valueOf(array[i]));
                } else {
                    count++;
                    if (size == cache.size()) {
                        cache.remove(0);
                    }
                }
                cache.add(array[i]);
            }
        }

        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] values = {2, 1, 6, 4, 8, 0, 9};
        System.out.println(binCount(values, values.length));
    }

}
