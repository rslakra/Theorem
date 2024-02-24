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
package com.devamatre.theorem.adts.trie;

/**
 * A prefix trie is an ordered tree data structure used in the representation of a set of strings over a finite alphabet
 * set, which allows efficient storage of words with common prefixes.
 *
 * <url>https://en.wikipedia.org/wiki/Trie</url>
 * <p>
 * Handle the following scenario's:
 * <pre>
 *  - keys
 *  - keys with wildcard
 *  - keys with prefix
 *  - longest prefix keys
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-11 05:07:59 PM
 * @since 1.0.0
 */
public interface Trie<E extends Comparable<? super E>> {

    /**
     * Returns the value of the key.
     *
     * @return
     */
    E getValue();

    /**
     * Returns the size of the trie.
     *
     * @return
     */
    int getSize();

    /**
     * Inserts the <code>key</code> in the trie.
     *
     * @param key
     */
    void insert(String key);

    /**
     * Returns true if the <code>key</code> exists otherwise false.
     *
     * @param key
     * @return
     */
    boolean find(String key);

    /**
     * Returns true if the <code>key</code> is deleted otherwise false.
     *
     * @param key
     * @return
     */
    boolean delete(String key);

}
