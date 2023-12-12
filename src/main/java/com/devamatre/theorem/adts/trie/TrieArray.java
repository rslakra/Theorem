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
 * // keys // keys with wildcard // keys with prefix // longest prefix keys
 * <p>
 * A prefix trie is an ordered tree data structure used in the representation of a set of strings over a finite alphabet
 * set, which allows efficient storage of words with common prefixes.
 *
 * <url>https://en.wikipedia.org/wiki/Trie</url>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-11 05:07:59 PM
 * @since 1.0.0
 */
public class TrieArray implements Trie {

    static class TrieNode {

        private TrieNode[] children;
        private boolean leaf;

        public TrieNode() {
            // size 256 covers all unicode chars.
            children = new TrieNode[256];
        }
    }

    /* head */
    private TrieNode root;

    public TrieArray() {
        root = new TrieNode();
    }

    /**
     * Returns the size of the trie.
     *
     * @return
     */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * Inserts the <code>key</code> in the trie.
     *
     * @param key
     */
    @Override
    public void insert(String key) {

    }

    /**
     * Returns true if the <code>key</code> exists otherwise false.
     *
     * @param key
     * @return
     */
    @Override
    public boolean find(String key) {
        return false;
    }

    /**
     * Returns true if the <code>key</code> is deleted otherwise false.
     *
     * @param key
     * @return
     */
    @Override
    public boolean delete(String key) {
        return false;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see Object#toString()
     */
    public String toString() {
        return root.toString();
    }
}
