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
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-11 05:07:59 PM
 * @since 1.0.0
 */
public class Trie {

    /* head */
    private TrieNode head;

    public Trie() {
        head = new TrieNode();
    }

    /**
     * Inserts the given key int the trie structure.
     *
     * @param key
     */
    public void insert(String key) {
        head.insert(key);
    }

    /**
     * Returns true if the key exists otherwise false.
     *
     * @param key
     * @return
     */
    public boolean find(String key) {
        return head.find(key);
    }

    /**
     * Returns true if the key is deleted otherwise false.
     *
     * @param key
     * @return
     */
    public boolean delete(String key) {
        return head.delete(head, key);
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return head.toString();
    }

    /**
     * Maintains the trie data structure.
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("an");
        trie.insert("and");
        trie.insert("are");
        trie.insert("am");
        trie.insert("any");
        trie.insert("lakra");
        trie.insert("lion");
        trie.insert("leo");
        System.out.println(trie);
        System.out.println();

        // find key
        System.out.println("Found:" + trie.find("may"));
        System.out.println("Found:" + trie.find("lakra"));
        System.out.println("Found:" + trie.find("leo"));
        System.out.println();

        // delete key
        System.out.println("Deleted:" + trie.delete("leo"));
        System.out.println("Deleted:" + trie.delete("an"));
        System.out.println();
    }
}
