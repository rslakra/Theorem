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
package com.rslakra.theorem.algos.text;

import java.util.HashSet;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-15 01:46:24 PM
 * @since 1.0.0
 */
public class CountDistinctSubStrings {

    /**
     * @param str
     * @return
     */
    public static int countDistinctSubStrings(final String str) {
        HashSet<String> uniqueStrings = new HashSet<>();
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j <= str.length(); j++) {
                    uniqueStrings.add(str.substring(i, j));
                }
            }
        }

        System.out.println(uniqueStrings);
        return uniqueStrings.size();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countDistinctSubStrings("abc"));
        System.out.println(countDistinctSubStrings("abcd"));
    }

}
